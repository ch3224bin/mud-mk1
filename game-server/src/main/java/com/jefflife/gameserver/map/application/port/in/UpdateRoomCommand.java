package com.jefflife.gameserver.map.application.port.in;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UpdateRoomCommand {
	private String summary;
	private String description;
}
