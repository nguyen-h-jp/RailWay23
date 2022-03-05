package com.vti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vti.entity.Position;
import com.vti.repository.IPositionRepository;

@Service
public class PositionService implements IPositionService {

	@Autowired
	private IPositionRepository repository;

	public Page<Position> getAllPositions(Pageable pagable) {
		// TODO Auto-generated method stub
		return repository.findAll(pagable);
	}
	
	public Position findByPositionName(String name) {
		return repository.findByPositionName(name);
	}

	public Position getPositionByID(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}
//	
//	public Position getPositionByName(String name) {
//		// TODO Auto-generated method stub
//		return repository.findByPositionName(name);
//	}
//
	public void createPosition(Position position) {
		// TODO Auto-generated method stub
		repository.save(position);
		
	}
//
	public void updatePosition(Position position) {
		// TODO Auto-generated method stub
		repository.save(position);
		
	}
//
	public void deletePosition(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}
//	
	public boolean isPositionExistsByID(int id) {
		// TODO Auto-generated method stub
		return repository.existsById(id);
	}
//
//	public boolean isPositionExistsByName(String name) {
//		// TODO Auto-generated method stub
//		return repository.existsByPositionName(name);
//	}



	

	


}

