package com.jefflife.gameserver.map.adapter.out.persistence;

import com.jefflife.common.model.PlayerCommonModel;
import com.jefflife.common.model.RoomCommonModel;
import com.jefflife.gameserver.map.application.port.out.FindRoomPort;
import com.jefflife.gameserver.map.application.port.in.LoadRoomQuery;
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
        PlayerCommonModel player = loadPlayerQuery.getPlayer(playerId);
        return loadRoomQuery.getRoom(player.getRoomId());
    }

    @Override
    public RoomCommonModel findById(long roomId) {
        return loadRoomQuery.getRoom(roomId);
    }
}
