package com.vti.frontend;

import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Position;
import com.vti.repository.PositionRepository;

public class PositionProgram {
	public static void main(String[] args) {

		PositionRepository positionRepository = new PositionRepository();
		
		

		List<Position> list = new ArrayList<Position>();
		list = positionRepository.getAllPositions();
		for (Position position : list) {
			// danh sach manager
			System.out.println(position);
		}
	}
}
