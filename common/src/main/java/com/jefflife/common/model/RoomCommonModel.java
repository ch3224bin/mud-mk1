package com.jefflife.common.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Getter
@EqualsAndHashCode(of = "id")
public class RoomCommonModel {
    private final long id;
    private final String summary;
    private final String description;
    private final List<WayOutCommonModel> wayOuts;
    private final String exitString;

    public RoomCommonModel(long id, String summary, String description, List<WayOutCommonModel> wayOuts, String exitString) {
        this.id = id;
        this.summary = summary;
        this.description = description;
        this.wayOuts = wayOuts;
        this.exitString = exitString;
    }
}
