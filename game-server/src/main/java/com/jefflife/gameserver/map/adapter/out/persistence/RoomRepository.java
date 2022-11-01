package com.jefflife.gameserver.map.adapter.out.persistence;

import com.jefflife.gameserver.map.application.port.out.RoomPort;
import com.jefflife.gameserver.map.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>, RoomPort {
}
