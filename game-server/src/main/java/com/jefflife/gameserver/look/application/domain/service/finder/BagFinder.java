package com.jefflife.gameserver.look.application.domain.service.finder;

import com.jefflife.common.model.ItemsCommonModel;
import com.jefflife.common.model.PlayerCommonModel;
import com.jefflife.common.model.VisibleObject;
import com.jefflife.gameserver.look.application.port.in.LookCommandDataRequest;
import com.jefflife.gameserver.look.application.port.out.FindItemPort;
import com.jefflife.gameserver.look.application.port.out.FindPlayerPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BagFinder implements Finder {
    private final FindPlayerPort findPlayerPort;
    private final FindItemPort findItemPort;

    public BagFinder(FindPlayerPort findPlayerPort, FindItemPort findItemPort) {
        this.findPlayerPort = findPlayerPort;
        this.findItemPort = findItemPort;
    }

    @Override
    public Optional<? extends VisibleObject> find(long playerId, LookCommandDataRequest commandData) {
        if (!commandData.hasTarget()) {
            return Optional.empty();
        }

        PlayerCommonModel player = findPlayerPort.findPlayerById(playerId);
        ItemsCommonModel items = findItemPort.findByBagId(player.getBagId());
        return items.findFirstByNameLike(commandData.getTarget());
    }
}
