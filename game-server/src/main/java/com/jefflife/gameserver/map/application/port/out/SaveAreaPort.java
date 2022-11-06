package com.jefflife.gameserver.map.application.port.out;

import com.jefflife.gameserver.map.domain.Area;

public interface SaveAreaPort {
    Area save(Area area);
}
