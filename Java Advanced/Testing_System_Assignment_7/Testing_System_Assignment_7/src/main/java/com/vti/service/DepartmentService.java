package com.vti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vti.entity.Department;
import com.vti.repository.IDepartmentRepository;

@Service
public class DepartmentService implements IDepartmentService {

	@Autowired
	private IDepartmentRepository repository;

	public Page<Department> getAllDepartments(Pageable pagable) {
		// TODO Auto-generated method stub
		return repository.findAll(pagable);
	}
	
	public Department findByDepartmentName(String name) {
		return repository.findByDepartmentName(name);
	}

//	public Department getDepartmentByID(Integer id) {
//		// TODO Auto-generated method stub
//		return repository.findById(id).get();
//	}
//	
//	public Department getDepartmentByName(String name) {
//		// TODO Auto-generated method stub
//		return repository.findByDepartmentName(name);
//	}
//
	public void createDepartment(Department department) {
		// TODO Auto-generated method stub
		repository.save(department);
		
	}
//
	public void updateDepartment(Department department) {
		// TODO Auto-generated method stub
		repository.save(department);
		
	}
//
	public void deleteDepartment(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}
//	
	public boolean isDepartmentExistsByID(int id) {
		// TODO Auto-generated method stub
		return repository.existsById(id);
	}
//
//	public boolean isDepartmentExistsByName(String name) {
//		// TODO Auto-generated method stub
//		return repository.existsByDepartmentName(name);
//	}


	

	


}

