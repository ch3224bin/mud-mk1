package com.jefflife.gameserver.map.application.port.in;

import com.jefflife.gameserver.map.domain.Room;
import lombok.Getter;
import org.springframework.hateoas.server.core.Relation;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Relation(collectionRelation = "rooms", itemRelation = "room")
public class RoomModel {
	private final long id;
	private final String summary;
	private final String description;
	private final List<WayOutModel> wayOuts;
	private final String exitString;
	
	public RoomModel(Room room) {
		this.id = room.getId();
		this.summary = room.getSummary();
		this.description = room.getDescription();
		this.wayOuts = getSortedWayOuts(room);
		this.exitString = room.getExitString();
	}
	private List<WayOutModel> getSortedWayOuts(Room room) {
		return room.getSortedWayOuts().stream()
			.map(WayOutModel::new)
			.collect(Collectors.toList());
	}
}
