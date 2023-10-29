package com.jefflife.gameserver.player.persistence;

import com.jefflife.gameserver.player.adapter.out.persistence.LoadPlayerAdapter;
import com.jefflife.gameserver.player.adapter.out.persistence.PlayerRepository;
import com.jefflife.gameserver.player.adapter.out.persistence.entity.PlayerEntity;
import com.jefflife.gameserver.player.applicatoin.domain.model.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(LoadPlayerAdapter.class)
public class LoadPlayerAdapterTest {
    @Autowired
    private LoadPlayerAdapter queryPlayerAdapter;

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
