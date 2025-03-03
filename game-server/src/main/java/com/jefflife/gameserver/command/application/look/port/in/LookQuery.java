package com.jefflife.gameserver.command.application.look.port.in;

import com.jefflife.common.model.VisibleObject;
import com.jefflife.gameserver.command.application.look.domain.LookCommandDataRequest;

public interface LookQuery {
    VisibleObject look(long playerId, LookCommandDataRequest commandData);
}
