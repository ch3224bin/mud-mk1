package com.jefflife.gameserver.look.application.port.out;

import com.jefflife.gameserver.shared.VisibleObject;

public interface FindRoomPort {
    VisibleObject findByPlayerId(long playerId);
}
