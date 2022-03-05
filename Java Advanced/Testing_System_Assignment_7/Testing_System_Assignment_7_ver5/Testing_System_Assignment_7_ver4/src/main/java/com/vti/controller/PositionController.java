package com.vti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.Position;
import com.vti.service.IPositionService;

@RestController
@RequestMapping(value = "api/v1/positions")
public class PositionController {

	@Autowired
	private IPositionService service;

	@GetMapping()
	public Page<Position> getAllPositions(Pageable pagable) {
		return service.getAllPositions(pagable);
	}
	
	@GetMapping(value = "/")
	public Position findByPositionName(@RequestParam(name = "name") String name) {
		return service.findByPositionName(name);
	}
	
	@GetMapping(value = "/{id}")
	public Position getPositionByID(@PathVariable(name = "id") Integer id) {
		return service.getPositionByID(id);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deletePosition(@PathVariable(name = "id") int id) {
		service.deletePosition(id);
	}
	
	@PutMapping(value = "/{id}")
	public void updatePosition(@PathVariable(name = "id") int id, @RequestBody Position position) {
		position.setPositionID(id);
		service.updatePosition(position);
	}
	
	@PostMapping()
	public void createPosition(@RequestBody Position position) {
		service.createPosition(position);
	}
	

}

