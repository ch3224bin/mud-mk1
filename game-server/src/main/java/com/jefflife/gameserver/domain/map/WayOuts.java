package com.jefflife.gameserver.domain.map;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class WayOuts {
  @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<WayOut> wayOuts = new ArrayList<>();

  public List<WayOut> getSortedWayOuts() {
    return wayOuts.stream()
      .sorted()
      .collect(Collectors.toList());
  }

  public String getExitString() {
    String exitString = wayOuts.stream()
      .filter(WayOut::isShow)
      .map(WayOut::toString)
      .collect(Collectors.joining(" "));
    return Optional.ofNullable(exitString.strip())
            .orElse("없음");
  }

  public Optional<WayOut> getWayOutByDirection(Direction direction) {
    return wayOuts.stream()
      .filter(wayOut -> wayOut.getDirection() == direction)
      .findFirst();
  }

  public void add(WayOut wayOut) {
    if (wayOut == null) {
      throw new NullPointerException("argument is null");
    }

    wayOuts.add(wayOut);
  }
}
