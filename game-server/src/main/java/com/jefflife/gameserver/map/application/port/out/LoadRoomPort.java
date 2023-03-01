package com.jefflife.gameserver.map.application.port.out;

import com.jefflife.gameserver.map.domain.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LoadRoomPort {
    Room findById(long id);
    Page<Room> findAll(Pageable pageable);
}
