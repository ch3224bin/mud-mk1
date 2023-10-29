package com.jefflife.frontapiserver.application.domain.service;

import com.jefflife.common.model.RoomCommonModel;
import com.jefflife.frontapiserver.application.domain.model.CommandResult;
import com.jefflife.frontapiserver.application.domain.service.command.Command;
import com.jefflife.frontapiserver.application.domain.service.command.CommandFinder;
import com.jefflife.frontapiserver.application.domain.service.command.LookCommand;
import com.jefflife.frontapiserver.application.port.out.FindRoomPort;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class CommandServiceTest {

    @Test
    void name() {
        // given
        FindRoomPort findRoomPort = null;
        List<Command> commands = List.of(new LookCommand(findRoomPort));
        CommandFinder commandFinder = new CommandFinder(commands);
        CommandService commandService = new CommandService(commandFinder);

        // when
        CommandResult commandResult = commandService.execute("봐");

        // then
        assertAll(
            () -> assertThat(commandResult).isNotNull(),
            () -> assertThat(commandResult.getPayload()).isInstanceOf(RoomCommonModel.class)
        );
    }
}