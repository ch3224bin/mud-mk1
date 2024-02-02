package com.jefflife.gameserver.item.application.port.in;

import com.jefflife.common.model.ItemCommonModel;
import com.jefflife.gameserver.item.application.domain.model.Item;

import java.util.List;

public class ItemModel extends ItemCommonModel {
    private ItemModel(Item item) {
        super(item.getId(), item.getName(), item.getDescription(), item.isGettable(), item.getGrade().name());
    }

    public static List<ItemModel> of(List<Item> items) {
        return items.stream()
                .map(ItemModel::of)
                .toList();
    }

    public static ItemModel of(Item item) {
        return new ItemModel(item);
    }
}
