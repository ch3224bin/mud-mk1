package com.jefflife.gameserver.map.application.domain.service;

import com.jefflife.gameserver.map.application.port.in.*;
import com.jefflife.gameserver.map.application.port.out.LoadRoomPort;
import com.jefflife.gameserver.map.application.port.out.SaveRoomPort;
import com.jefflife.gameserver.map.application.domain.model.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class RoomService implements LoadRoomQuery, ManageRoomUseCase, LinkRoomUseCase {

	private final LoadRoomPort loadRoomPort;
	private final SaveRoomPort saveRoomPort;

	public RoomService(LoadRoomPort loadRoomPort, SaveRoomPort saveRoomPort) {
		this.loadRoomPort = loadRoomPort;
		this.saveRoomPort = saveRoomPort;
	}

	@Override
	public RoomModel getRoom(final long id) {
		return new RoomModel(loadRoomPort.findById(id));
	}

	@Override
	public Page<RoomModel> getPagedRooms(Pageable pageable) {
		return loadRoomPort.findAll(pageable)
				.map(RoomModel::new);
	}

	@Override
	public RoomModel updateRoom(long id, UpdateRoomCommand updateRoomCommand) {
		Room room = loadRoomPort.findById(id);
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
		Room room1 = loadRoomPort.findById(linkRoomCommand.getSourceRoomId());
		Room room2 = loadRoomPort.findById(linkRoomCommand.getDestinationRoomId());
		room1.linkAnotherRoom(room2, linkRoomCommand.getSourceDir(), linkRoomCommand.getDestinationDir());
		return LinkedRoomResponse.of(room1, room2);
	}
}
