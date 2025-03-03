package com.jefflife.gameserver.look.adapter.in.web;

import com.jefflife.common.model.VisibleObject;
import com.jefflife.gameserver.command.adapter.look.in.rest.response.LookResult;
import com.jefflife.gameserver.map.application.domain.model.Room;
import com.jefflife.gameserver.map.application.port.in.RoomModel;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class LookResultTest {
    @Test
    void name() {
        // given
        VisibleObject visibleObject = new RoomModel(Room.of(1L, "", "", Collections.emptyList(), 0L));

        // when
        LookResult lookResult = LookResult.of(visibleObject);

        // then
        assertThat(lookResult.className()).isEqualTo("RoomModel");
        assertThat(lookResult.payload()).isEqualTo(visibleObject);
    }
}