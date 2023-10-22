package com.jefflife.frontapiserver.application.port.out;

public interface SendMessagePort {
    void sendRoomInfoToPlayer(long playerId, Object payload);
}
