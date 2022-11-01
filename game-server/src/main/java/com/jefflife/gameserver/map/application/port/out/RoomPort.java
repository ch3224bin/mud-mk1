package com.jefflife.gameserver.map.application.port.out;

import com.jefflife.gameserver.map.domain.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface RoomPort {
    Optional<Room> findById(long id);
    Page<Room> findAll(Pageable pageable);
    Room save(Room room);
}
