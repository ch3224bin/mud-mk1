package com.jefflife.gameserver.item.application.domain.service.model;

import com.jefflife.common.model.VisibleObject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ItemCommonModel implements VisibleObject {
    private long id;
    private String name;
    private String description;
    private boolean isGettable;
    private String gradeName;

    public ItemCommonModel(long id, String name, String description, boolean isGettable, String gradeName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isGettable = isGettable;
        this.gradeName = gradeName;
    }
}
