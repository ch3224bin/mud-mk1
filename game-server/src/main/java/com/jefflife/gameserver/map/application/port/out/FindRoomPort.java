package com.jefflife.gameserver.map.application.port.out;

import com.jefflife.common.model.RoomCommonModel;

public interface FindRoomPort {
    RoomCommonModel findByPlayerId(long playerId);

    RoomCommonModel findById(long roomId);
}
