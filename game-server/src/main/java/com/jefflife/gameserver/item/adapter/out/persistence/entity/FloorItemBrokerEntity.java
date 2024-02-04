package com.jefflife.gameserver.item.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "floor_item_broker")
@DiscriminatorValue("floor")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class FloorItemBrokerEntity extends ItemBrokerEntity {
    @ManyToOne
    @JoinColumn(name = "floor_id", nullable = false)
    private FloorEntity floor;
}
