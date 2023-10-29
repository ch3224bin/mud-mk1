package com.jefflife.frontapiserver.application.domain.service.command;

import com.jefflife.frontapiserver.application.domain.model.CommandConstants;
import com.jefflife.frontapiserver.application.domain.model.CommandResult;
import com.jefflife.frontapiserver.application.domain.model.CommandValue;
import com.jefflife.frontapiserver.application.port.out.FindRoomPort;
import org.springframework.stereotype.Component;

@Component
public class LookCommand implements Command {
    private final FindRoomPort findRoomPort;

    public LookCommand(FindRoomPort findRoomPort) {
        this.findRoomPort = findRoomPort;
    }

    @Override
    public CommandResult execute(CommandValue commandValue) {
        // 대상을 보고 어떤 것을 조회할지 판단 필요.
        // 대상이 없으면 자신의 방을 조회한다.
        // 대상이 있으면, 방 안의 물건, 내 소지품, PC, NPC 등 볼 수 있는 것들을 순서대로 찾아나간다.
        return new CommandResult(null, null, null);
    }

    @Override
    public CommandConstants getCommandConstants() {
        return CommandConstants.LOOK;
    }
}
