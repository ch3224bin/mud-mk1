package com.jefflife.gameserver.map.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "room")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @AllArgsConstructor @Builder @EqualsAndHashCode(of = "id")
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "summary", nullable = false)
	private String summary;

	@Column(name = "description", nullable = false)
	private String description;

	@Embedded
	@Builder.Default
	private WayOuts wayOuts = new WayOuts();

	public List<WayOut> getSortedWayOuts() {
		return wayOuts.getSortedWayOuts();
	}

	public String getExitString() {
		return wayOuts.getExitString();
	}

	public Optional<WayOut> getWayOutByDirection(Direction direction) {
		return wayOuts.getWayOutByDirection(direction);
	}

	public WayOut createWayOut(Room nextRoom, Direction direction) {
		WayOut wayout = WayOut.builder()
				.direction(direction)
				.room(this)
				.nextRoom(nextRoom)
				.build();
		wayOuts.add(wayout);
		return wayout;
	}

	public void linkAnotherRoom(Room anotherRoom, Direction myWay, Direction yourWay) {
		this.createWayOut(anotherRoom, myWay)
			.linkAnotherRoom(anotherRoom, yourWay);
	}

	public void update(String summary, String description) {
		this.summary = summary;
		this.description = description;
	}
}
