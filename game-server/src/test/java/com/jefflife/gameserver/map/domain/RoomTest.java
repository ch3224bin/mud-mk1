package com.jefflife.gameserver.map.domain;

import com.jefflife.gameserver.map.domain.Direction;
import com.jefflife.gameserver.map.domain.Room;
import com.jefflife.gameserver.map.domain.WayOut;
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
    Room room = Room.builder().id(1L).summary("Test").description("Test").build();
    Room nextRoom = Room.builder().id(2L).summary("Test").description("Test").build();

    // when
    WayOut wayout = room.createWayOut(nextRoom, direction);

    // then
    assertAll(
            () -> assertThat(wayout.getDirection()).isEqualTo(direction),
            () -> assertThat(wayout.getRoom()).isEqualTo(room),
            () -> assertThat(room.getWayOuts().getSortedWayOuts()).containsOnlyOnce(wayout)
    );
  }

  @DisplayName("방과 방을 연결한다")
  @Test
  void testLinkAnotherRoom() {
    // given
    Room room = Room.builder().id(1L).summary("Test").description("Test").build();
    Room nextRoom = Room.builder().id(2L).summary("Test").description("Test").build();

    // when
    room.linkAnotherRoom(nextRoom, Direction.EAST, Direction.WEST);

    // then
    assertAll(
            () -> assertThat(room.getWayOutByDirection(Direction.EAST)).isNotEmpty(),
            () -> assertThat(room.getWayOutByDirection(Direction.EAST).get().getNextRoom()).isEqualTo(nextRoom)
    );
  }
}
