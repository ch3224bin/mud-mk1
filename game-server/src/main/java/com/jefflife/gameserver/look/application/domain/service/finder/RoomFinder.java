package com.jefflife.gameserver.look.application.domain.service.finder;

import com.jefflife.common.model.ItemsCommonModel;
import com.jefflife.common.model.RoomCommonModel;
import com.jefflife.common.model.VisibleObject;
import com.jefflife.gameserver.look.application.port.in.LookCommandDataRequest;
import com.jefflife.gameserver.look.application.port.out.FindItemPort;
import com.jefflife.gameserver.look.application.port.out.FindRoomPort;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Order(1)
public class RoomFinder implements Finder {
    private final FindRoomPort findRoomPort;
    private final FindItemPort findItemPort;

    public RoomFinder(FindRoomPort findRoomPort, FindItemPort findItemPort) {
        this.findRoomPort = findRoomPort;
        this.findItemPort = findItemPort;
    }

    @Override
    public Optional<? extends VisibleObject> find(long playerId, LookCommandDataRequest commandData) {
        RoomCommonModel room = findRoomPort.findByPlayerId(playerId);
        if (!commandData.hasTarget()) {
            return Optional.of(room);
        }

        ItemsCommonModel items = findItemPort.findByFloorId(room.getFloorId());
        return items.findFirstByNameLike(commandData.getTarget());
    }
}
