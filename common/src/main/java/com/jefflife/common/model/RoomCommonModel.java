package com.jefflife.common.model;

import java.util.List;

public record RoomCommonModel(
    long id,
    String summary,
    String description,
    List<WayOutCommonModel> wayOuts,
    String exitString
) {

}
