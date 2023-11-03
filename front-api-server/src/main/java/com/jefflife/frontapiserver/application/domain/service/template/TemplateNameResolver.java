package com.jefflife.frontapiserver.application.domain.service.template;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class TemplateNameResolver {
    public Mono<String> resolve(Object payload) {
        return Mono.just(TemplateMapper.findTemplateName(payload.getClass()));
    }
}
