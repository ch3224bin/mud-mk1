package com.jefflife.gameserver.look.adapter.in.web;

import com.jefflife.gameserver.look.application.port.in.LookAtRoomUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LookController {

    private final LookAtRoomUseCase lookAtRoomUseCase;

    public LookController(LookAtRoomUseCase lookAtRoomUseCase) {
        this.lookAtRoomUseCase = lookAtRoomUseCase;
    }

    @GetMapping("/look")
    public ResponseEntity<Void> justSee(@RequestParam String playerId) {
        lookAtRoomUseCase.lookAtMyRoom(playerId);
        return ResponseEntity.ok().build();
    }
}
