package com.jefflife.gameserver.see.adapter.out;

import com.jefflife.gameserver.see.application.port.out.FindRoomPort;
import com.jefflife.gameserver.shared.Seeable;
import org.springframework.stereotype.Component;

@Component
public class FindRoomAdapter implements FindRoomPort {
    @Override
    public Seeable findByPlayerId(String playerId) {
        return null;
    }
}
