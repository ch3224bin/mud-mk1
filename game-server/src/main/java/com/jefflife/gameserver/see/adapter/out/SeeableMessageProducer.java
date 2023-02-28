package com.jefflife.gameserver.see.adapter.out;

import com.jefflife.gameserver.see.application.port.out.SendMessagePort;
import com.jefflife.gameserver.shared.Seeable;
import org.springframework.stereotype.Component;

@Component
public class SeeableMessageProducer implements SendMessagePort {
    @Override
    public void send(String target, Seeable object) {

    }
}
