package com.vti.frontend;

import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Position;
import com.vti.repository.PositionRepository;

public class PositionProgram {
	public static void main(String[] args) {
		
		PositionRepository positionRepository = new PositionRepository();
		
		// lay danh sach cac position
		List<Position> list = new ArrayList<Position>();
		list = positionRepository.getAllPositions();
		System.out.println(list);
		
//		Position position = new Position();
//		position.setPositionName(Position.PositionName.PM);
//		
//		positionRepository.createPosition(position);
		
	}
}
