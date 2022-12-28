package com.jefflife.gameserver.player.adapter.out.persistence;

import com.jefflife.gameserver.player.adapter.out.persistence.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {
}
