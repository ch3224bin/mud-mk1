package com.jefflife.gameserver.look.adapter.in.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jefflife.gameserver.look.application.port.in.LookQuery;
import com.jefflife.gameserver.map.application.domain.model.Room;
import com.jefflife.gameserver.map.application.port.in.RoomModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.UnsupportedEncodingException;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
        RoomModel roomModel = new RoomModel(Room.of(1L, "test", "test", Collections.emptyList()));
        given(lookQuery.look(eq(1L), any())).willReturn(roomModel);

        // when
        MvcResult mvcResult = mockMvc.perform(
                        get("/look")
                                .queryParam("playerId", "1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .queryParam("target", "")
                                .queryParam("payload", "")
                                .queryParam("adverb", "")
                                .queryParam("action", "봐")
                )
                .andExpect(status().isOk())
                .andReturn();

        // then
        JsonNode rootNode = getJsonNode(mvcResult);
        assertAll(
                () -> assertThat(rootNode.get("id").asLong()).isEqualTo(roomModel.getId()),
                () -> assertThat(rootNode.get("summary").asText()).isEqualTo(roomModel.getSummary()),
                () -> assertThat(rootNode.get("description").asText()).isEqualTo(roomModel.getDescription())
        );
    }

    private static JsonNode getJsonNode(MvcResult mvcResult) throws JsonProcessingException, UnsupportedEncodingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readTree(mvcResult.getResponse().getContentAsString());
    }
}