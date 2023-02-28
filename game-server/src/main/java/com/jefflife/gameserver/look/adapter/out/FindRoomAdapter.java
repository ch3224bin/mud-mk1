package com.jefflife.gameserver.look.adapter.out;

import com.jefflife.gameserver.look.application.port.out.FindRoomPort;
import com.jefflife.gameserver.shared.Seeable;
import org.springframework.stereotype.Component;

@Component
public class FindRoomAdapter implements FindRoomPort {
    @Override
    public Seeable findByPlayerId(String playerId) {
        return null;
    }
}
