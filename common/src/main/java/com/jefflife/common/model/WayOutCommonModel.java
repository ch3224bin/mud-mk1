package com.jefflife.common.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WayOutCommonModel {
    private long id;
    private long roomId;
    private long nextRoomId;
    private String directionCode;
    private String directionName;
    private boolean visible;
    private boolean locked;

    public WayOutCommonModel(long id, long roomId, long nextRoomId, String directionCode, String directionName, boolean visible, boolean locked) {
        this.id = id;
        this.roomId = roomId;
        this.nextRoomId = nextRoomId;
        this.directionCode = directionCode;
        this.directionName = directionName;
        this.visible = visible;
        this.locked = locked;
    }

    public boolean isSameCode(String code) {
        return this.directionCode.equalsIgnoreCase(code);
    }
}
