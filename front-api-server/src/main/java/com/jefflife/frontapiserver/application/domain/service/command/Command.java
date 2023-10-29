package com.jefflife.frontapiserver.application.domain.service.command;

import com.jefflife.common.model.CommandConstants;
import com.jefflife.frontapiserver.application.domain.model.CommandResult;
import com.jefflife.frontapiserver.application.domain.model.CommandValue;

public interface Command {
    CommandResult execute(CommandValue commandValue);
    CommandConstants getCommandConstants();
}
