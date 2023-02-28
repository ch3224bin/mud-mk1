package com.jefflife.gameserver.see.application.port.out;

import com.jefflife.gameserver.shared.Seeable;

public interface FindRoomPort {
    Seeable findByPlayerId(String playerId);
}
