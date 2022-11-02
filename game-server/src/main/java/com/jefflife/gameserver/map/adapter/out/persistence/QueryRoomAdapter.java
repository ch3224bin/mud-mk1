package com.jefflife.gameserver.map.adapter.out.persistence;

import com.jefflife.gameserver.map.application.port.out.QueryRoomPort;
import com.jefflife.gameserver.map.application.port.out.SaveRoomPort;
import com.jefflife.gameserver.map.domain.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class QueryRoomAdapter implements QueryRoomPort, SaveRoomPort {
    private final RoomRepository roomRepository;

    public QueryRoomAdapter(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Room findById(long id) {
        return roomRepository.findById(id)
                .map(RoomEntity::toDomain)
                .orElseThrow(() -> new RoomNotFoundException(id));
    }

    @Override
    public Page<Room> findAll(Pageable pageable) {
        return RoomEntity.toPage(roomRepository.findAll(pageable));
    }

    @Override
    public Room save(Room room) {
        return RoomEntity.toDomain(roomRepository.save(new RoomEntity(room)));
    }
}
