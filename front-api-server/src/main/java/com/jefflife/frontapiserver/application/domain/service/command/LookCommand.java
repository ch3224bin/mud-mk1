package com.jefflife.frontapiserver.application.domain.service.command;

import com.jefflife.common.model.CommandConstants;
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
        // TODO: 수신자 정하기. 현재 플레이어 ID 구하기. 수신자와 현재 플레이어는 세션 서버나 웹소켓 등 구현하고 진행.
        return lookCommandDataParser.parse(commandValue)
                .flatMap(commandData -> lookPort.look(1L, commandData))
                .map(context -> new CommandResult(null, context));
    }

    @Override
    public CommandConstants getCommandConstants() {
        return CommandConstants.LOOK;
    }
}
