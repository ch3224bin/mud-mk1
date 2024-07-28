package com.jefflife.gameserver.player.adapter.in.web.model;

import com.jefflife.gameserver.player.applicatoin.port.in.PlayerModel;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

@Getter
public class MovePlayerResponse extends RepresentationModel<MovePlayerResponse> {
    private final Long playerId;
    private final Long roomId;

    public MovePlayerResponse(PlayerModel playerModel) {
        this.playerId = playerModel.getId();
        this.roomId = playerModel.getRoomId();
    }
}
