package com.jefflife.gameserver.player.applicatoin.domain.service.finder;

import com.jefflife.common.model.PlayerCommonModel;
import com.jefflife.common.model.VisibleObject;
import com.jefflife.gameserver.command.look.application.domain.Finder;
import com.jefflife.gameserver.command.look.application.domain.LookCommandDataRequest;
import com.jefflife.gameserver.player.applicatoin.port.in.LoadPlayerQuery;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Order(3)
public class PlayerFinder implements Finder {
    private final LoadPlayerQuery loadPlayerQuery;

    public PlayerFinder(LoadPlayerQuery loadPlayerQuery) {
        this.loadPlayerQuery = loadPlayerQuery;
    }

    @Override
    public Optional<? extends VisibleObject> find(long playerId, LookCommandDataRequest commandData) {
        if (!commandData.hasTarget()) {
            return Optional.empty();
        }

        PlayerCommonModel player = loadPlayerQuery.getPlayer(playerId);
        List<PlayerCommonModel> players = loadPlayerQuery.getPlayersByRoomId(player.getRoomId());
        return players.stream()
                .filter(p -> p.getName().contains(commandData.getTarget()))
                .findFirst();
    }
}
