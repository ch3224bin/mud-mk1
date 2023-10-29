package com.jefflife.gameserver.player.applicatoin.domain.service;

import com.jefflife.gameserver.player.applicatoin.port.in.LoadPlayerQuery;
import com.jefflife.gameserver.player.applicatoin.port.out.LoadPlayerPort;
import com.jefflife.gameserver.player.applicatoin.domain.model.Player;
import org.springframework.stereotype.Service;

@Service
public class GetPlayerService implements LoadPlayerQuery {
    private final LoadPlayerPort loadPlayerPort;

    public GetPlayerService(LoadPlayerPort loadPlayerPort) {
        this.loadPlayerPort = loadPlayerPort;
    }

    @Override
    public Player getPlayer(long id) {
        return loadPlayerPort.findById(id);
    }
}
