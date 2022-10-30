package com.jefflife.gameserver.domain.map;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "door")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Door {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "is_locked", nullable = false, columnDefinition = "boolean default false")
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
