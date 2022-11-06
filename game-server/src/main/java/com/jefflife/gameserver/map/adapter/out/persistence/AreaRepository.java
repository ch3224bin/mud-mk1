package com.jefflife.gameserver.map.adapter.out.persistence;

import com.jefflife.gameserver.map.adapter.out.persistence.entity.AreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRepository extends JpaRepository<AreaEntity, Long> {
}
