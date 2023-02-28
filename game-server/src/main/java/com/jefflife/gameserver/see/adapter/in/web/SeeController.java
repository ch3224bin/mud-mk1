package com.jefflife.gameserver.see.adapter.in.web;

import com.jefflife.gameserver.see.application.port.in.JustSeeUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeeController {

    private final JustSeeUseCase justSeeUseCase;

    public SeeController(JustSeeUseCase justSeeUseCase) {
        this.justSeeUseCase = justSeeUseCase;
    }

    @GetMapping("/see")
    public ResponseEntity<Void> justSee(@RequestParam String playerId) {
        justSeeUseCase.justSee(playerId);
        return ResponseEntity.ok().build();
    }
}
