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

    public LookCommand(LookPort lookPort) {
        this.lookPort = lookPort;
    }

    @Override
    public Mono<CommandResult> execute(CommandValue commandValue) {
        // TODO: CommandData로 파싱하기. 템플릿 아이디 정하기. 수신자 정하기.
        return lookPort.look(1L, new CommandData("", "", "", ""))
            .map(context -> new CommandResult(null, context, "1234"));
    }

    @Override
    public CommandConstants getCommandConstants() {
        return CommandConstants.LOOK;
    }
}
