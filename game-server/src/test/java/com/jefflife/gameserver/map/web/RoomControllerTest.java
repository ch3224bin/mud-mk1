package com.jefflife.gameserver.map.web;

import com.jefflife.gameserver.map.adapter.in.web.RoomController;
import com.jefflife.gameserver.map.adapter.in.web.RoomModelAssembler;
import com.jefflife.gameserver.map.application.port.in.LoadRoomQuery;
import com.jefflife.gameserver.map.application.port.in.ManageRoomUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
}
