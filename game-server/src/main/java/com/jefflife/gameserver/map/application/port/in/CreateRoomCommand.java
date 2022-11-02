package com.jefflife.gameserver.map.application.port.in;

import com.jefflife.gameserver.map.domain.Room;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateRoomCommand {
	private String summary;
	private String description;

	public Room toDomain() {
		return Room.withOutId(summary, description);
	}
}
