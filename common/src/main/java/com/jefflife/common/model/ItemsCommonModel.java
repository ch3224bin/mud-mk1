package com.jefflife.common.model;

import lombok.Getter;

import java.util.List;
import java.util.Optional;

public class ItemsCommonModel implements VisibleObject {
    @Getter
    private final List<ItemCommonModel> items;

    private ItemsCommonModel(List<ItemCommonModel> items) {
        this.items = items;
    }

    public static ItemsCommonModel of(List<ItemCommonModel> items) {
        if (items == null) {
            throw new IllegalArgumentException("Items cannot be null");
        }

        return new ItemsCommonModel(items);
    }

    public Optional<ItemCommonModel> findFirstByNameLike(String name) {
        return items.stream()
                .filter(item -> item.getName().contains(name))
                .findFirst();
    }
}
