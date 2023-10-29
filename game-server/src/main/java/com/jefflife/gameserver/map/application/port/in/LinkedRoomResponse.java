package com.jefflife.gameserver.map.application.port.in;

import com.jefflife.gameserver.map.application.domain.model.Room;

import java.util.List;

public record LinkedRoomResponse(List<Room> linkedRooms) {

    public static LinkedRoomResponse of(Room room1, Room room2) {
        return new LinkedRoomResponse(List.of(room1, room2));
    }
}
