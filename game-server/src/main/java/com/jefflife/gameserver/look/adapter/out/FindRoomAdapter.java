package com.jefflife.gameserver.look.adapter.out;

import com.jefflife.gameserver.look.application.port.out.FindRoomPort;
import com.jefflife.gameserver.map.adapter.out.persistence.QueryRoomAdapter;
import com.jefflife.gameserver.player.adapter.out.persistence.QueryPlayerAdapter;
import com.jefflife.gameserver.player.domain.Player;
import com.jefflife.gameserver.shared.Seeable;
import org.springframework.stereotype.Component;

@Component
public class FindRoomAdapter implements FindRoomPort {
    private final QueryPlayerAdapter queryPlayerAdapter;
    private final QueryRoomAdapter queryRoomAdapter;

    public FindRoomAdapter(QueryPlayerAdapter queryPlayerAdapter, QueryRoomAdapter queryRoomAdapter) {
        this.queryPlayerAdapter = queryPlayerAdapter;
        this.queryRoomAdapter = queryRoomAdapter;
    }

    @Override
    public Seeable findByPlayerId(long playerId) {
        Player player = queryPlayerAdapter.findById(playerId);
        return queryRoomAdapter.findById(player.getRoomId());
    }
}
