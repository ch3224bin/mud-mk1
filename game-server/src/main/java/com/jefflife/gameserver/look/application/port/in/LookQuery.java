package com.jefflife.gameserver.look.application.port.in;

import lombok.Getter;

@Getter
public class LookQuery {
    private String playerId;

    public LookQuery(String playerId) {
        this.playerId = playerId;
    }
}
