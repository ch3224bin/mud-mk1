package com.jefflife.frontapiserver.adapter.out;

import com.jefflife.frontapiserver.application.port.out.SendMessagePort;
import org.springframework.stereotype.Component;

@Component
public class VisibleObjectMessageProducer implements SendMessagePort {
    @Override
    public void sendRoomInfoToPlayer(long playerId, Object payload) {

    }
}
