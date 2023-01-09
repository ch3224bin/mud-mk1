package com.jefflife.gameserver.player.adapter.in.web;

import com.jefflife.gameserver.player.applicatoin.port.in.PlayerQuery;
import com.jefflife.gameserver.player.domain.Player;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerQuery playerQuery;

    public PlayerController(PlayerQuery playerQuery) {
        this.playerQuery = playerQuery;
    }

    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable("id") long id) {
        return playerQuery.getPlayer(id);
    }
}
