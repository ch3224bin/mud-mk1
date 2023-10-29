package com.jefflife.gameserver.look.adapter.out;

import com.jefflife.common.model.RoomCommonModel;
import com.jefflife.gameserver.look.application.port.out.FindRoomPort;
import com.jefflife.gameserver.map.application.port.in.LoadRoomQuery;
import com.jefflife.gameserver.player.applicatoin.domain.model.Player;
import com.jefflife.gameserver.player.applicatoin.port.in.LoadPlayerQuery;
import org.springframework.stereotype.Component;

@Component
public class FindRoomAdapter implements FindRoomPort {
    private final LoadPlayerQuery loadPlayerQuery;
    private final LoadRoomQuery loadRoomQuery;

    public FindRoomAdapter(LoadPlayerQuery loadPlayerQuery, LoadRoomQuery loadRoomQuery) {
        this.loadPlayerQuery = loadPlayerQuery;
        this.loadRoomQuery = loadRoomQuery;
    }

    @Override
    public RoomCommonModel findByPlayerId(long playerId) {
        Player player = loadPlayerQuery.getPlayer(playerId);
        return loadRoomQuery.getRoom(player.getRoomId());
    }
}
