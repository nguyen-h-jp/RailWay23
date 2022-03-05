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
import com.vti.entity.DetailDepartment;
import com.vti.service.IDepartmentService;
import com.vti.service.IDetailDepartmentService;

@RestController
@RequestMapping(value = "api/v1/detailDepartments")
public class DetailDepartmentController {

	@Autowired
	private IDetailDepartmentService service;

	@GetMapping()
	public Page<DetailDepartment> getAllDetailDepartments(Pageable pagable) {
		return service.getAllDetailDepartments(pagable);
	}
//	
//	@GetMapping(value = "/")
//	public DetailDepartment findByDetailDepartmentName(@RequestParam(name = "name") String name) {
//		return service.findByDetailDepartmentName(name);
//	}
	
	@GetMapping(value = "/{id}")
	public DetailDepartment getDetailDepartmentByID(@PathVariable(name = "id") Integer id) {
		return service.getDetailDepartmentByID(id);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteDetailDepartment(@PathVariable(name = "id") int id) {
		service.deleteDetailDepartment(id);
	}
	
	@PutMapping(value = "/{id}")
	public void updateDetailDepartment(@PathVariable(name = "id") int id, @RequestBody DetailDepartment detailDepartment) {
		detailDepartment.setDepartmentID(id);
		service.updateDetailDepartment(detailDepartment);
	}
	
	@PostMapping()
	public void createDetailDepartment(@RequestBody DetailDepartment detailDepartment) {
		service.createDetailDepartment(detailDepartment);
	}
	

}

