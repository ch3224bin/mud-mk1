package com.jefflife.gameserver.player.adapter.out.persistence;

import com.jefflife.gameserver.player.applicatoin.port.out.LoadPlayerPort;
import com.jefflife.gameserver.player.applicatoin.domain.model.Player;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class LoadPlayerAdapter implements LoadPlayerPort {
    private final PlayerRepository playerRepository;

    public LoadPlayerAdapter(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player findById(long id) {
        return playerRepository.findById(id)
                .map(o -> new Player(o.getId(), o.getRoomId(), o.getName()))
                .orElseThrow(() -> new NoSuchElementException("Player not found. player id: " + id));
    }
}
