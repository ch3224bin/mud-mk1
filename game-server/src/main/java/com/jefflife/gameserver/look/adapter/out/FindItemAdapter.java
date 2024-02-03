package com.jefflife.gameserver.look.adapter.out;

import com.jefflife.common.model.ItemCommonModel;
import com.jefflife.common.model.ItemsCommonModel;
import com.jefflife.gameserver.item.application.port.in.ItemModel;
import com.jefflife.gameserver.item.application.port.in.LoadItemQuery;
import com.jefflife.gameserver.look.application.port.out.FindItemPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindItemAdapter implements FindItemPort {
    private final LoadItemQuery loadItemQuery;

    public FindItemAdapter(LoadItemQuery loadItemQuery) {
        this.loadItemQuery = loadItemQuery;
    }

    @Override
    public ItemsCommonModel findByFloorId(long floorId) {
        List<ItemModel> items = loadItemQuery.findByFloorId(floorId);
        return ItemsCommonModel.of(items.stream()
                .map(item -> (ItemCommonModel) item)
                .toList());
    }

    @Override
    public ItemsCommonModel findByPlayerId(long playerId) {
        return null;
    }
}
