package com.jefflife.gameserver.map.adapter.in.web;

import com.jefflife.gameserver.map.application.port.in.RoomModel;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class RoomModelAssembler implements RepresentationModelAssembler<RoomModel, EntityModel<RoomModel>> {

	private final PagedResourcesAssembler<RoomModel> pagedResourcesAssembler;

	public RoomModelAssembler(PagedResourcesAssembler<RoomModel> pagedResourcesAssembler) {
		this.pagedResourcesAssembler = pagedResourcesAssembler;
	}

	// todo updateRoom 해결
	@Override
	public EntityModel<RoomModel> toModel(RoomModel room) {
		return EntityModel.of(room,
			      linkTo(methodOn(RoomController.class).one(room.getId())).withSelfRel(),
						linkTo(methodOn(RoomController.class).updateRoom(room.getId(), null)).withRel("update")
		);
	}

	public PagedModel<EntityModel<RoomModel>> toPagedModel(Page<RoomModel> pagedRooms) {
		return pagedResourcesAssembler.toModel(pagedRooms, this);
	}
}
