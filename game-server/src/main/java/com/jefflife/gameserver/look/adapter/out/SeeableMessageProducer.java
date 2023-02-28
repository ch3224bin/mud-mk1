package com.jefflife.gameserver.look.adapter.out;

import com.jefflife.gameserver.look.application.port.out.SendMessagePort;
import com.jefflife.gameserver.shared.Seeable;
import org.springframework.stereotype.Component;

@Component
public class SeeableMessageProducer implements SendMessagePort {
    @Override
    public void send(long target, Seeable object) {

    }
}
