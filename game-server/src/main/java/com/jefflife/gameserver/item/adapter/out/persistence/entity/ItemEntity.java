package com.jefflife.gameserver.item.adapter.out.persistence.entity;

import com.jefflife.gameserver.item.application.domain.model.Item;
import com.jefflife.gameserver.item.application.domain.model.ItemGrade;
import com.jefflife.gameserver.item.application.domain.model.ItemType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "item")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode(of = "id")
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "is_gettable", nullable = false)
    private boolean isGettable;
    @Enumerated(EnumType.STRING)
    @Column(name = "grade", nullable = false)
    private ItemGrade grade;
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private ItemType type;

    public Item toDomain() {
        return new Item(id, name, description, isGettable, grade);
    }
}
