package com.jefflife.gameserver.command.application.look.service;

import com.jefflife.common.model.VisibleObject;
import com.jefflife.gameserver.command.application.look.domain.Finders;
import com.jefflife.gameserver.command.application.look.domain.LookCommandDataRequest;
import com.jefflife.gameserver.command.application.look.port.in.LookQuery;
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
