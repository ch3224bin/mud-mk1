package com.jefflife.frontapiserver.application.domain.service;

import com.jefflife.frontapiserver.application.port.in.LookAtRoomUseCase;
import com.jefflife.frontapiserver.application.port.out.FindRoomPort;
import com.jefflife.frontapiserver.application.port.out.SendMessagePort;
import org.springframework.stereotype.Service;

@Service
public class LookService implements LookAtRoomUseCase {

    private final FindRoomPort findRoomPort;
    private final SendMessagePort sendMessagePort;

    public LookService(FindRoomPort findRoomPort, SendMessagePort sendMessagePort) {
        this.findRoomPort = findRoomPort;
        this.sendMessagePort = sendMessagePort;
    }

    @Override
    public void lookAtMyRoom(long playerId) {
        Object room = findRoomPort.findByPlayerId(playerId);
        sendMessagePort.sendRoomInfoToPlayer(playerId, room);
    }
}
