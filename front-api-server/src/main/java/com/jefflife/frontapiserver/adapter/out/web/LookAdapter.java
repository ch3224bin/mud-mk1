package com.jefflife.frontapiserver.adapter.out.web;

import com.jefflife.common.model.VisibleObject;
import com.jefflife.frontapiserver.application.domain.model.CommandData;
import com.jefflife.frontapiserver.application.port.out.LookPort;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class LookAdapter implements LookPort {

    private final String gameServerBasePath;
    private final String lookPath;
    private final WebClient webClient;

    public LookAdapter(@Value("${app.config.adapter.base-path.game-server}") String gameServerBasePath,
                       @Value("${app.config.adapter.path.look}") String lookPath) {
        this.gameServerBasePath = gameServerBasePath;
        this.lookPath = lookPath;
        this.webClient = WebClient.builder().baseUrl(gameServerBasePath).build();
    }

    @PostConstruct
    public void init() {

    }

    @Override
    public Mono<VisibleObject> look(long playerId, CommandData commandData) {
        return webClient.get()
                .uri(lookPath)
                .attribute("playerId", playerId)
                .attribute("target", commandData.getTarget())
                .attribute("payload", commandData.getPayload())
                .attribute("adverb", commandData.getAdverb())
                .attribute("action", commandData.getAction())
                .retrieve()
                .bodyToMono(VisibleObject.class);
    }
}
