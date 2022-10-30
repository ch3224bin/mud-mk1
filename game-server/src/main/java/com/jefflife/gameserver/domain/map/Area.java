package com.jefflife.gameserver.domain.map;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "area")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @AllArgsConstructor @Builder @EqualsAndHashCode(of = "id")
public class Area {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	// 인스턴스인지, 그냥 오픈맵인지 타입
	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	private Type type;
	
	@OneToMany
	@JoinTable(name = "area_room",
			joinColumns = @JoinColumn(name = "area_id", nullable = false),
			inverseJoinColumns = @JoinColumn(name = "room_id", nullable =  false, unique = true))
	private List<Room> rooms;

	public enum Type {
		INSTANCE_MAP,
		OPEN_MAP
	}
}
