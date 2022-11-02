package com.jefflife.gameserver.map.domain;

import lombok.Getter;

import java.util.List;
import java.util.Optional;

public class Room {
	@Getter private final Long id;
	@Getter private String summary;
	@Getter private String description;
	private final WayOuts wayOuts;

	private Room(Long id, String summary, String description, List<WayOut> wayOuts) {
		this(id, summary, description, new WayOuts(wayOuts));
	}

	private Room(Long id, String summary, String description, WayOuts wayOuts) {
		this.id = id;
		this.summary = summary;
		this.description = description;
		this.wayOuts = wayOuts;
	}

	public static Room of(Long id, String summary, String description, List<WayOut> wayOuts) {
		return new Room(id, summary, description, wayOuts);
	}

	public static Room withOutWayOuts(Long id, String summary, String description) {
		return new Room(id, summary, description, new WayOuts());
	}

	public static Room withOutId(String summary, String description) {
		return new Room(null, summary, description, new WayOuts());
	}

	public List<WayOut> getSortedWayOuts() {
		return wayOuts.getSortedWayOuts();
	}

	public String getExitString() {
		return wayOuts.getExitString();
	}

	public Optional<WayOut> getWayOutByDirection(Direction direction) {
		return wayOuts.getWayOutByDirection(direction);
	}

	public WayOut createWayOut(Room nextRoom, Direction direction) {
		WayOut wayout = WayOut.builder()
				.direction(direction)
				.room(this)
				.nextRoom(nextRoom)
				.build();
		wayOuts.add(wayout);
		return wayout;
	}

	public void linkAnotherRoom(Room anotherRoom, Direction myWay, Direction yourWay) {
		this.createWayOut(anotherRoom, myWay)
			.linkAnotherRoom(anotherRoom, yourWay);
	}

	public void update(String summary, String description) {
		this.summary = summary;
		this.description = description;
	}
}
