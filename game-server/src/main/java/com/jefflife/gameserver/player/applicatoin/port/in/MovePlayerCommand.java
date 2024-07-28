package com.jefflife.gameserver.player.applicatoin.port.in;

public interface MovePlayerCommand {
    void movePlayer(long id, String direction);
}
