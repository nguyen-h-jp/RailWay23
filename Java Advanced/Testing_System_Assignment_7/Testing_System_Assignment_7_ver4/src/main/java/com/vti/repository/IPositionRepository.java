package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.entity.Position;

public interface IPositionRepository extends JpaRepository<Position, Integer> {
	
	public Position findByPositionName(String name);

//	
//	public void createPosition(Position position);
//	
//	public void updatePosition(int id, String newName);
//
//	public void updatePosition(Position position);
//
//	public void deleteByPositionID(int id);
//	
//	public boolean existsByPositionName(String name);
//
//	public boolean isPositionExistsByID(int id);

}
