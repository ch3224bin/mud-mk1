package com.jefflife.frontapiserver.adapter.in.websocket;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.ReplayProcessor;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CommandWebSocketHandlerTest {
    @LocalServerPort
    private String port;

    @Test
    public void test() throws Exception {
        WebSocketClient client = new ReactorNettyWebSocketClient();
        int count = 4;
        Flux<Integer> longFlux = Flux.range(1, count);
        ReplayProcessor<Object> output = ReplayProcessor.create(count);
        client.execute(getUrl("/command"), webSocketSession ->
                // send msg
                webSocketSession.send(
                        longFlux.map(i -> webSocketSession.textMessage("봐"))
                )
                .thenMany(
                        // receive message
                        webSocketSession.receive()
                                .take(count)
                                .map(WebSocketMessage::getPayloadAsText)
                )
                .subscribeWith(output)
                .then()
        ).block(Duration.ofSeconds(5));

//        assertEquals(longFlux.collectList().block(Duration.ofSeconds(5)), output.collectList().block(Duration.ofSeconds(5)));
    }

    protected URI getUrl(String path) throws URISyntaxException {
        return new URI("ws://localhost:" + this.port + path);
    }

}