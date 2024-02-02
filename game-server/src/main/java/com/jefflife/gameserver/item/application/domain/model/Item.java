package com.jefflife.gameserver.item.application.domain.model;

import lombok.Getter;

@Getter
public class Item {
    private final long id;
    private final String name;
    private final String description;
    private final boolean isGettable;
    private final ItemGrade grade;

    public Item(long id, String name, String description, boolean isGettable, ItemGrade grade) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isGettable = isGettable;
        this.grade = grade;
    }
}
