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

import com.vti.entity.Salary;
import com.vti.service.ISalaryService;

@RestController
@RequestMapping(value = "api/v1/salaries")
public class SalaryController {

	@Autowired
	private ISalaryService service;

	@GetMapping()
	public Page<Salary> getAllSalarys(Pageable pagable) {
		return service.getAllSalarys(pagable);
	}
	
	@GetMapping(value = "/")
	public Salary findBySalaryName(@RequestParam(name = "name") String name) {
		return service.findBySalaryName(name);
	}
	
	@GetMapping(value = "/{id}")
	public Salary getSalaryByID(@PathVariable(name = "id") Integer id) {
		return service.getSalaryByID(id);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteSalary(@PathVariable(name = "id") int id) {
		service.deleteSalary(id);
	}
	
	@PutMapping(value = "/{id}")
	public void updateSalary(@PathVariable(name = "id") int id, @RequestBody Salary salary) {
		salary.setSalaryID(id);
		service.updateSalary(salary);
	}
	
	@PostMapping()
	public void createSalary(@RequestBody Salary salary) {
		service.createSalary(salary);
	}
	

}

