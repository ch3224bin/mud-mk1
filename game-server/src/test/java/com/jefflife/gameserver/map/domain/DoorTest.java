package com.jefflife.gameserver.map.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class DoorTest {

  @DisplayName("두개의 출구를 하나의 문으로 연결한다")
  @Test
  void testLink() {
    // given
    Room westRoom = Room.withOutWayOuts(1L, "Test1", "Test1");
    Room eastRoom = Room.withOutWayOuts(2L, "Test2", "Test2");
    WayOut eastWayOut = westRoom.createWayOut(eastRoom, Direction.EAST);
    WayOut westWayOut = eastRoom.createWayOut(westRoom, Direction.WEST);

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
