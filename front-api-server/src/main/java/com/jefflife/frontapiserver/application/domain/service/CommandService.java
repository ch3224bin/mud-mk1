package com.jefflife.frontapiserver.application.domain.service;

import com.jefflife.frontapiserver.application.domain.model.CommandResult;
import com.jefflife.frontapiserver.application.domain.model.CommandValue;
import com.jefflife.frontapiserver.application.domain.service.command.CommandFinder;
import com.jefflife.frontapiserver.application.port.in.CommandExecutor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CommandService implements CommandExecutor {
    private final CommandFinder commandFinder;

    public CommandService(CommandFinder commandFinder) {
        this.commandFinder = commandFinder;
    }

    public Mono<CommandResult> execute(String commandText) {
        return Mono.just(commandText)
            .map(CommandValue::of)
            .map(commandFinder::find)
            .flatMap(command -> command.execute(CommandValue.of(commandText)));
    }
}
