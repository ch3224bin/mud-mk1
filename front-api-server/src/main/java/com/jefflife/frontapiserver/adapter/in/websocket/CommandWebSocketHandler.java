package com.jefflife.frontapiserver.adapter.in.websocket;

import com.jefflife.frontapiserver.application.domain.model.CommandResult;
import com.jefflife.frontapiserver.application.domain.model.HtmlResult;
import com.jefflife.frontapiserver.application.domain.service.template.ErrorMessageModel;
import com.jefflife.frontapiserver.application.port.in.CommandExecutor;
import com.jefflife.frontapiserver.application.port.in.HtmlConverter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CommandWebSocketHandler implements WebSocketHandler {
    private final CommandExecutor commandExecutor;
    private final HtmlConverter htmlConverter;

    public CommandWebSocketHandler(CommandExecutor commandExecutor, HtmlConverter htmlConverter) {
        this.commandExecutor = commandExecutor;
        this.htmlConverter = htmlConverter;
    }

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        // 스트림 중간에 Error가 발생하면 session이 취소된다. session이 취소되지 않도록 Error를 메세지로 변경하는 작업이 필요하다.
        // TODO : 메세지 구독을 같이 처리하고 싶다..
        Flux<WebSocketMessage> socketMessageFlux = session.receive()
                .filter(msg -> !StringUtils.isBlank(msg.getPayloadAsText()))
                .flatMap(msg -> commandExecutor.execute(msg.getPayloadAsText())
                        .onErrorResume(this::errorCommandResult)) // 코드 정리 필요
                .flatMap(commandResult -> htmlConverter.convert(commandResult)
                        .onErrorResume(this::errorHtmlResult)) // 코드 정리 필요
                .map(htmlResult -> session.textMessage(htmlResult.getHtml()))
                .doOnError(e ->  {
                    session.textMessage("Error : " + e.getMessage());
                })
                .doFinally(status -> System.out.println("doFinally : " + status));
        return session.send(socketMessageFlux);
    }

    private Mono<CommandResult> errorCommandResult(Throwable e) {
        System.out.println("errorCommandResult : " + e.getMessage());
        ErrorMessageModel errorMessageModel = new ErrorMessageModel(e.getMessage());
        return Mono.just(new CommandResult(null, errorMessageModel));
    }

    private Mono<HtmlResult> errorHtmlResult(Throwable e) {
        System.out.println("errorHtmlResult : " + e.getMessage());
        return Mono.just(new HtmlResult(e.getMessage()));
    }
}
