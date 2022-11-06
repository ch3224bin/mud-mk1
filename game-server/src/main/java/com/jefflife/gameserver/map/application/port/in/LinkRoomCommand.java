package com.jefflife.gameserver.map.application.port.in;

import com.jefflife.gameserver.map.domain.Direction;
import com.jefflife.gameserver.shared.SelfValidating;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class LinkRoomCommand extends SelfValidating<LinkRoomCommand> {
    @NotNull
    private final Long sourceRoomId;
    @NotNull
    private final Long destinationRoomId;
    @NotNull
    private final Direction sourceDir;
    @NotNull
    private final Direction destinationDir;

    public LinkRoomCommand(Long sourceRoomId, Long destinationRoomId, String sourceDir, String destinationDir) {
        this.sourceRoomId = sourceRoomId;
        this.destinationRoomId = destinationRoomId;
        this.sourceDir = Direction.valueOf(sourceDir);
        this.destinationDir = Direction.valueOf(destinationDir);
        this.validateSelf();
    }
}
