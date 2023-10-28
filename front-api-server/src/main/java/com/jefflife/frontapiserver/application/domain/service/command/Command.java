package com.jefflife.frontapiserver.application.domain.service.command;

import com.jefflife.frontapiserver.application.domain.model.CommandConstants;
import com.jefflife.frontapiserver.application.domain.model.CommandValue;

public interface Command {
    void execute(CommandValue commandValue);
    CommandConstants getCommandConstants();
}
