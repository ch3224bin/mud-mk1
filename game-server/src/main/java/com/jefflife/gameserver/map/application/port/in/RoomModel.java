package com.jefflife.gameserver.map.application.port.in;

import com.jefflife.common.model.RoomCommonModel;
import com.jefflife.common.model.WayOutCommonModel;
import com.jefflife.gameserver.map.application.domain.model.Room;
import lombok.Getter;
import org.springframework.hateoas.server.core.Relation;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Relation(collectionRelation = "rooms", itemRelation = "room")
public class RoomModel extends RoomCommonModel {
	public RoomModel(Room room) {
		super(room.getId(), room.getSummary(), room.getDescription(), getSortedWayOuts(room), room.getExitString(), room.getFloorId());
	}

	private static List<WayOutCommonModel> getSortedWayOuts(Room room) {
		return room.getSortedWayOuts().stream()
			.map(WayOutModel::new)
			.collect(Collectors.toList());
	}
}
