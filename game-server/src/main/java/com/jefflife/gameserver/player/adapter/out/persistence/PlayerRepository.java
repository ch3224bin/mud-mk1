package com.jefflife.gameserver.player.adapter.out.persistence;

import com.jefflife.gameserver.player.adapter.out.persistence.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {
    List<PlayerEntity> findByRoomId(long roomId);
}
