package com.jefflife.gameserver.player.applicatoin.port.out;

public interface UpdatePlayerPositionPort {
    void updatePlayerPosition(long id, long roomId);
}
