package com.jefflife.gameserver.map.domain;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @AllArgsConstructor @Builder
public class WayOut implements Comparable<WayOut> {
	private long id;
	private Room room;
	private Direction direction;
	private Room nextRoom;
	private Door door;
	private boolean isShow = true;

	@Override
	public int compareTo(WayOut o) {
		return Integer.compare(this.direction.ordinal(), o.direction.ordinal());
	}

	public String toString() {
		return direction.getName() + (this.getDoor().isLocked() ? "(잠김)" : "");
	}

	public void installDoor(Door door) {
		this.door = door;
	}

	public void linkAnotherRoom(Room anotherRoom, Direction yourWay) {
		WayOut anotherWayOut = anotherRoom.createWayOut(this.room, yourWay);
		Door.setup(this, anotherWayOut);
	}
}
