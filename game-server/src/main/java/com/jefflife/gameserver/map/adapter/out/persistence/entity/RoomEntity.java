package com.jefflife.gameserver.map.adapter.out.persistence.entity;

import com.jefflife.gameserver.map.application.domain.model.Room;
import lombok.*;
import org.springframework.data.domain.Page;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "room")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @EqualsAndHashCode(of = "id")
public class RoomEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "summary", nullable = false)
	private String summary;

	@Column(name = "description", nullable = false)
	private String description;

	@OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<WayOutEntity> wayOuts = new ArrayList<>();

	@Column(name = "floor_id", nullable = false)
	private long floorId;

	@Builder
	public RoomEntity(long id, String summary, String description, List<WayOutEntity> wayOuts, long floorId) {
		this.id = id;
		this.summary = summary;
		this.description = description;
		this.wayOuts = wayOuts;
		this.floorId = floorId;
	}

	public RoomEntity(Room room) {
		this.id = room.getId();
		this.summary = room.getSummary();
		this.description = room.getDescription();
	}

	public static Page<Room> toPage(Page<RoomEntity> page) {
		return null;
	}

	public Room toDomain() {
		return Room.of(
				id,
				summary,
				description,
				WayOutEntity.toDomainList(wayOuts),
				floorId
		);
	}
}
