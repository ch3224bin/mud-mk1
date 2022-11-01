package com.jefflife.gameserver.map.application.port.in;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LoadRoomQuery {
    RoomModel getRoom(final long id);
    Page<RoomModel> getPagedRooms(Pageable pageable);
}
