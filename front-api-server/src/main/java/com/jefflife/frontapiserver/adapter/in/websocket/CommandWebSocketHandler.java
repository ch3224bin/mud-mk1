package com.jefflife.frontapiserver.adapter.in.websocket;

import com.jefflife.frontapiserver.application.port.in.CommandExecutor;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;

public class CommandWebSocketHandler implements WebSocketHandler {
    private final CommandExecutor commandExecutor;

    public CommandWebSocketHandler(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        return session.send(
                session.receive()
                        .flatMap(msg -> commandExecutor.execute(msg.getPayloadAsText()))
                        // TODO : 메세지 구독을 zip으로 같이 처리
                        // commandResult를 template 태운후 변환
                        .map(commandResult -> session.textMessage("Echo: " + commandResult.getPayload()))
        );
    }
}
