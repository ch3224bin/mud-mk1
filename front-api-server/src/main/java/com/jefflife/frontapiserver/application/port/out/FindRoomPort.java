package com.jefflife.frontapiserver.application.port.out;

public interface FindRoomPort {
    Object findByPlayerId(long playerId);
}
