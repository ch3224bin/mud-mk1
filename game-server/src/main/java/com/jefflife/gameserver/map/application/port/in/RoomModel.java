package com.jefflife.gameserver.map.application.port.in;

import com.jefflife.common.model.RoomCommonModel;
import com.jefflife.common.model.WayOutCommonModel;
import com.jefflife.gameserver.map.domain.Room;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.server.core.Relation;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@EqualsAndHashCode(of = "id")
@Relation(collectionRelation = "rooms", itemRelation = "room")
public class RoomModel implements RoomCommonModel {

	private final long id;
	private final String summary;
	private final String description;
	private final List<WayOutCommonModel> wayOuts;
	private final String exitString;

	public RoomModel(Room room) {
		this.id = room.getId();
		this.summary = room.getSummary();
		this.description = room.getDescription();
		this.wayOuts = getSortedWayOuts(room);
		this.exitString = room.getExitString();
	}

	private static List<WayOutCommonModel> getSortedWayOuts(Room room) {
		return room.getSortedWayOuts().stream()
			.map(WayOutModel::new)
			.collect(Collectors.toList());
	}
}
