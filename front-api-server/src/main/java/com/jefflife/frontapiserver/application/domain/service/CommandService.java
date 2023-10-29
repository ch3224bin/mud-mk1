package com.jefflife.frontapiserver.application.domain.service;

import com.jefflife.frontapiserver.application.domain.model.CommandResult;
import com.jefflife.frontapiserver.application.domain.model.CommandValue;
import com.jefflife.frontapiserver.application.domain.service.command.Command;
import com.jefflife.frontapiserver.application.domain.service.command.CommandFinder;
import org.springframework.stereotype.Service;

@Service
public class CommandService {
    private final CommandFinder commandFinder;

    public CommandService(CommandFinder commandFinder) {
        this.commandFinder = commandFinder;
    }

    public CommandResult execute(String commandText) {
        CommandValue commandValue = CommandValue.of(commandText);
        Command command = commandFinder.find(commandValue);
        return command.execute(commandValue);
    }
}
