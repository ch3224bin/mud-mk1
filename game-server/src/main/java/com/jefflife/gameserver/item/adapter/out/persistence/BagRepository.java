package com.jefflife.gameserver.item.adapter.out.persistence;

import com.jefflife.gameserver.item.adapter.out.persistence.entity.BagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BagRepository extends JpaRepository<BagEntity, Long> {
}
