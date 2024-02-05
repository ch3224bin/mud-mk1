package com.jefflife.gameserver.look.application.port.out;

import com.jefflife.common.model.PlayerCommonModel;

import java.util.List;

public interface FindPlayerPort {
    PlayerCommonModel findPlayerById(long playerId);
    List<PlayerCommonModel> findByRoomId(long roomId);
}
