package com.jefflife.gameserver.map.application.port.in;

import com.jefflife.gameserver.map.domain.WayOut;
import lombok.Getter;

@Getter
public class WayOutModel {
	private final long id;
	private final long roomId;
	private final long nextRoomId;
	private final String direction;
	private final boolean isShow;
	private final boolean isLocked;
	
	public WayOutModel(WayOut wayout) {
		this.id = wayout.getId();
		this.roomId = wayout.getRoomId();
		this.nextRoomId = wayout.getNextRoomId();
		this.direction = wayout.getDirection().getName();
		this.isShow = wayout.isShow();
		this.isLocked = wayout.getDoor().isLocked();
	}
}
