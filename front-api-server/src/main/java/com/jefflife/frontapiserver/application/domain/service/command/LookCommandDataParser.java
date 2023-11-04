package com.jefflife.frontapiserver.application.domain.service.command;

import com.jefflife.frontapiserver.application.domain.model.CommandData;
import com.jefflife.frontapiserver.application.domain.model.CommandValue;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class LookCommandDataParser implements CommandDataParser {
    @Override
    public Mono<CommandData> parse(CommandValue commandValue) {
        if (hasOneWord(commandValue)) {
            return Mono.just(new CommandData(null, null, null, commandValue.getLastWord()));
        }

        return Mono.just(new CommandData(getTarget(commandValue), null, null, commandValue.getLastWord()));
    }
}
