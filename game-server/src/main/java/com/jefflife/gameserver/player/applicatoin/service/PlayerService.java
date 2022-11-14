package com.jefflife.gameserver.player.applicatoin.service;

import com.jefflife.gameserver.player.applicatoin.port.in.PlayerQuery;
import com.jefflife.gameserver.player.applicatoin.port.out.QueryPlayerPort;
import com.jefflife.gameserver.player.domain.Player;
import org.springframework.stereotype.Component;

@Component
public class PlayerService implements PlayerQuery {
    private final QueryPlayerPort queryPlayerPort;

    public PlayerService(QueryPlayerPort queryPlayerPort) {
        this.queryPlayerPort = queryPlayerPort;
    }

    @Override
    public Player getPlayer(long id) {
        return queryPlayerPort.findById(id);
    }
}
