package com.jefflife.gameserver.look.adapter.out;

import com.jefflife.gameserver.map.adapter.out.persistence.LoadRoomAdapter;
import com.jefflife.gameserver.map.application.port.in.LoadRoomQuery;
import com.jefflife.gameserver.map.application.port.in.RoomModel;
import com.jefflife.gameserver.map.application.service.RoomService;
import com.jefflife.gameserver.player.adapter.out.persistence.LoadPlayerAdapter;
import com.jefflife.gameserver.player.applicatoin.service.GetPlayerService;
import com.jefflife.gameserver.shared.VisibleObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import({GetPlayerService.class, RoomService.class, LoadPlayerAdapter.class, LoadRoomAdapter.class, FindRoomAdapter.class})
class FindRoomAdapterTest {

    @Autowired
    private LoadRoomQuery loadRoomQuery;
    @Autowired
    private FindRoomAdapter findRoomAdapter;

    @DisplayName("플레이어 아이디로 방 찾기")
    @Test
    @Sql("classpath:LookSystemTest.sql")
    void findByPlayerId() {
        // given
        RoomModel expectedRoom = loadRoomQuery.getRoom(1L);

        // when
        VisibleObject room = findRoomAdapter.findByPlayerId(1L);

        // then
        assertThat(room).isEqualTo(expectedRoom);
    }
}