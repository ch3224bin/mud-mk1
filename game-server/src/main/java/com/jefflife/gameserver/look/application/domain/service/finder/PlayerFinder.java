package com.jefflife.gameserver.look.application.domain.service.finder;

import com.jefflife.common.model.PlayerCommonModel;
import com.jefflife.common.model.VisibleObject;
import com.jefflife.gameserver.look.application.port.in.LookCommandDataRequest;
import com.jefflife.gameserver.look.application.port.out.FindPlayerPort;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Order(3)
public class PlayerFinder implements Finder {
    private final FindPlayerPort findPlayerPort;

    public PlayerFinder(FindPlayerPort findPlayerPort) {
        this.findPlayerPort = findPlayerPort;
    }

    @Override
    public Optional<? extends VisibleObject> find(long playerId, LookCommandDataRequest commandData) {
        if (!commandData.hasTarget()) {
            return Optional.empty();
        }

        PlayerCommonModel player = findPlayerPort.findPlayerById(playerId);
        List<PlayerCommonModel> players = findPlayerPort.findByRoomId(player.getRoomId());
        return players.stream()
                .filter(p -> p.getName().contains(commandData.getTarget()))
                .findFirst();
    }
}
