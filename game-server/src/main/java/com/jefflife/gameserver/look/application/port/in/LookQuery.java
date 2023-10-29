package com.jefflife.gameserver.look.application.port.in;

import com.jefflife.common.model.VisibleObject;

public interface LookQuery {
    VisibleObject look(long playerId, LookCommandDataRequest commandData);
}
