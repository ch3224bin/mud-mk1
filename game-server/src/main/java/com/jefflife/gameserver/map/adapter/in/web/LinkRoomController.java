package com.jefflife.gameserver.map.adapter.in.web;

import com.jefflife.gameserver.map.application.port.in.LinkRoomCommand;
import com.jefflife.gameserver.map.application.port.in.LinkRoomUseCase;
import com.jefflife.gameserver.map.application.port.in.LinkedRoomResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rooms")
public class LinkRoomController {
    private final LinkRoomUseCase linkRoomUseCase;

    public LinkRoomController(LinkRoomUseCase linkRoomUseCase) {
        this.linkRoomUseCase = linkRoomUseCase;
    }

    @PostMapping("/{id}/links")
    public ResponseEntity<LinkedRoomResponse> linkAnotherRoom(@PathVariable("id") long id,
                                                              @RequestParam("anotherRoomId") long anotherRoomId,
                                                              @RequestParam("from") String from,
                                                              @RequestParam("to") String to) {
        LinkedRoomResponse linkedRoomResponse = linkRoomUseCase.linkAnotherRoom(
                new LinkRoomCommand(id, anotherRoomId, from, to));
        return ResponseEntity.ok(linkedRoomResponse);
    }
}
