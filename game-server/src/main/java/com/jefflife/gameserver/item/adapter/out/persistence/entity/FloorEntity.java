package com.jefflife.gameserver.item.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Table(name = "floor")
@Getter
public class FloorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "floor")
    private List<FloorItemBrokerEntity> items;
}
