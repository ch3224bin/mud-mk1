package com.jefflife.gameserver.player.applicatoin.domain.service;

import com.jefflife.common.model.RoomCommonModel;
import com.jefflife.common.model.WayOutCommonModel;
import com.jefflife.gameserver.player.applicatoin.port.in.MovePlayerCommand;
import com.jefflife.gameserver.player.applicatoin.port.out.FindRoomPort;
import com.jefflife.gameserver.player.applicatoin.port.out.UpdatePlayerPositionPort;
import org.springframework.stereotype.Service;

@Service
public class MovePlayerService implements MovePlayerCommand {
    private final FindRoomPort findRoomPort;
    private final UpdatePlayerPositionPort updatePlayerPositionPort;

    public MovePlayerService(FindRoomPort findRoomPort, UpdatePlayerPositionPort updatePlayerPositionPort) {
        this.findRoomPort = findRoomPort;
        this.updatePlayerPositionPort = updatePlayerPositionPort;
    }

    @Override
    public void movePlayer(long id, String direction) {
//        String directionCode = findRoomPort.findDirectionByCommand(direction); // 이게 맞을까, 코드로 처리하는게 맞을까..
        String directionCode = direction;
        RoomCommonModel room = findRoomPort.findByPlayerId(id);
        WayOutCommonModel wayOutCommonModel = room.getWayOuts().stream()
                .filter(wayOut -> wayOut.isSameCode(directionCode))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 방향으로 이동할 수 없습니다. 방없음"));
        if (wayOutCommonModel.isLocked()) {
            throw new IllegalArgumentException("해당 방향으로 이동할 수 없습니다. 잠김");
        }
        updatePlayerPositionPort.updatePlayerPosition(id, wayOutCommonModel.getNextRoomId());
    }
}
