package com.jefflife.gameserver.player.adapter.out.persistence;

import com.jefflife.gameserver.player.applicatoin.port.out.QueryPlayerPort;
import com.jefflife.gameserver.player.domain.Player;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class PlayerAdapter implements QueryPlayerPort {
    private final PlayerRepository playerRepository;

    public PlayerAdapter(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player findById(long id) {
        return playerRepository.findById(id)
                .map(o -> new Player(o.getId(), o.getRoomId(), o.getName()))
                .orElseThrow(() -> new NoSuchElementException());
    }
}
