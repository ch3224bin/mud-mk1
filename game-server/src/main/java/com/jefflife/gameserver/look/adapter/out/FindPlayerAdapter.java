package com.jefflife.gameserver.look.adapter.out;

import com.jefflife.common.model.PlayerCommonModel;
import com.jefflife.gameserver.look.application.port.out.FindPlayerPort;
import com.jefflife.gameserver.player.applicatoin.port.in.LoadPlayerQuery;
import org.springframework.stereotype.Component;

@Component
public class FindPlayerAdapter implements FindPlayerPort {
    private final LoadPlayerQuery loadPlayerQuery;

    public FindPlayerAdapter(LoadPlayerQuery loadPlayerQuery) {
        this.loadPlayerQuery = loadPlayerQuery;
    }

    @Override
    public PlayerCommonModel findPlayerById(long playerId) {
        return loadPlayerQuery.getPlayer(playerId);
    }
}
