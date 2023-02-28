package com.jefflife.gameserver.look.adapter.out;

import com.jefflife.gameserver.map.adapter.out.persistence.QueryRoomAdapter;
import com.jefflife.gameserver.map.domain.Room;
import com.jefflife.gameserver.player.adapter.out.persistence.QueryPlayerAdapter;
import com.jefflife.gameserver.shared.Seeable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import({QueryPlayerAdapter.class, QueryRoomAdapter.class, FindRoomAdapter.class})
class FindRoomAdapterTest {

    @Autowired
    private QueryRoomAdapter queryRoomAdapter;
    @Autowired
    private FindRoomAdapter findRoomAdapter;

    @DisplayName("플레이어 아이디로 방 찾기")
    @Test
    @Sql("classpath:LookSystemTest.sql")
    void findByPlayerId() {
        // given
        Room expectedRoom = queryRoomAdapter.findById(1L);

        // when
        Seeable room = findRoomAdapter.findByPlayerId(1L);

        // then
        assertThat(room).isEqualTo(expectedRoom);
    }
}