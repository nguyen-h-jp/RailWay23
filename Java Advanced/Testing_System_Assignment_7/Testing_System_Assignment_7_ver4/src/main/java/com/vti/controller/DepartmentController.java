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

import com.vti.entity.Department;
import com.vti.service.IDepartmentService;

@RestController
@RequestMapping(value = "api/v1/departments")
public class DepartmentController {

	@Autowired
	private IDepartmentService service;

	@GetMapping()
	public Page<Department> getAllDepartments(Pageable pagable) {
		return service.getAllDepartments(pagable);
	}
	
	@GetMapping(value = "/")
	public Department findByDepartmentName(@RequestParam(name = "name") String name) {
		return service.findByDepartmentName(name);
	}
	
	@GetMapping(value = "/{id}")
	public Department getDepartmentByID(@PathVariable(name = "id") Integer id) {
		return service.getDepartmentByID(id);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteDepartment(@PathVariable(name = "id") int id) {
		service.deleteDepartment(id);
	}
	
	@PutMapping(value = "/{id}")
	public void updateDepartment(@PathVariable(name = "id") int id, @RequestBody Department department) {
		department.setDepartmentID(id);
		service.updateDepartment(department);
	}
	
	@PostMapping()
	public void createDepartment(@RequestBody Department department) {
		service.createDepartment(department);
	}
	

}

