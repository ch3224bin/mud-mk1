package com.jefflife.gameserver.player.adapter.out.api;

import com.jefflife.common.model.PlayerCommonModel;
import com.jefflife.common.model.RoomCommonModel;
import com.jefflife.gameserver.map.application.port.in.LoadRoomQuery;
import com.jefflife.gameserver.player.applicatoin.port.in.LoadPlayerQuery;
import com.jefflife.gameserver.player.applicatoin.port.out.FindRoomPort;
import org.springframework.stereotype.Component;

@Component("FindRoomAdapter2") // todo : findRoomAdapter가 두개 존재함. 하나로 합치든 어떻게 처리해야함
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

    @Override
    public String findDirectionByCommand(String directionCommand) {
        return "";
    }
}
