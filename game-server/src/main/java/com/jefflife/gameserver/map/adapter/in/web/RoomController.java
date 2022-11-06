package com.jefflife.gameserver.map.adapter.in.web;

import com.jefflife.gameserver.map.application.port.in.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

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
	public ResponseEntity<EntityModel<RoomModel>> createRoom(@RequestParam("summary") String summary,
															 @RequestParam("description") String description) {
		EntityModel<RoomModel> res = assembler.toModel(manageRoomUseCase.createRoom(new CreateRoomCommand(summary, description)));

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

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ConstraintViolationException.class)
	public Map<String, String> handleValidationExceptions(ConstraintViolationException ex) {
		Map<String, String> errors = new HashMap<>();
		for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
			errors.put(violation.getPropertyPath().toString(), violation.getMessage());
		}
		return errors;
	}
}
