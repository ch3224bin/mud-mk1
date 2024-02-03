package com.jefflife.gameserver.item.application.domain.service;

import com.jefflife.gameserver.item.application.domain.model.Item;
import com.jefflife.gameserver.item.application.port.in.ItemModel;
import com.jefflife.gameserver.item.application.port.in.LoadItemQuery;
import com.jefflife.gameserver.item.application.port.out.LoadItemPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService implements LoadItemQuery {

    private final LoadItemPort loadItemPort;

    public ItemService(LoadItemPort loadItemPort) {
        this.loadItemPort = loadItemPort;
    }

    @Override
    public List<ItemModel> findByName(String name) {
        List<Item> item = loadItemPort.findByName(name);
        return ItemModel.of(item);
    }

    @Override
    public List<ItemModel> findByFloorId(long floorId) {
        List<Item> item = loadItemPort.findByFloorId(floorId);
        return ItemModel.of(item);
    }
}
