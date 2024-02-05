package com.jefflife.gameserver.player.applicatoin.domain.service;

import com.jefflife.common.model.PlayerCommonModel;
import com.jefflife.gameserver.player.applicatoin.port.in.LoadPlayerQuery;
import com.jefflife.gameserver.player.applicatoin.port.in.PlayerModel;
import com.jefflife.gameserver.player.applicatoin.port.out.LoadPlayerPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPlayerService implements LoadPlayerQuery {
    private final LoadPlayerPort loadPlayerPort;

    public GetPlayerService(LoadPlayerPort loadPlayerPort) {
        this.loadPlayerPort = loadPlayerPort;
    }

    @Override
    public PlayerModel getPlayer(long id) {
        return new PlayerModel(loadPlayerPort.findById(id));
    }

    @Override
    public List<PlayerCommonModel> getPlayersByRoomId(long roomId) {
        return PlayerModel.castCommonModel(loadPlayerPort.findByRoomId(roomId));
    }
}
