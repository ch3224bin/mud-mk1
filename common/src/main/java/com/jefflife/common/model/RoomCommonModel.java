package com.jefflife.common.model;

import java.util.List;

public interface RoomCommonModel extends VisibleObject {
    long getId();
    String getSummary();
    String getDescription();
    List<WayOutCommonModel> getWayOuts();
    String getExitString();
}
