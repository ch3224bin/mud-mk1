package com.jefflife.gameserver.see.application.port.out;

import com.jefflife.gameserver.shared.Seeable;

public interface SendMessagePort {
    void send(String target, Seeable object);
}
