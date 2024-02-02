package com.jefflife.gameserver.item.application.domain.model;

import com.jefflife.common.model.ItemsCommonModel;
import lombok.Getter;

@Getter
public class Bag {
    private final long id;
    private final ItemsCommonModel items;

    public Bag(long id, ItemsCommonModel items) {
        this.id = id;
        this.items = items;
    }
}
