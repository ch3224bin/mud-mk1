package com.jefflife.gameserver.look.application.service;

import com.jefflife.gameserver.look.application.port.in.LookAtRoomUseCase;
import com.jefflife.gameserver.look.application.port.out.FindRoomPort;
import com.jefflife.gameserver.look.application.port.out.SendMessagePort;
import com.jefflife.gameserver.shared.Seeable;
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
        Seeable room = findRoomPort.findByPlayerId(playerId);
        sendMessagePort.send(playerId, room);
    }
}
