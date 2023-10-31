package com.jefflife.frontapiserver.application.domain.service.command;

import com.jefflife.common.model.CommandConstants;
import com.jefflife.frontapiserver.application.domain.model.CommandData;
import com.jefflife.frontapiserver.application.domain.model.CommandResult;
import com.jefflife.frontapiserver.application.domain.model.CommandValue;
import com.jefflife.frontapiserver.application.port.out.LookPort;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class LookCommand implements Command {
    private final LookPort lookPort;
    private final CommandDataParser lookCommandDataParser;

    public LookCommand(LookPort lookPort, CommandDataParser lookCommandDataParser) {
        this.lookPort = lookPort;
        this.lookCommandDataParser = lookCommandDataParser;
    }

    @Override
    public Mono<CommandResult> execute(CommandValue commandValue) {
        // TODO: 템플릿 아이디 정하기. 수신자 정하기.
        // 템플릿의 아이디는 payload 타입에 따라 결정됨. 고정이 아님.
        CommandData commandData = lookCommandDataParser.parse(commandValue);
        return lookPort.look(1L, commandData)
            .map(context -> new CommandResult(null, context, "1234"));
    }

    @Override
    public CommandConstants getCommandConstants() {
        return CommandConstants.LOOK;
    }
}
