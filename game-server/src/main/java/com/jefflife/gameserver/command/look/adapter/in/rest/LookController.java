package com.jefflife.gameserver.command.look.adapter.in.rest;

import com.jefflife.common.model.CommandDataCommonModel;
import com.jefflife.common.model.VisibleObject;
import com.jefflife.gameserver.command.look.adapter.in.rest.response.LookResult;
import com.jefflife.gameserver.command.look.application.domain.LookCommandDataRequest;
import com.jefflife.gameserver.command.look.application.domain.LookCommandDataRequestValidator;
import com.jefflife.gameserver.command.look.application.port.in.LookQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/look")
public class LookController {

    private final LookQuery lookQuery;

    public LookController(LookQuery lookQuery) {
        this.lookQuery = lookQuery;
    }

    @GetMapping
    public ResponseEntity<LookResult> look(@RequestParam("playerId") long playerId, CommandDataCommonModel commandData) {
        VisibleObject visibleObject = lookQuery.look(playerId, new LookCommandDataRequest(commandData, LookCommandDataRequestValidator.getInstance()));
        return ResponseEntity.ok(LookResult.of(visibleObject));
    }
}
