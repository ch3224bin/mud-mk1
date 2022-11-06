package com.jefflife.gameserver.map.application.service;

import com.jefflife.gameserver.map.application.port.in.*;
import com.jefflife.gameserver.map.application.port.out.QueryRoomPort;
import com.jefflife.gameserver.map.application.port.out.SaveRoomPort;
import com.jefflife.gameserver.map.domain.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RoomService implements LoadRoomQuery, ManageRoomUseCase, LinkRoomUseCase {

	private final QueryRoomPort queryRoomPort;
	private final SaveRoomPort saveRoomPort;

	public RoomService(QueryRoomPort queryRoomPort, SaveRoomPort saveRoomPort) {
		this.queryRoomPort = queryRoomPort;
		this.saveRoomPort = saveRoomPort;
	}

	@Override
	public RoomModel getRoom(final long id) {
		return new RoomModel(queryRoomPort.findById(id));
	}

	@Override
	public Page<RoomModel> getPagedRooms(Pageable pageable) {
		return queryRoomPort.findAll(pageable)
				.map(RoomModel::new);
	}

	@Override
	public RoomModel updateRoom(long id, UpdateRoomCommand updateRoomCommand) {
		Room room = queryRoomPort.findById(id);
		room.update(updateRoomCommand.getSummary(), updateRoomCommand.getDescription());
		saveRoomPort.save(room);
		return new RoomModel(room);
	}

	@Override
	public RoomModel createRoom(CreateRoomCommand createRoomCommand) {
		return new RoomModel(saveRoomPort.save(createRoomCommand.toDomain()));
	}

	@Override
	public LinkedRoomResponse linkAnotherRoom(LinkRoomCommand linkRoomCommand) {
		Room room1 = queryRoomPort.findById(linkRoomCommand.getSourceRoomId());
		Room room2 = queryRoomPort.findById(linkRoomCommand.getDestinationRoomId());
		room1.linkAnotherRoom(room2, linkRoomCommand.getSourceDir(), linkRoomCommand.getDestinationDir());
		return LinkedRoomResponse.of(room1, room2);
	}
}
