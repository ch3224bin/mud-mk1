package com.jefflife.gameserver.map.application.port.in;

import com.jefflife.gameserver.map.domain.Area;
import com.jefflife.gameserver.map.domain.AreaType;
import com.jefflife.gameserver.shared.SelfValidating;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;

@Getter
public class CreateAreaCommand extends SelfValidating<CreateAreaCommand> {
    @NotNull
    private final String name;
    @NotNull
    private final AreaType type;

    public CreateAreaCommand(String name, String type) {
        this.name = name;
        this.type = AreaType.valueOf(type);
        this.validateSelf();
    }

    public Area toDomain() {
        return Area.builder()
                .name(name)
                .type(type)
                .build();
    }
}
