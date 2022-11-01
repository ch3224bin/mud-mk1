package com.jefflife.gameserver.map.application.service;

import com.jefflife.gameserver.map.application.port.in.*;
import com.jefflife.gameserver.map.application.port.out.RoomPort;
import com.jefflife.gameserver.map.domain.Direction;
import com.jefflife.gameserver.map.domain.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RoomService implements LoadRoomQuery, ManageRoomUseCase {

	private final RoomPort roomPort;

	public RoomService(RoomPort roomPort) {
		this.roomPort = roomPort;
	}

	@Override
	public RoomModel getRoom(final long id) {
		return roomPort.findById(id)
				.map(RoomModel::new)
				.orElseThrow(() -> new RoomNotFoundException(id));
	}

	@Override
	public Page<RoomModel> getPagedRooms(Pageable pageable) {
		return roomPort.findAll(pageable)
				.map(RoomModel::new);
	}

	@Override
	public RoomModel updateRoom(long id, UpdateRoomCommand updateRoomCommand) {
		Room room = roomPort.findById(id)
				.orElseThrow(() -> new RoomNotFoundException(id));
		room.update(updateRoomCommand.getSummary(), updateRoomCommand.getDescription());
		roomPort.save(room);
		return new RoomModel(room);
	}

	@Override
	public RoomModel createRoom(CreateRoomCommand createRoomCommand) {
		return new RoomModel(roomPort.save(createRoomCommand.toEntity()));
	}

	@Override
	public LinkedRoomResponse linkAnotherRoom(long roomId1, long roomId2, String dir1, String dir2) {
		Room room1 = roomPort.findById(roomId1).orElseThrow(() -> new RoomNotFoundException(roomId1));
		Room room2 = roomPort.findById(roomId2).orElseThrow(() -> new RoomNotFoundException(roomId2));
		room1.linkAnotherRoom(room2, Direction.valueOf(dir1), Direction.valueOf(dir2));
		return LinkedRoomResponse.of(room1, room2);
	}
}
