package com.jefflife.gameserver.player.applicatoin.port.in;

import com.jefflife.common.model.PlayerCommonModel;

import java.util.List;

public interface LoadPlayerQuery {
    PlayerModel getPlayer(long id);
    List<PlayerCommonModel> getPlayersByRoomId(long roomId);
}
