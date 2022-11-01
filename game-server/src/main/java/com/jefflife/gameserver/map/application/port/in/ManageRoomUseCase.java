package com.jefflife.gameserver.map.application.port.in;

public interface ManageRoomUseCase {
    RoomModel updateRoom(long id, UpdateRoomCommand req);
    RoomModel createRoom(CreateRoomCommand createRoomCommand);
    LinkedRoomResponse linkAnotherRoom(long roomId1, long roomId2, String dir1, String dir2);
}
