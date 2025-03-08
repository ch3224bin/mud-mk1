package com.jefflife.gameserver.command.look.application.domain;

import com.jefflife.common.model.VisibleObject;

import java.util.Optional;

public interface Finder {
    Optional<? extends VisibleObject> find(long playerId, LookCommandDataRequest commandData);
}
