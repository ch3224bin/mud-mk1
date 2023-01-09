package com.jefflife.gameserver.player.web;

import com.jefflife.gameserver.player.adapter.in.web.PlayerController;
import com.jefflife.gameserver.player.applicatoin.port.in.PlayerQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {PlayerController.class})
public class PlayerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PlayerQuery playerQuery;

    @Test
    void testGetPlayer() throws Exception {
        // given

        // when
        mockMvc.perform(
            get("/players/{id}", 1L)
        )
        .andExpect(status().isOk());

        // then
        then(playerQuery).should()
                .getPlayer(eq(1L));
    }
}
