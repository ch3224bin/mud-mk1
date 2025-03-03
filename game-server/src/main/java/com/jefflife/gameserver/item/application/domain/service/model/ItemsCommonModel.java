package com.jefflife.gameserver.item.application.domain.service.model;

import com.jefflife.common.model.VisibleObject;
import com.jefflife.gameserver.item.application.domain.model.Item;
import com.jefflife.gameserver.item.application.port.in.ItemModel;
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

    public static ItemsCommonModel fromDomain(List<Item> items) {
        if (items == null) {
            throw new IllegalArgumentException("Items cannot be null");
        }
        return ItemsCommonModel.of(items.stream()
                .map(ItemModel::of)
                .map(itemModel -> (ItemCommonModel) itemModel)
                .toList());
    }

    public Optional<ItemCommonModel> findFirstByNameLike(String name) {
        return items.stream()
                .filter(item -> item.getName().contains(name))
                .findFirst();
    }
}
