package com.jefflife.gameserver.player.adapter.out.persistence.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Table(name = "player")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long roomId;

    private String name;
    private long bagId;

    public PlayerEntity(long id, long roomId, String name, long bagId) {
        this.id = id;
        this.roomId = roomId;
        this.name = name;
        this.bagId = bagId;
    }
}
