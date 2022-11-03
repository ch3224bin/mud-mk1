package com.jefflife.gameserver.map.adapter.out.persistence;

import com.jefflife.gameserver.map.adapter.out.persistence.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<RoomEntity, Long> {
}
