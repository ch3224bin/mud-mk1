package com.jefflife.gameserver.look.application.domain.service.finder;

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

        return Direction.of(commandData.getTarget())
                .flatMap(direction -> findRoomPort.findByPlayerId(playerId).getWayOuts().stream()
                .filter(wayOut -> direction.matchesDirection(wayOut.getDirection()))
                .map(wayOut -> findRoomPort.findById(wayOut.getNextRoomId()))
                .findFirst());
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


        public static Optional<Direction> of(String direction) {
            for (Direction value : values()) {
                if (value.synonyms.contains(direction)) {
                    return Optional.of(value);
                }
            }

            return Optional.empty();
        }

        public boolean matchesDirection(String direction) {
            return synonyms.contains(direction);
        }
    }
}
