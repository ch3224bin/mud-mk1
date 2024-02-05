package com.jefflife.gameserver.player.adapter.out.persistence;

import com.jefflife.gameserver.player.applicatoin.port.out.LoadPlayerPort;
import com.jefflife.gameserver.player.applicatoin.domain.model.Player;
import org.springframework.stereotype.Component;

import java.util.List;
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
                .map(o -> new Player(o.getId(), o.getRoomId(), o.getName(), o.getBagId()))
                .orElseThrow(() -> new NoSuchElementException("Player not found. player id: " + id));
    }

    @Override
    public List<Player> findByRoomId(long roomId) {
        return playerRepository.findByRoomId(roomId).stream()
                .map(o -> new Player(o.getId(), o.getRoomId(), o.getName(), o.getBagId()))
                .toList();
    }
}
