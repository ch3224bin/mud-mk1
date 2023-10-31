package com.jefflife.frontapiserver.application.port.in;

import com.jefflife.frontapiserver.application.domain.model.CommandResult;
import reactor.core.publisher.Mono;

public interface CommandExecutor {
    Mono<CommandResult> execute(String commandText);
}
