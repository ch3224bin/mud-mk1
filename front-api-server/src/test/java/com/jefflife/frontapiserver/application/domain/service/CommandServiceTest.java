package com.jefflife.frontapiserver.application.domain.service;

import com.jefflife.common.model.RoomCommonModel;
import com.jefflife.common.model.WayOutCommonModel;
import com.jefflife.frontapiserver.application.domain.model.CommandResult;
import com.jefflife.frontapiserver.application.domain.service.command.Command;
import com.jefflife.frontapiserver.application.domain.service.command.CommandFinder;
import com.jefflife.frontapiserver.application.domain.service.command.LookCommand;
import com.jefflife.frontapiserver.application.port.out.LookPort;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CommandServiceTest {

    @Test
    void name() {
        // given
        final RoomCommonModel roomModel = getRoomCommonModel();
        LookPort lookPort = (playerId, commandData) -> Mono.just(roomModel);
        List<Command> commands = List.of(new LookCommand(lookPort));
        CommandFinder commandFinder = new CommandFinder(commands);
        CommandService commandService = new CommandService(commandFinder);

        // when
        Mono<CommandResult> commandResult = commandService.execute("봐");

        // then
        StepVerifier.create(commandResult)
            .expectNextMatches(result -> {
                assertThat(result.getPayload()).isInstanceOf(RoomCommonModel.class);
                RoomCommonModel payload = (RoomCommonModel) result.getPayload();
                assertThat(payload.getId()).isEqualTo(roomModel.getId());
                assertThat(payload.getSummary()).isEqualTo(roomModel.getSummary());
                assertThat(payload.getDescription()).isEqualTo(roomModel.getDescription());
                return true;
            })
            .verifyComplete();
    }

    private static RoomCommonModel getRoomCommonModel() {
        return new RoomCommonModel() {
            @Override
            public long getId() {
                return 1L;
            }

            @Override
            public String getSummary() {
                return "test";
            }

            @Override
            public String getDescription() {
                return "test";
            }

            @Override
            public List<WayOutCommonModel> getWayOuts() {
                return null;
            }

            @Override
            public String getExitString() {
                return null;
            }
        };
    }
}