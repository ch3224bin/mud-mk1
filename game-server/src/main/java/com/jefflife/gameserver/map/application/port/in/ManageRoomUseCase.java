package com.jefflife.gameserver.map.application.port.in;

public interface ManageRoomUseCase {
    RoomModel updateRoom(long id, UpdateRoomCommand req);
    RoomModel createRoom(CreateRoomCommand createRoomCommand);
    LinkedRoomResponse linkAnotherRoom(LinkRoomCommand linkRoomCommand);
}
