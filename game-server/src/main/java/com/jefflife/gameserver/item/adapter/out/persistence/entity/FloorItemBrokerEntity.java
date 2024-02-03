package com.jefflife.gameserver.item.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "floor_item_broker")
@Getter
public class FloorItemBrokerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "item_id", nullable = false, unique = true, updatable = false)
    private ItemEntity item;
}
