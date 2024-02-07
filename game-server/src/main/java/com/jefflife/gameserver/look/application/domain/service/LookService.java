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
        return finders.findVisibleObject(playerId, commandData)
                .orElseThrow(() -> new NoSuchElementException("대상을 찾을 수 없습니다."));
    }
}
