package com.jefflife.gameserver.look.application.domain.service.finder;

import com.jefflife.common.model.RoomCommonModel;
import com.jefflife.common.model.VisibleObject;
import com.jefflife.gameserver.look.application.port.in.LookCommandDataRequest;
import com.jefflife.gameserver.look.application.port.out.FindRoomPort;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

@Component
@Order(4)
public class DirectionFinder implements Finder {
    private final FindRoomPort findRoomPort;

    public DirectionFinder(FindRoomPort findRoomPort) {
        this.findRoomPort = findRoomPort;
    }

    @Override
    public Optional<? extends VisibleObject> find(long playerId, LookCommandDataRequest commandData) {
        if (!commandData.hasTarget()) {
            return Optional.empty();
        }

        final Direction direction = Direction.of(commandData.getTarget());
        if (direction == null) {
            return Optional.empty();
        }

        RoomCommonModel room = findRoomPort.findByPlayerId(playerId);
        return room.getWayOuts().stream()
                .filter(wayOut -> direction.matchedName(wayOut.getDirection()))
                .map(wayOut -> findRoomPort.findById(wayOut.getNextRoomId()))
                .findFirst();
    }

    enum Direction {
        NORTH(Set.of("북", "ㅂ")),
        SOUTH(Set.of("남", "ㄴ")),
        EAST(Set.of("동", "ㄷ")),
        WEST(Set.of("서", "ㅅ")),
        UP(Set.of("위")),
        DOWN(Set.of("아래"));

        private final Set<String> synonyms;

        Direction(Set<String> synonyms) {
            this.synonyms = synonyms;
        }


        public static Direction of(String direction) {
            for (Direction value : values()) {
                if (value.synonyms.contains(direction)) {
                    return value;
                }
            }

            return null;
        }

        public boolean matchedName(String direction) {
            return synonyms.contains(direction);
        }
    }
}
