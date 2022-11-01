package com.jefflife.gameserver.map.domain;

import com.jefflife.gameserver.map.domain.Direction;
import com.jefflife.gameserver.map.domain.Door;
import com.jefflife.gameserver.map.domain.Room;
import com.jefflife.gameserver.map.domain.WayOut;
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
