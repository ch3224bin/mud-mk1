package com.jefflife.gameserver.map.adapter.out.persistence.entity;

import com.jefflife.gameserver.map.domain.AreaType;
import lombok.*;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "area")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @AllArgsConstructor @Builder @EqualsAndHashCode(of = "id")
public class AreaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	private AreaType type;
	
	@OneToMany
	@JoinTable(name = "area_room",
			joinColumns = @JoinColumn(name = "area_id", nullable = false),
			inverseJoinColumns = @JoinColumn(name = "room_id", nullable =  false, unique = true))
	private List<RoomEntity> rooms;

	public AreaEntity(String name, AreaType type) {
		this.name = name;
		this.type = type;
	}
}
