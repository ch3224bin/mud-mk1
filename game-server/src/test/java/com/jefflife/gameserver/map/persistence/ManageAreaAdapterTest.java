package com.jefflife.gameserver.map.persistence;

import com.jefflife.gameserver.map.adapter.out.persistence.AreaRepository;
import com.jefflife.gameserver.map.adapter.out.persistence.ManageAreaAdapter;
import com.jefflife.gameserver.map.adapter.out.persistence.entity.AreaEntity;
import com.jefflife.gameserver.map.domain.Area;
import com.jefflife.gameserver.map.domain.AreaType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DataJpaTest
@Import(ManageAreaAdapter.class)
public class ManageAreaAdapterTest {
    @Autowired
    private ManageAreaAdapter manageAreaAdapter;
    @Autowired
    private AreaRepository areaRepository;

    @DisplayName("Area를 저장한다")
    @Test
    void testSave() {
        // given
        Area area = Area.builder()
                .name("박달동")
                .type(AreaType.OPEN_MAP)
                .build();

        // when
        manageAreaAdapter.save(area);

        // then
        AreaEntity areaEntity = areaRepository.findAll().get(0);
        assertAll(
                () -> assertThat(areaRepository.count()).isEqualTo(1),
                () -> assertThat(areaEntity.getName()).isEqualTo("박달동"),
                () -> assertThat(areaEntity.getType()).isEqualTo(AreaType.OPEN_MAP)
        );
    }
}
