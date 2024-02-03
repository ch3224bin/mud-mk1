package com.jefflife.gameserver.look.application.domain.service.finder;

import com.jefflife.common.model.VisibleObject;
import com.jefflife.gameserver.look.application.port.in.LookCommandDataRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Finders {
    private final List<Finder> finders;

    public Finders(List<Finder> finders) {
        this.finders = finders;
    }

    public Optional<? extends VisibleObject> findVisibleObject(long playerId, LookCommandDataRequest commandData) {
        return finders.stream()
                .map(finder -> finder.find(playerId, commandData))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst();
    }
}
