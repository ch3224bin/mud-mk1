package com.jefflife.gameserver.player.adapter.in.web;

import com.jefflife.gameserver.player.applicatoin.port.in.PlayerQuery;
import com.jefflife.gameserver.player.domain.Player;
import org.springframework.stereotype.Component;

@Component
public class PlayerQueryAdapter {
    private final PlayerQuery playerQuery;

    public PlayerQueryAdapter(PlayerQuery playerQuery) {
        this.playerQuery = playerQuery;
    }

    public Player getPlayer(long id) {
        return playerQuery.getPlayer(id);
    }
}
