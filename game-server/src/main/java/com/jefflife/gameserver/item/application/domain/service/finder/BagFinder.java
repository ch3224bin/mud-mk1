package com.jefflife.gameserver.item.application.domain.service.finder;

import com.jefflife.common.model.PlayerCommonModel;
import com.jefflife.common.model.VisibleObject;
import com.jefflife.gameserver.command.application.look.domain.Finder;
import com.jefflife.gameserver.command.application.look.domain.LookCommandDataRequest;
import com.jefflife.gameserver.item.application.domain.service.model.ItemsCommonModel;
import com.jefflife.gameserver.item.application.port.out.LoadItemPort;
import com.jefflife.gameserver.player.applicatoin.port.in.LoadPlayerQuery;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Order(2)
public class BagFinder implements Finder {
    private final LoadPlayerQuery loadPlayerQuery;
    private final LoadItemPort loadItemPort;

    public BagFinder(
            final LoadPlayerQuery loadPlayerQuery,
            final LoadItemPort loadItemPort
    ) {
        this.loadPlayerQuery = loadPlayerQuery;
        this.loadItemPort = loadItemPort;
    }

    @Override
    public Optional<? extends VisibleObject> find(long playerId, LookCommandDataRequest commandData) {
        if (!commandData.hasTarget()) {
            return Optional.empty();
        }

        PlayerCommonModel player = loadPlayerQuery.getPlayer(playerId);
        ItemsCommonModel items = ItemsCommonModel.fromDomain(loadItemPort.findByBagId(player.getBagId()));
        return items.findFirstByNameLike(commandData.getTarget());
    }
}
