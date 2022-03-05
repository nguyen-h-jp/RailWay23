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

	@Override
	public Page<Department> getAllDepartments(Pageable pagable) {
		// TODO Auto-generated method stub
		return repository.findAll(pagable);
	}

	@Override
	public Department getDepartmentByID(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public Department getDepartmentByName(String name) {
		// TODO Auto-generated method stub
		return repository.findByDepartmentName(name);
	}

	@Override
	public void createDepartment(Department department) {
		// TODO Auto-generated method stub
		repository.createDepartment(department);
		
	}

	@Override
	public void updateDepartment(Department department) {
		// TODO Auto-generated method stub
		repository.updateDepartment(department);
		
	}

	@Override
	public void deleteDepartment(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

	@Override
	public boolean isDepartmentExistsByID(int id) {
		// TODO Auto-generated method stub
		return repository.isDepartmentExistsByID(id);
	}

	@Override
	public boolean isDepartmentExistsByName(String name) {
		// TODO Auto-generated method stub
		return repository.isDepartmentExistsByName(name);
	}

	@Override
	public void updateDepartment(int id, String newName) {
		// TODO Auto-generated method stub
		repository.updateDepartment(id, newName);
		
	}

	

	


}
