package com.jefflife.gameserver.item.adapter.out.persistence;

import com.jefflife.gameserver.item.adapter.out.persistence.entity.FloorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorRepository extends JpaRepository<FloorEntity, Long> {
}
