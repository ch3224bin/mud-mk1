package com.jefflife.gameserver.look.application.domain.service;

import com.jefflife.common.model.VisibleObject;
import com.jefflife.gameserver.look.application.port.in.LookCommandDataRequest;
import com.jefflife.gameserver.look.application.port.in.LookQuery;
import com.jefflife.gameserver.look.application.port.out.FindRoomPort;
import org.springframework.stereotype.Service;

@Service
public class LookService implements LookQuery {
    private final FindRoomPort findRoomPort;

    public LookService(FindRoomPort findRoomPort) {
        this.findRoomPort = findRoomPort;
    }

    @Override
    public VisibleObject look(long playerId, LookCommandDataRequest commandData) {
        // 대상을 보고 어떤 것을 조회할지 판단 필요.
        // 대상이 없으면 자신의 방을 조회한다.
        // 대상이 있으면, 방 안의 물건, 내 소지품, PC, NPC 등 볼 수 있는 것들을 순서대로 찾아나간다.
        if (!commandData.hasTarget()) {
            return findRoomPort.findByPlayerId(playerId);
        }

        return null;
    }
}
