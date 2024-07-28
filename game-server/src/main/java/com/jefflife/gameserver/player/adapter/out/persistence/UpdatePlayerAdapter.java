package com.jefflife.gameserver.player.adapter.out.persistence;

import com.jefflife.gameserver.player.adapter.out.persistence.entity.PlayerEntity;
import com.jefflife.gameserver.player.applicatoin.port.out.UpdatePlayerPositionPort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class UpdatePlayerAdapter implements UpdatePlayerPositionPort {
    private final PlayerRepository playerRepository;

    public UpdatePlayerAdapter(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public void updatePlayerPosition(long id, long roomId) {
        PlayerEntity playerEntity = playerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Player not found. playerId: " + id));
        playerEntity.setRoomId(roomId);
    }
}
