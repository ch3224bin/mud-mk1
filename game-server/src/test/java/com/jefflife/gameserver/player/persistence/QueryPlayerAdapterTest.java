package com.jefflife.gameserver.player.persistence;

import com.jefflife.gameserver.player.adapter.out.persistence.QueryPlayerAdapter;
import com.jefflife.gameserver.player.adapter.out.persistence.PlayerRepository;
import com.jefflife.gameserver.player.adapter.out.persistence.entity.PlayerEntity;
import com.jefflife.gameserver.player.domain.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(QueryPlayerAdapter.class)
public class QueryPlayerAdapterTest {
    @Autowired
    private QueryPlayerAdapter queryPlayerAdapter;

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    void testFindById() {
        // given
        PlayerEntity jeff = new PlayerEntity(1L, 1L, "jeff");
        playerRepository.save(jeff);

        // when
        Player player = queryPlayerAdapter.findById(1L);

        // then
        assertThat(player.getId()).isEqualTo(jeff.getId());
        assertThat(player.getRoomId()).isEqualTo(jeff.getRoomId());
        assertThat(player.getName()).isEqualTo(jeff.getName());
    }
}
