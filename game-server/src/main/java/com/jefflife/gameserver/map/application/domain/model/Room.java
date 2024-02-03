package com.jefflife.gameserver.map.application.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;
import java.util.Optional;

@EqualsAndHashCode(of = "id")
public class Room {
	@Getter private final Long id;
	@Getter private String summary;
	@Getter private String description;
	@Getter private long floorId;
	private final WayOuts wayOuts;

	private Room(Long id, String summary, String description, List<WayOut> wayOuts, long floorId) {
		this(id, summary, description, new WayOuts(wayOuts), floorId);
	}

	private Room(Long id, String summary, String description, WayOuts wayOuts, long floorId) {
		this.id = id;
		this.summary = summary;
		this.description = description;
		this.wayOuts = wayOuts;
		this.floorId = floorId;
	}

	public static Room of(long id, String summary, String description, List<WayOut> wayOuts, long floorId) {
		return new Room(id, summary, description, wayOuts, floorId);
	}

	public static Room withOutWayOuts(long id, String summary, String description) {
		return new Room(id, summary, description, new WayOuts(), 0L);
	}

	public static Room withOutId(String summary, String description) {
		return new Room(null, summary, description, new WayOuts(), 0L);
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
				.roomId(id)
				.nextRoomId(nextRoom.id)
				.build();
		wayOuts.add(wayout);
		return wayout;
	}

	public void linkAnotherRoom(Room anotherRoom, Direction myWay, Direction yourWay) {
		WayOut wayOut = this.createWayOut(anotherRoom, myWay);
		linkAnotherRoom(wayOut, anotherRoom, yourWay);
	}

	private void linkAnotherRoom(WayOut wayOut, Room anotherRoom, Direction yourWay) {
		WayOut anotherWayOut = anotherRoom.createWayOut(this, yourWay);
		Door.setup(wayOut, anotherWayOut);
	}

	public void update(String summary, String description) {
		this.summary = summary;
		this.description = description;
	}
}
