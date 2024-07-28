package com.jefflife.gameserver.player.applicatoin.port.out;

import com.jefflife.common.model.RoomCommonModel;

public interface FindRoomPort {
    RoomCommonModel findByPlayerId(long playerId);
    RoomCommonModel findById(long roomId);
    String findDirectionByCommand(String directionCommand);
}
