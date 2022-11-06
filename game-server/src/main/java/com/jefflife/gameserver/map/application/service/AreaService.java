package com.jefflife.gameserver.map.application.service;

import com.jefflife.gameserver.map.application.port.in.CreateAreaCommand;
import com.jefflife.gameserver.map.application.port.in.ManageAreaUseCase;
import com.jefflife.gameserver.map.application.port.out.SaveAreaPort;
import org.springframework.stereotype.Service;

@Service
public class AreaService implements ManageAreaUseCase  {
    private final SaveAreaPort saveAreaPort;

    public AreaService(SaveAreaPort saveAreaPort) {
        this.saveAreaPort = saveAreaPort;
    }

    @Override
    public void createArea(CreateAreaCommand createAreaCommand) {
        saveAreaPort.save(createAreaCommand.toDomain());
    }
}
