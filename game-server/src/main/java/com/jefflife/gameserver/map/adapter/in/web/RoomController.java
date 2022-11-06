package com.jefflife.gameserver.map.adapter.in.web;

import com.jefflife.gameserver.map.application.port.in.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 방 관리 API
 *
 * @author ChangHo Vin
 */
@RestController
@RequestMapping("/rooms")
public class RoomController {

	private final RoomModelAssembler assembler;
	private final LoadRoomQuery loadRoomQuery;
	private final ManageRoomUseCase manageRoomUseCase;

	public RoomController(RoomModelAssembler assembler, LoadRoomQuery loadRoomQuery, ManageRoomUseCase manageRoomUseCase) {
		this.assembler = assembler;
		this.loadRoomQuery = loadRoomQuery;
		this.manageRoomUseCase = manageRoomUseCase;
	}

	@GetMapping
	public ResponseEntity<PagedModel<EntityModel<RoomModel>>> paging(Pageable pageable, PagedResourcesAssembler<RoomModel> pagedResourcesAssembler) {
		Page<RoomModel> pagedRooms = loadRoomQuery.getPagedRooms(pageable);
		PagedModel<EntityModel<RoomModel>> body = pagedResourcesAssembler.toModel(pagedRooms);
		return ResponseEntity.ok(body);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<RoomModel>> one(@PathVariable("id") long id) {
		return ResponseEntity.ok(assembler.toModel(loadRoomQuery.getRoom(id)));
	}

	@PostMapping
	public ResponseEntity<EntityModel<RoomModel>> createRoom(@RequestBody CreateRoomCommand req) {
		EntityModel<RoomModel> res = assembler.toModel(manageRoomUseCase.createRoom(req));

		return ResponseEntity
	    .created(res.getRequiredLink(IanaLinkRelations.SELF).toUri())
	    .body(res);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<EntityModel<RoomModel>> updateRoom(@PathVariable("id") long id, @RequestBody UpdateRoomCommand req) {
		EntityModel<RoomModel> res = assembler.toModel(manageRoomUseCase.updateRoom(id, req));

		return ResponseEntity.noContent()
				.location(res.getRequiredLink(IanaLinkRelations.SELF).toUri())
				.build();
	}

	@PostMapping("/{id}/links")
	public ResponseEntity<LinkedRoomResponse> linkAnotherRoom(@PathVariable("id") long id,
											 @RequestParam("anotherRoomId") long anotherRoomId,
											 @RequestParam("from") String from,
											 @RequestParam("to") String to) {
		LinkedRoomResponse linkedRoomResponse = manageRoomUseCase.linkAnotherRoom(id, anotherRoomId, from, to);
		return ResponseEntity.ok(linkedRoomResponse);
	}
}
