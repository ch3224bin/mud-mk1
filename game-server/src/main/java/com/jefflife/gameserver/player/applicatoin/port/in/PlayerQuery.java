package com.jefflife.gameserver.player.applicatoin.port.in;

import com.jefflife.gameserver.player.domain.Player;

public interface PlayerQuery {
    Player getPlayer(long id);
}
