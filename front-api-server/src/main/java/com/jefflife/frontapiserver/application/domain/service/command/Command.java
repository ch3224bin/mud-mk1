package com.jefflife.frontapiserver.application.domain.service.command;

import com.jefflife.common.model.CommandConstants;
import com.jefflife.frontapiserver.application.domain.model.CommandResult;
import com.jefflife.frontapiserver.application.domain.model.CommandValue;
import reactor.core.publisher.Mono;

public interface Command {
    Mono<CommandResult> execute(CommandValue commandValue);
    CommandConstants getCommandConstants();
}
