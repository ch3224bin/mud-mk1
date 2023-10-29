package com.jefflife.gameserver.look.adapter.in.web;

import com.jefflife.common.model.CommandDataCommonModel;
import com.jefflife.common.model.VisibleObject;
import com.jefflife.gameserver.look.application.port.in.LookCommandDataRequest;
import com.jefflife.gameserver.look.application.port.in.LookCommandDataRequestValidator;
import com.jefflife.gameserver.look.application.port.in.LookQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/look")
public class LookController {

    private final LookQuery lookQuery;

    public LookController(LookQuery lookQuery) {
        this.lookQuery = lookQuery;
    }

    @GetMapping
    public ResponseEntity<VisibleObject> look(@RequestParam("playerId") long playerId, CommandDataCommonModel commandData) {
        VisibleObject visibleObject = lookQuery.look(playerId, new LookCommandDataRequest(commandData, LookCommandDataRequestValidator.getInstance()));
        return ResponseEntity.ok(visibleObject);
    }
}
