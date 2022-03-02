package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.entity.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {
	
	public Department findByDepartmentName(String name);

//	
//	public void createDepartment(Department department);
//	
//	public void updateDepartment(int id, String newName);
//
//	public void updateDepartment(Department department);
//
//	public void deleteByDepartmentID(int id);
//	
//	public boolean existsByDepartmentName(String name);
//
//	public boolean isDepartmentExistsByID(int id);

}
