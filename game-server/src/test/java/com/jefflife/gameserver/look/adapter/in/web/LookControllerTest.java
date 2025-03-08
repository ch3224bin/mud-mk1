package com.jefflife.gameserver.look.adapter.in.web;

import com.jefflife.gameserver.command.look.adapter.in.rest.LookController;
import com.jefflife.gameserver.command.look.application.port.in.LookQuery;
import com.jefflife.gameserver.map.application.domain.model.Room;
import com.jefflife.gameserver.map.application.port.in.RoomModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {LookController.class})
class LookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LookQuery lookQuery;

    @DisplayName("\"봐\" 를 실행하면 플레이어의 현재 방 정보를 반환한다.")
    @Test
    void testJustSee() throws Exception {
        // given
        RoomModel roomModel = new RoomModel(Room.of(1L, "test", "test", Collections.emptyList(), 0L));
        given(lookQuery.look(eq(1L), any())).willReturn(roomModel);

        // when then
        mockMvc.perform(
                        get("/look")
                                .queryParam("playerId", "1")
                                .queryParam("target", "")
                                .queryParam("payload", "")
                                .queryParam("adverb", "")
                                .queryParam("action", "봐")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.className").value("RoomModel"))
                .andExpect(jsonPath("$.payload.id").value(roomModel.getId()))
                .andExpect(jsonPath("$.payload.summary").value(roomModel.getSummary()))
                .andExpect(jsonPath("$.payload.description").value(roomModel.getDescription()))
                .andReturn();
    }
}