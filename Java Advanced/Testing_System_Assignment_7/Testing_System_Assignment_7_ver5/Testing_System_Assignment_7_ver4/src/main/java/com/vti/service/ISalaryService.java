package com.vti.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.entity.Salary;

public interface ISalaryService {

	public Page<Salary> getAllSalarys(Pageable pagable);
	
	public Salary findBySalaryName(String name);
	
	public Salary getSalaryByID(Integer id);

//	public Salary getSalaryByID(Integer id);
//
//	public Salary getSalaryByName(String name);
//
	public void createSalary(Salary salary);
//
	public void updateSalary(Salary salary);
//
	public void deleteSalary(int id);
//
	public boolean isSalaryExistsByID(int id);
//
//	public boolean isSalaryExistsByName(String name);

}
