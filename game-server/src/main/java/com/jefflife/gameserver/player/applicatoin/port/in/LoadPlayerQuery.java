package com.jefflife.gameserver.player.applicatoin.port.in;

public interface LoadPlayerQuery {
    PlayerModel getPlayer(long id);
}
