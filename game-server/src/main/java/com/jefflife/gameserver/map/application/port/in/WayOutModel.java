package com.jefflife.gameserver.map.application.port.in;

import com.jefflife.common.model.WayOutCommonModel;
import com.jefflife.gameserver.map.domain.WayOut;

public class WayOutModel extends WayOutCommonModel {
	public WayOutModel(WayOut wayout) {
		super(wayout.getId(), wayout.getRoomId(), wayout.getNextRoomId(), wayout.getDirection().getName(), wayout.isShow(), wayout.getDoor().isLocked());
	}
}
