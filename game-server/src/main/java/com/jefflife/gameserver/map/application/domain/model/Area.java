package com.jefflife.gameserver.map.application.domain.model;

import lombok.*;

import java.util.List;

@Getter @AllArgsConstructor @Builder @EqualsAndHashCode(of = "id")
public class Area {
	private Long id;
	private String name;
	private AreaType type;
	private List<Room> rooms;
}
