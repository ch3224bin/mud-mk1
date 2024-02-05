package com.jefflife.gameserver.item.application.domain.service;

import com.jefflife.gameserver.item.application.domain.model.Item;
import com.jefflife.gameserver.item.application.port.in.ItemModel;
import com.jefflife.gameserver.item.application.port.in.LoadItemQuery;
import com.jefflife.gameserver.item.application.port.out.LoadItemPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadItemService implements LoadItemQuery {

    private final LoadItemPort loadItemPort;

    public LoadItemService(LoadItemPort loadItemPort) {
        this.loadItemPort = loadItemPort;
    }

    @Override
    public List<ItemModel> findByName(String name) {
        List<Item> items = loadItemPort.findByName(name);
        return ItemModel.of(items);
    }

    @Override
    public List<ItemModel> findByFloorId(long floorId) {
        List<Item> items = loadItemPort.findByFloorId(floorId);
        return ItemModel.of(items);
    }

    @Override
    public List<ItemModel> findByBagId(long bagId) {
        List<Item> items = loadItemPort.findByBagId(bagId);
        return ItemModel.of(items);
    }
}
