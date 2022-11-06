package com.jefflife.gameserver.map.adapter.in.web;

import com.jefflife.gameserver.map.application.port.in.CreateAreaCommand;
import com.jefflife.gameserver.map.application.port.in.ManageAreaUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/areas")
public class AreaController {

    private final ManageAreaUseCase manageAreaUseCase;

    public AreaController(ManageAreaUseCase manageAreaUseCase) {
        this.manageAreaUseCase = manageAreaUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> createRoom(@RequestParam("name") String name,
                                           @RequestParam("type") String type) {
        manageAreaUseCase.createArea(new CreateAreaCommand(name, type));

        // todo Area EntityModel 만들기 귀찮아서 아래와 같이 처리함..
        return ResponseEntity.noContent()
                .build();
    }
}
