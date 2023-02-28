package com.jefflife.gameserver.look.application.port.out;

import com.jefflife.gameserver.shared.Seeable;

public interface SendMessagePort {
    void send(long target, Seeable object);
}
