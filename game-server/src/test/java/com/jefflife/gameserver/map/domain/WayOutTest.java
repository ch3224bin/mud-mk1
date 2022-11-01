package com.jefflife.gameserver.map.domain;

import com.jefflife.gameserver.map.domain.Direction;
import com.jefflife.gameserver.map.domain.Door;
import com.jefflife.gameserver.map.domain.Room;
import com.jefflife.gameserver.map.domain.WayOut;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

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

  @DisplayName("출구와 출구를 연결한다")
  @Test
  void testLinkAnotherWayOut() {
    // Given
    Room room2 = Room.builder().id(2L).build();
    WayOut wo1 = WayOut.builder().id(1L).room(Room.builder().id(1L).build()).nextRoom(room2).build();

    // When
    wo1.linkAnotherRoom(room2, Direction.EAST);

    // Then
    WayOut wo2 = room2.getWayOutByDirection(Direction.EAST).get();
    assertAll(
            () -> assertThat(wo1.getDoor()).isNotNull().isEqualTo(wo2.getDoor()),
            () -> assertThat(wo1.getNextRoom()).isNotNull().isEqualTo(wo2.getRoom()),
            () -> assertThat(wo2.getNextRoom()).isNotNull().isEqualTo(wo1.getRoom())
    );
  }
}
