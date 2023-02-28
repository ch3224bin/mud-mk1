package com.jefflife.gameserver.see.application.service;

import com.jefflife.gameserver.see.application.port.in.JustSeeUseCase;
import com.jefflife.gameserver.see.application.port.out.FindRoomPort;
import com.jefflife.gameserver.see.application.port.out.SendMessagePort;
import com.jefflife.gameserver.shared.Seeable;
import org.springframework.stereotype.Service;

@Service
public class SeeService implements JustSeeUseCase {
    private final FindRoomPort findRoomPort;
    private final SendMessagePort sendMessagePort;

    public SeeService(FindRoomPort findRoomPort, SendMessagePort sendMessagePort) {
        this.findRoomPort = findRoomPort;
        this.sendMessagePort = sendMessagePort;
    }

    @Override
    public void justSee(String playerId) {
        Seeable room = findRoomPort.findByPlayerId(playerId);
        sendMessagePort.send(playerId, room);
    }
}
