package com.jefflife.gameserver.player.applicatoin.port.out;

import com.jefflife.gameserver.player.domain.Player;

public interface QueryPlayerPort {
    Player findById(long id);
}
