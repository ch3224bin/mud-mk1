package com.jefflife.gameserver.map.domain;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class WayOut implements Comparable<WayOut> {
	private long id;
	private long roomId;
	private long nextRoomId;
	private Direction direction;
	private Door door;
	private boolean isShow = true;


	@Builder
	public WayOut(long id, long roomId, long nextRoomId, Direction direction, Door door, boolean isShow) {
		this.id = id;
		this.roomId = roomId;
		this.nextRoomId = nextRoomId;
		this.direction = direction;
		this.door = door;
		this.isShow = isShow;
	}

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
}
