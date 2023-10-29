package com.jefflife.gameserver.map.application.domain.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Door {
	private long id;
	private boolean isLocked = false;

	public void unlock() {
		this.isLocked = false;
	}

	public void lock() {
		this.isLocked = true;
	}

	@Builder
	public Door(long id, boolean isLocked) {
		this.id = id;
		this.isLocked = isLocked;
	}

	public static Door setup(WayOut wo1, WayOut wo2) {
		Door door = new Door();
		wo1.installDoor(door);
		wo2.installDoor(door);
		return door;
	}
}
