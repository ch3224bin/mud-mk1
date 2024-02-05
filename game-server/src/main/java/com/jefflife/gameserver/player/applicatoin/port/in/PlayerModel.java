package com.jefflife.gameserver.player.applicatoin.port.in;

import com.jefflife.common.model.PlayerCommonModel;
import com.jefflife.gameserver.player.applicatoin.domain.model.Player;

public class PlayerModel extends PlayerCommonModel {
    public PlayerModel(long id, long roomId, String name, long bagId) {
        super(id, roomId, name, bagId);
    }

    public PlayerModel(Player player) {
        this(player.getId(), player.getRoomId(), player.getName(), player.getBagId());
    }
}
