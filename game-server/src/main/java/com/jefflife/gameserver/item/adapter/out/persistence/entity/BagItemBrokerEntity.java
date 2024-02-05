package com.jefflife.gameserver.item.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bag_item_broker")
@DiscriminatorValue("bag")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class BagItemBrokerEntity extends ItemBrokerEntity {
    @ManyToOne
    @JoinColumn(name = "bag_id", nullable = false)
    private BagEntity bag;
}
