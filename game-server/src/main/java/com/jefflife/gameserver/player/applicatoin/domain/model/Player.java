package com.jefflife.gameserver.player.applicatoin.domain.model;

import lombok.Getter;

@Getter
public class Player {
    private final long id;
    private final long roomId;
    private final String name;

    public Player(long id, long roomId, String name) {
        this.id = id;
        this.roomId = roomId;
        this.name = name;
    }
}
