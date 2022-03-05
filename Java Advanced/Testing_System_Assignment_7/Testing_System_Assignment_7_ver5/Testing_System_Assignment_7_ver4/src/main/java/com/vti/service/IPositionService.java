package com.vti.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.entity.Position;

public interface IPositionService {

	public Page<Position> getAllPositions(Pageable pagable);
	
	public Position findByPositionName(String name);
	
	public Position getPositionByID(Integer id);

//	public Position getPositionByID(Integer id);
//
//	public Position getPositionByName(String name);
//
	public void createPosition(Position position);
//
	public void updatePosition(Position position);
//
	public void deletePosition(int id);
//
	public boolean isPositionExistsByID(int id);
//
//	public boolean isPositionExistsByName(String name);

}
