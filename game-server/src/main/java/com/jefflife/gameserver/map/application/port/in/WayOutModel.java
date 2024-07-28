package com.jefflife.gameserver.map.application.port.in;

import com.jefflife.common.model.WayOutCommonModel;
import com.jefflife.gameserver.map.application.domain.model.WayOut;
import lombok.Getter;

@Getter
public class WayOutModel extends WayOutCommonModel {
	public WayOutModel(WayOut wayout) {
		super(wayout.getId(), wayout.getRoomId(), wayout.getNextRoomId(), wayout.getDirection().name(), wayout.getDirection().getName(), wayout.isShow(), wayout.getDoor().isLocked());
	}
}
