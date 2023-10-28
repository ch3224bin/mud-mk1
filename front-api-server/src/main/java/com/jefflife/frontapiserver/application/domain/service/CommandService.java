package com.jefflife.frontapiserver.application.domain.service;

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

    public String execute(String commandText) {
        // todo 반환타입 정의해야함.
        CommandValue commandValue = CommandValue.of(commandText);
        Command command = commandFinder.find(commandValue);
        command.execute(commandValue);

        return "command";
    }
}
