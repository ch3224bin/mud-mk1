package com.jefflife.gameserver.player.adapter.out.persistence;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "player")
@Getter
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long roomId;

    private String name;
}
