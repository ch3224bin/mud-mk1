package com.jefflife.common.model;

public interface WayOutCommonModel {
    long getId();
    long getRoomId();
    long getNextRoomId();
    String getDirection();
    boolean isShow();
    boolean isLocked();
}
