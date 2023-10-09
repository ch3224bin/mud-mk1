package com.jefflife.gameserver.map.adapter.out.persistence.entity;

import com.jefflife.gameserver.map.domain.Direction;
import com.jefflife.gameserver.map.domain.WayOut;
import lombok.*;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "way_out")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @AllArgsConstructor @Builder
public class WayOutEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name = "room_id", nullable = false)
	private RoomEntity room;

	@Enumerated(EnumType.STRING)
	@Column(name = "direction", nullable = false)
	private Direction direction;

	@OneToOne
	@JoinColumn(name = "next_room_id", nullable = false)
	private RoomEntity nextRoom;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "door_id", nullable = false)
	private DoorEntity door;

	@Column(name = "is_show", nullable = false, columnDefinition = "boolean default true")
	private boolean isShow = true;

	public static List<WayOut> toDomainList(List<WayOutEntity> wayOuts) {
		return wayOuts.stream()
				.map(WayOutEntity::toDomain)
				.toList();
	}

	public WayOut toDomain() {
		return WayOut.builder()
				.id(this.id)
				.roomId(this.room.getId())
				.direction(this.direction)
				.nextRoomId(this.nextRoom.getId())
				.door(this.door.toDomain())
				.isShow(this.isShow)
				.build();
	}
}
