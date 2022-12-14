package com.jefflife.gameserver.map.adapter.in.web;

import com.jefflife.gameserver.map.application.port.in.RoomModel;
import com.jefflife.gameserver.map.application.port.in.UpdateRoomCommand;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class RoomModelAssembler implements RepresentationModelAssembler<RoomModel, EntityModel<RoomModel>> {

	@Override
	public EntityModel<RoomModel> toModel(RoomModel room) {
		return EntityModel.of(room,
			      linkTo(methodOn(RoomController.class).one(room.getId())).withSelfRel(),
						linkTo(methodOn(RoomController.class).updateRoom(room.getId(), new UpdateRoomCommand(room.getSummary(), room.getDescription()))).withRel("update")
		);
	}
}
