package com.jefflife.gameserver.player.applicatoin.port.out;

import com.jefflife.gameserver.player.applicatoin.domain.model.Player;

public interface LoadPlayerPort {
    Player findById(long id);
}
