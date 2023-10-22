package com.jefflife.gameserver.look.application.port.out;

import com.jefflife.gameserver.shared.VisibleObject;

public interface SendMessagePort {
    void send(long target, VisibleObject object);
}
