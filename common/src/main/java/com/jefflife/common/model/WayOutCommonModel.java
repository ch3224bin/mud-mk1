package com.jefflife.common.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(of = "id")
public class WayOutCommonModel {
    private final long id;
    private final long roomId;
    private final long nextRoomId;
    private final String direction;
    private final boolean isShow;
    private final boolean isLocked;

    public WayOutCommonModel(long id, long roomId, long nextRoomId, String direction, boolean isShow, boolean isLocked) {
        this.id = id;
        this.roomId = roomId;
        this.nextRoomId = nextRoomId;
        this.direction = direction;
        this.isShow = isShow;
        this.isLocked = isLocked;
    }
}
