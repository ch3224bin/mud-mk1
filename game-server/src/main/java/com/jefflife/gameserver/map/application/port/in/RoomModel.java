package com.jefflife.gameserver.map.application.port.in;

import com.jefflife.common.model.RoomCommonModel;
import com.jefflife.common.model.WayOutCommonModel;
import com.jefflife.gameserver.map.domain.Room;
import org.springframework.hateoas.server.core.Relation;

import java.util.List;
import java.util.stream.Collectors;

@Relation(collectionRelation = "rooms", itemRelation = "room")
public class RoomModel extends RoomCommonModel {
	public RoomModel(Room room) {
		super(room.getId(), room.getSummary(), room.getDescription(), getSortedWayOuts(room), room.getExitString());
	}

	private static List<WayOutCommonModel> getSortedWayOuts(Room room) {
		return room.getSortedWayOuts().stream()
			.map(WayOutModel::new)
			.collect(Collectors.toList());
	}
}
