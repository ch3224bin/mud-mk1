package com.jefflife.frontapiserver.adapter.configuration;

import com.jefflife.frontapiserver.adapter.in.websocket.CommandWebSocketHandler;
import com.jefflife.frontapiserver.application.port.in.CommandExecutor;
import com.jefflife.frontapiserver.application.port.in.HtmlConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class WebSocketConfiguration {
    private static final String WS_PATH_COMMAND = "/command";

    @Bean
    public HandlerMapping webSocketMapping(CommandWebSocketHandler commandWebSocketHandler) {
        Map<String, WebSocketHandler> map = new HashMap<>();
        map.put(WS_PATH_COMMAND, commandWebSocketHandler);

        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        mapping.setUrlMap(map);
        mapping.setOrder(-1); // 우선순위를 높게 설정
        return mapping;
    }

    @Bean
    public CommandWebSocketHandler commandWebSocketHandler(CommandExecutor commandExecutor, HtmlConverter htmlConverter) {
        return new CommandWebSocketHandler(commandExecutor, htmlConverter);
    }
}
