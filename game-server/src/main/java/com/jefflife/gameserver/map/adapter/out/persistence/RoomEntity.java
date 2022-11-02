package com.jefflife.gameserver.map.adapter.out.persistence;

import com.jefflife.gameserver.map.domain.Room;
import lombok.*;
import org.springframework.data.domain.Page;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "room")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @AllArgsConstructor @Builder @EqualsAndHashCode(of = "id")
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

	public RoomEntity(Room room) {
		this.id = room.getId();
		this.summary = room.getSummary();
		this.description = room.getDescription();
	}

	public static Page<Room> toPage(Page<RoomEntity> page) {
		return null;
	}

	public static Room toDomain(RoomEntity roomEntity) {
		return Room.of(
				roomEntity.getId(),
				roomEntity.getSummary(),
				roomEntity.getDescription(),
				WayOutEntity.toDomainList(roomEntity.getWayOuts())
		);
	}
}
