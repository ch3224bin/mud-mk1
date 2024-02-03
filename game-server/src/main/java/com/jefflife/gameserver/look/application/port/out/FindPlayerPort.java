package com.jefflife.gameserver.look.application.port.out;

import com.jefflife.common.model.PlayerCommonModel;

public interface FindPlayerPort {
    PlayerCommonModel findPlayerById(long playerId);
}
