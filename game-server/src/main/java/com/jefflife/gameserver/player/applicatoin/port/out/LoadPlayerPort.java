package com.jefflife.gameserver.player.applicatoin.port.out;

import com.jefflife.gameserver.player.domain.Player;

public interface LoadPlayerPort {
    Player findById(long id);
}
