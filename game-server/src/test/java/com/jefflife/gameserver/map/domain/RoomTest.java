package com.jefflife.gameserver.map.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RoomTest {

  @DisplayName("출구를 생성한다")
  @ValueSource(strings = {"EAST", "WEST", "NORTH", "SOUTH"})
  @ParameterizedTest
  public void testCreateEastWayOut(Direction direction) {
    // given
    Room room = Room.withOutWayOuts(1L, "Test1", "Test1");
    Room nextRoom = Room.withOutWayOuts(2L, "Test2", "Test2");

    // when
    WayOut wayout = room.createWayOut(nextRoom, direction);

    // then
    assertAll(
            () -> assertThat(wayout.getDirection()).isEqualTo(direction),
            () -> assertThat(wayout.getRoom()).isEqualTo(room),
            () -> assertThat(room.getSortedWayOuts()).containsOnlyOnce(wayout)
    );
  }

  @DisplayName("방과 방을 연결한다")
  @Test
  void testLinkAnotherRoom() {
    // given
    Room room = Room.withOutWayOuts(1L, "Test1", "Test1");
    Room nextRoom = Room.withOutWayOuts(2L, "Test2", "Test2");

    // when
    room.linkAnotherRoom(nextRoom, Direction.EAST, Direction.WEST);

    // then
    assertAll(
            () -> assertThat(room.getWayOutByDirection(Direction.EAST)).isNotEmpty(),
            () -> assertThat(room.getWayOutByDirection(Direction.EAST).get().getNextRoom()).isEqualTo(nextRoom)
    );
  }
}
