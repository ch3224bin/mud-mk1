package com.jefflife.gameserver.item.application.port.out;

import com.jefflife.gameserver.item.application.domain.service.model.ItemsCommonModel;

public interface FindItemPort {
    ItemsCommonModel findByFloorId(long floorId);
}
