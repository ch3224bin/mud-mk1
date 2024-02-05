package com.jefflife.gameserver.player.applicatoin.port.out;

import com.jefflife.gameserver.player.applicatoin.domain.model.Player;

import java.util.List;

public interface LoadPlayerPort {
    Player findById(long id);
    List<Player> findByRoomId(long roomId);
}
