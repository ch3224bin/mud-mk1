package com.jefflife.gameserver.look.application.port.out;

import com.jefflife.gameserver.shared.Seeable;

public interface FindRoomPort {
    Seeable findByPlayerId(long playerId);
}
