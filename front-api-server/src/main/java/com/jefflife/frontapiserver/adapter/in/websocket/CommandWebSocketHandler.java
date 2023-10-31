package com.jefflife.frontapiserver.adapter.in.websocket;

import com.jefflife.frontapiserver.application.port.in.CommandExecutor;
import com.jefflife.frontapiserver.application.port.in.HtmlConverter;
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
        // TODO : 메세지 구독을 같이 처리하고 싶다..
        Flux<WebSocketMessage> socketMessageFlux = session.receive()
                .flatMap(msg -> commandExecutor.execute(msg.getPayloadAsText()))
                .flatMap(commandResult -> htmlConverter.convert(commandResult))
                .map(htmlResult -> session.textMessage(htmlResult.getHtml()));
        return session.send(socketMessageFlux);
    }
}
