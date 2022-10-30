package com.jefflife.gameserver.domain.map;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "way_out")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @AllArgsConstructor @Builder
public class WayOut implements Comparable<WayOut> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name = "room_id", nullable = false)
	private Room room;

	@Enumerated(EnumType.STRING)
	@Column(name = "direction", nullable = false)
	private Direction direction;

	@OneToOne
	@JoinColumn(name = "next_room_id", nullable = false)
	private Room nextRoom;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "door_id", nullable = false)
	private Door door;

	@Column(name = "is_show", nullable = false, columnDefinition = "boolean default true")
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
		WayOut anotherWayOut = anotherRoom.createWayout(this.room, yourWay);
		Door.setup(this, anotherWayOut);
	}
}
