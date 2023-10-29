package com.jefflife.gameserver.map.application.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WayOutTest {

  @DisplayName("출구에 문을 설치한다")
  @Test
  void testInstallDoor() {
    // given
    WayOut wo = new WayOut();
    Door door = new Door();

    // when
    wo.installDoor(door);

    // then
    assertThat(wo.getDoor()).isEqualTo(door);
  }
}
