package com.jefflife.gameserver.map.adapter.out.persistence;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "door")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class DoorEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "is_locked", nullable = false, columnDefinition = "boolean default false")
	private boolean isLocked = false;
}
