package com.jefflife.gameserver.see.application.port.in;

import lombok.Getter;

@Getter
public class SeeQuery {
    private String playerId;

    public SeeQuery(String playerId) {
        this.playerId = playerId;
    }
}
