package com.jefflife.common.model;

import lombok.Getter;

@Getter
public class PlayerCommonModel implements VisibleObject {
    private final long id;
    private final long roomId;
    private final String name;
    private final long bagId;

    public PlayerCommonModel(long id, long roomId, String name, long bagId) {
        this.id = id;
        this.roomId = roomId;
        this.name = name;
        this.bagId = bagId;
    }
}
