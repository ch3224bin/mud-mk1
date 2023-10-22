package com.jefflife.common.model;

public record WayOutCommonModel(long id, long roomId, long nextRoomId, String direction, boolean isShow, boolean isLocked) {
}
