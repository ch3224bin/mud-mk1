package com.jefflife.common.model;

import lombok.Getter;

@Getter
public class PlayerCommonModel {
    private final long id;
    private final long roomId;
    private final String name;

    public PlayerCommonModel(long id, long roomId, String name) {
        this.id = id;
        this.roomId = roomId;
        this.name = name;
    }
}
