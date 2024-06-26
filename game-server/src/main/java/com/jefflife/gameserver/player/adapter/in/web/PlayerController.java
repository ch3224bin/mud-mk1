package com.jefflife.gameserver.player.adapter.in.web;

import com.jefflife.common.model.PlayerCommonModel;
import com.jefflife.gameserver.player.applicatoin.port.in.LoadPlayerQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/players")
public class PlayerController {
    private final LoadPlayerQuery loadPlayerQuery;

    public PlayerController(LoadPlayerQuery loadPlayerQuery) {
        this.loadPlayerQuery = loadPlayerQuery;
    }

    @GetMapping("/{id}")
    public PlayerCommonModel getPlayer(@PathVariable("id") long id) {
        return loadPlayerQuery.getPlayer(id);
    }
}
