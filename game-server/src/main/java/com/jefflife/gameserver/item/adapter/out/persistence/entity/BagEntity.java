package com.jefflife.gameserver.item.adapter.out.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class BagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "bag")
    private List<BagItemBrokerEntity> items;
}
