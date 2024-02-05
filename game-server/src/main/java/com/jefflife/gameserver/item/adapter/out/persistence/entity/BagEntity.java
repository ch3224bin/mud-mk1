package com.jefflife.gameserver.item.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Table(name = "bag")
@Getter
public class BagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "bag")
    private List<BagItemBrokerEntity> items;
}
