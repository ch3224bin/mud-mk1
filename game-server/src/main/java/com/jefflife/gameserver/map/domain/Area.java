package com.jefflife.gameserver.map.domain;

import lombok.*;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @AllArgsConstructor @Builder @EqualsAndHashCode(of = "id")
public class Area {
	private long id;
	private String name;
	private AreaType type;
	private List<Room> rooms;
}
