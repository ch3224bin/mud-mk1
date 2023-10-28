package com.jefflife.frontapiserver.application.domain.service.command;

import com.jefflife.frontapiserver.application.domain.model.CommandConstants;
import com.jefflife.frontapiserver.application.domain.model.CommandValue;
import org.springframework.stereotype.Component;

@Component
public class LookCommand implements Command {
    @Override
    public void execute(CommandValue commandValue) {

    }

    @Override
    public CommandConstants getCommandConstants() {
        return CommandConstants.LOOK;
    }
}
