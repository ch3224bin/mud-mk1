package com.jefflife.gameserver.map.domain;

import lombok.AccessLevel;
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

	public static Door setup(WayOut wo1, WayOut wo2) {
		Door door = new Door();
		wo1.installDoor(door);
		wo2.installDoor(door);
		return door;
	}
}
