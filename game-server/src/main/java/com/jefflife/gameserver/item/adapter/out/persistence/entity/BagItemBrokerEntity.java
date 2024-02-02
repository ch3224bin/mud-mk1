package com.jefflife.gameserver.item.adapter.out.persistence.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("bag")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class BagItemBrokerEntity extends ItemBrokerEntity {
    @ManyToOne
    @JoinColumn(name = "bag_id", nullable = false)
    private BagEntity bag;

    public BagItemBrokerEntity(ItemEntity item, BagEntity bag) {
        super(item);
        this.bag = bag;
    }
}
