package com.jefflife.gameserver.player.applicatoin.domain.service;

import com.jefflife.common.model.RoomCommonModel;
import com.jefflife.common.model.WayOutCommonModel;
import com.jefflife.gameserver.player.applicatoin.port.out.FindRoomPort;
import com.jefflife.gameserver.player.applicatoin.port.out.UpdatePlayerPositionPort;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class MovePlayerServiceTest {
    private MovePlayerService movePlayerService;
    private FindRoomPort findRoomPort;
    private UpdatePlayerPositionPort updatePlayerPositionPort;

    @BeforeEach
    public void setup() {
        findRoomPort = Mockito.mock(FindRoomPort.class);
        updatePlayerPositionPort = Mockito.mock(UpdatePlayerPositionPort.class);
        movePlayerService = new MovePlayerService(findRoomPort, updatePlayerPositionPort);
    }

    @DisplayName("플레이어를 북쪽으로 이동시킨다")
    @Test
    public void playerMovesNorth() {
        // given
        long playerId = 1;
        long playerRoomId = 1;
        long nextRoomId = 2;
        String direction = "NORTH";

        List<WayOutCommonModel> wayOuts = new ArrayList<>();
        wayOuts.add(new WayOutCommonModel(1, playerRoomId, nextRoomId, "NORTH", "북", true, false));
        RoomCommonModel room = new RoomCommonModel(playerRoomId, "방", "방입니다", wayOuts, "출구", 1);

        when(findRoomPort.findDirectionByCommand(direction)).thenReturn("NORTH");
        when(findRoomPort.findByPlayerId(playerId)).thenReturn(room);

        // when
        movePlayerService.movePlayer(playerId, direction);

        // then
        verify(updatePlayerPositionPort).updatePlayerPosition(playerId, nextRoomId);
    }

    @DisplayName("북쪽에 방이 없는 곳으로 플레이어를 북쪽으로 이동시킨다")
    @Test
    public void playerCantMovesNorth() {
        // given
        long playerId = 1;
        long playerRoomId = 1;
        long nextRoomId = 2;
        String direction = "북";

        List<WayOutCommonModel> wayOuts = new ArrayList<>();
        wayOuts.add(new WayOutCommonModel(1, playerRoomId, nextRoomId, "NORTH", "남", true, false));
        RoomCommonModel room = new RoomCommonModel(playerRoomId, "방", "방입니다", wayOuts, "출구", 1);

        when(findRoomPort.findDirectionByCommand(direction)).thenReturn("NORTH");
        when(findRoomPort.findByPlayerId(playerId)).thenReturn(room);

        // when
        ThrowableAssert.ThrowingCallable throwingCallable = () -> movePlayerService.movePlayer(playerId, direction);

        // then
        assertThatThrownBy(throwingCallable).isInstanceOf(IllegalArgumentException.class);
    }
}