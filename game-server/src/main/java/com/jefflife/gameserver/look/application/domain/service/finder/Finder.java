package com.jefflife.gameserver.look.application.domain.service.finder;

import com.jefflife.common.model.VisibleObject;
import com.jefflife.gameserver.look.application.port.in.LookCommandDataRequest;

import java.util.Optional;

public interface Finder {
    Optional<? extends VisibleObject> find(long playerId, LookCommandDataRequest commandData);
}
