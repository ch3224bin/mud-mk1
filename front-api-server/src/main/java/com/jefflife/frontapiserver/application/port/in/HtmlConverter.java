package com.jefflife.frontapiserver.application.port.in;

import com.jefflife.frontapiserver.application.domain.model.CommandResult;
import com.jefflife.frontapiserver.application.domain.model.HtmlResult;
import reactor.core.publisher.Mono;

public interface HtmlConverter {
    Mono<HtmlResult> convert(CommandResult commandResult);
}
