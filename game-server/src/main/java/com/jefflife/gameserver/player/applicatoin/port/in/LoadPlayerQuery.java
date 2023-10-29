package com.jefflife.gameserver.player.applicatoin.port.in;

import com.jefflife.gameserver.player.applicatoin.domain.model.Player;

public interface LoadPlayerQuery {
    Player getPlayer(long id);
}
