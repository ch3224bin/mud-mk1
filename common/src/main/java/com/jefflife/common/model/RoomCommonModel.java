package com.jefflife.common.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoomCommonModel implements VisibleObject {
    private long id;
    private String summary;
    private String description;
    private List<WayOutCommonModel> wayOuts;
    private String exitString;

    public RoomCommonModel(long id, String summary, String description, List<WayOutCommonModel> wayOuts, String exitString) {
        this.id = id;
        this.summary = summary;
        this.description = description;
        this.wayOuts = wayOuts;
        this.exitString = exitString;
    }
}
