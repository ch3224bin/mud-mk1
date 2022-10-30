package com.jefflife.gameserver.domain.map;

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
	private WayOuts wayouts = new WayOuts();

	public List<WayOut> getSortedWayouts() {
		return wayouts.getSortedWayOuts();
	}

	public String getExitString() {
		return wayouts.getExitString();
	}

	public Optional<WayOut> getWayoutByDirection(Direction direction) {
		return wayouts.getWayoutByDirection(direction);
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public WayOut createWayout(Room nextRoom, Direction direction) {
		WayOut wayout = WayOut.builder()
				.direction(direction)
				.room(this)
				.nextRoom(nextRoom)
				.build();
		wayouts.add(wayout);
		return wayout;
	}

	public void linkAnotherRoom(Room anotherRoom, Direction myWay, Direction yourWay) {
		this.createWayout(anotherRoom, myWay)
			.linkAnotherRoom(anotherRoom, yourWay);
	}
}
