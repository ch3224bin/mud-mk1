package com.jefflife.gameserver.look.application.domain.service;

import com.jefflife.common.model.VisibleObject;
import com.jefflife.gameserver.look.application.domain.service.finder.Finders;
import com.jefflife.gameserver.look.application.port.in.LookCommandDataRequest;
import com.jefflife.gameserver.look.application.port.in.LookQuery;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class LookService implements LookQuery {
    private final Finders finders;

    public LookService(Finders finders) {
        this.finders = finders;
    }

    @Override
    public VisibleObject look(long playerId, LookCommandDataRequest commandData) {
        // 대상을 보고 어떤 것을 조회할지 판단 필요.
        // 대상이 없으면 자신의 방을 조회한다.
        // 대상이 있으면, 방 안의 물건, 내 소지품, PC, NPC 등 볼 수 있는 것들을 순서대로 찾아나간다.
        // TODO: 테스트 코드 작성
        return finders.findVisibleObject(playerId, commandData)
                .orElseThrow(() -> new NoSuchElementException("대상을 찾을 수 없습니다."));
    }
}
