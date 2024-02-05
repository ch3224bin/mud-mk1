package com.jefflife.gameserver.look.application.port.out;

import com.jefflife.common.model.ItemsCommonModel;

public interface FindItemPort {
    ItemsCommonModel findByFloorId(long floorId);
    ItemsCommonModel findByBagId(long bagId);
}
