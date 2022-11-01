package com.jefflife.gameserver.map.application.port.in;

import com.jefflife.gameserver.map.domain.Room;
import lombok.Getter;

import java.util.List;

@Getter
public class LinkedRoomResponse {
    private final List<Room> linkedRooms;

    public LinkedRoomResponse(List<Room> linkedRooms) {
        this.linkedRooms = linkedRooms;
    }

    public static LinkedRoomResponse of(Room room1, Room room2) {
        return new LinkedRoomResponse(List.of(room1, room2));
    }
}
