package com.jefflife.gameserver.map.application.port.in;

import com.jefflife.gameserver.map.domain.Room;
import com.jefflife.gameserver.shared.SelfValidating;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateRoomCommand extends SelfValidating<CreateRoomCommand> {
	@NotBlank(message = "Summary is mandatory")
	private String summary;
	@NotBlank(message = "Description is mandatory")
	private String description;

	public CreateRoomCommand(String summary, String description) {
		this.summary = summary;
		this.description = description;
		this.validateSelf();
	}

	public Room toDomain() {
		return Room.withOutId(summary, description);
	}
}
