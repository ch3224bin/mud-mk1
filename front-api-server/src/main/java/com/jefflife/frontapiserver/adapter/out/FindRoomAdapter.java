package com.jefflife.frontapiserver.adapter.out;

import com.jefflife.frontapiserver.application.port.out.FindRoomPort;
import org.springframework.stereotype.Component;

@Component
public class FindRoomAdapter implements FindRoomPort {

    @Override
    public Object findByPlayerId(long playerId) {
        return null;
    }
}
