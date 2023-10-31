package com.jefflife.frontapiserver.application.port.out;

import com.jefflife.frontapiserver.application.domain.model.HtmlResult;
import reactor.core.publisher.Mono;

public interface HtmlCompilePort {
    Mono<HtmlResult> compile(String templateName, Object context);
}
