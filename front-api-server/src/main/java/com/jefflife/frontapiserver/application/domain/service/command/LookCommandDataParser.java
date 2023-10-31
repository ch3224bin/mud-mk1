package com.jefflife.frontapiserver.application.domain.service.command;

import com.jefflife.frontapiserver.application.domain.model.CommandData;
import com.jefflife.frontapiserver.application.domain.model.CommandValue;
import org.springframework.stereotype.Component;

@Component
public class LookCommandDataParser implements CommandDataParser {
    @Override
    public CommandData parse(CommandValue commandValue) {
        if (hasOneWord(commandValue)) {
            return new CommandData(null, null, null, commandValue.getLastWord());
        }

        return new CommandData(getTarget(commandValue), null, null, commandValue.getLastWord());
    }
}
