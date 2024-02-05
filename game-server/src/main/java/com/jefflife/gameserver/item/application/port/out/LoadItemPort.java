package com.jefflife.gameserver.item.application.port.out;

import com.jefflife.gameserver.item.application.domain.model.Item;

import java.util.List;

public interface LoadItemPort {
    List<Item> findByName(String name);
    List<Item> findByFloorId(long floorId);
    List<Item> findByBagId(long bagId);
}
