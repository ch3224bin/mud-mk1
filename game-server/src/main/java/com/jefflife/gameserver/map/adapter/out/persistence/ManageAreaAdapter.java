package com.jefflife.gameserver.map.adapter.out.persistence;

import com.jefflife.gameserver.map.adapter.out.persistence.entity.AreaEntity;
import com.jefflife.gameserver.map.application.port.out.SaveAreaPort;
import com.jefflife.gameserver.map.application.domain.model.Area;
import org.springframework.stereotype.Component;

@Component
public class ManageAreaAdapter implements SaveAreaPort {
    private final AreaRepository areaRepository;

    public ManageAreaAdapter(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public Area save(Area area) {
        AreaEntity areaEntity = areaRepository.save(new AreaEntity(area.getName(), area.getType()));
        return Area.builder()
                .id(areaEntity.getId())
                .name(areaEntity.getName())
                .type(areaEntity.getType())
                .build();
    }
}
