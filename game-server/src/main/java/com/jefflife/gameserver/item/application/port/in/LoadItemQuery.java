package com.jefflife.gameserver.item.application.port.in;

import java.util.List;

public interface LoadItemQuery {
    List<ItemModel> findByName(String name);
    List<ItemModel> findByFloorId(long floorId);
}
