package com.jefflife.gameserver.map.application.port.in;

public interface LinkRoomUseCase {
    LinkedRoomResponse linkAnotherRoom(LinkRoomCommand linkRoomCommand);
}
