package com.jefflife.frontapiserver.application.domain.service.command;

import com.jefflife.frontapiserver.application.domain.model.CommandData;
import com.jefflife.frontapiserver.application.domain.model.CommandValue;
import reactor.core.publisher.Mono;

public interface CommandDataParser {
    Mono<CommandData> parse(CommandValue commandValue);
    default boolean hasOneWord(CommandValue commandValue) {
        return commandValue.getWordCount() == 1;
    }
    default String getTarget(CommandValue commandValue) {
        return commandValue.getWords()[0];
    }
}
