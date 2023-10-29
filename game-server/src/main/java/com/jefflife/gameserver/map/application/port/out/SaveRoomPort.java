package com.jefflife.gameserver.map.application.port.out;

import com.jefflife.gameserver.map.application.domain.model.Room;

public interface SaveRoomPort {
    Room save(Room room);
}
