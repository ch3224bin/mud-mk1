package com.jefflife.gameserver.domain.map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class DoorTest {

  @DisplayName("두개의 출구를 하나의 문으로 연결한다")
  @Test
  void testLink() {
    // given
    Room westRoom = Room.builder().id(1L).summary("Test1").description("Test1").build();
    Room eastRoom = Room.builder().id(2L).summary("Test2").description("Test2").build();
    WayOut eastWayOut = westRoom.createWayout(eastRoom, Direction.EAST);
    WayOut westWayOut = eastRoom.createWayout(westRoom, Direction.WEST);

    // when
    Door door = Door.setup(eastWayOut, westWayOut);

    // then
    assertAll(
      () -> assertThat(eastWayOut.getDoor()).isEqualTo(door),
      () -> assertThat(westWayOut.getDoor()).isEqualTo(door),
      () -> assertThat(eastWayOut.getNextRoom()).isEqualTo(eastRoom),
      () -> assertThat(westWayOut.getNextRoom()).isEqualTo(westRoom)
    );
  }
}
