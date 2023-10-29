package com.jefflife.frontapiserver.application.domain.service.command;

import com.jefflife.common.model.CommandConstants;
import com.jefflife.frontapiserver.application.domain.model.CommandValue;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CommandFinder {

    private final Map<CommandConstants, Command> commandMap = new HashMap<>();

    public CommandFinder(List<Command> commands) {
        for (Command command : commands) {
            commandMap.put(command.getCommandConstants(), command);
        }
    }

    public Command find(CommandValue commandValue) {
        CommandConstants commandConstants = CommandConstants.find(commandValue.getLastWord());
        Command result = commandMap.get(commandConstants);
        if (result != null) {
            return result;
        }
        throw new CommandNotFoundException();
    }
}
