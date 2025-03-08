package com.jefflife.gameserver.command.look.application.port.in;

import com.jefflife.common.model.VisibleObject;
import com.jefflife.gameserver.command.look.application.domain.LookCommandDataRequest;

public interface LookQuery {
    VisibleObject look(long playerId, LookCommandDataRequest commandData);
}
