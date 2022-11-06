package com.jefflife.gameserver.map.web;

import com.jefflife.gameserver.map.adapter.in.web.RoomController;
import com.jefflife.gameserver.map.adapter.in.web.RoomModelAssembler;
import com.jefflife.gameserver.map.application.port.in.LoadRoomQuery;
import com.jefflife.gameserver.map.application.port.in.ManageRoomUseCase;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = {RoomController.class})
public class RoomControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LoadRoomQuery loadRoomQuery;

    @MockBean
    private RoomModelAssembler roomModelAssembler;

    @MockBean
    private ManageRoomUseCase manageRoomUseCase;

    @DisplayName("Room 단건 조회")
    @Test
    void testGetOne() throws Exception {
        // given

        // when
        mockMvc.perform(
            get("/rooms/{id}", 1L)
        )
        .andExpect(status().isOk());

        // then
        then(loadRoomQuery).should()
                .getRoom(eq(1L));
    }

    @Test
    void testCreateRoomWithException() throws Exception {
        // given

        // when
        mockMvc.perform(
                        post("/rooms")
                                .queryParam("summary", "")
                                .queryParam("description", "test")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.summary", Is.is("Summary is mandatory")));
    }
}
