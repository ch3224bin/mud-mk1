package com.jefflife.gameserver.player.adapter.in.web;

import com.jefflife.gameserver.player.adapter.in.web.model.MovePlayerRequest;
import com.jefflife.gameserver.player.adapter.in.web.model.MovePlayerResponse;
import com.jefflife.gameserver.player.applicatoin.port.in.LoadPlayerQuery;
import com.jefflife.gameserver.player.applicatoin.port.in.MovePlayerCommand;
import com.jefflife.gameserver.player.applicatoin.port.in.PlayerModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/v1/players")
public class PlayerMoveController {
    private final LoadPlayerQuery loadPlayerQuery;
    private final MovePlayerCommand movePlayerCommand;

    public PlayerMoveController(LoadPlayerQuery loadPlayerQuery, MovePlayerCommand movePlayerCommand) {
        this.loadPlayerQuery = loadPlayerQuery;
        this.movePlayerCommand = movePlayerCommand;
    }

    @PatchMapping("/{id}/move")
    public ResponseEntity<MovePlayerResponse> movePlayer(@PathVariable("id") long id, @RequestBody MovePlayerRequest request) {
        movePlayerCommand.movePlayer(id, request.getDirection());
        return getMovePlayerResponseResponseEntity(id, request);
    }

    private ResponseEntity<MovePlayerResponse> getMovePlayerResponseResponseEntity(long id, MovePlayerRequest request) {
        PlayerModel player = loadPlayerQuery.getPlayer(id);
        MovePlayerResponse response = new MovePlayerResponse(player);
        response.add(linkTo(methodOn(PlayerMoveController.class).movePlayer(id, request)).withSelfRel(),
                linkTo(methodOn(PlayerController.class).getPlayer(id)).withRel("get-player"));
        return ResponseEntity.ok(response);
    }
}
