package com.vti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vti.entity.Salary;
import com.vti.repository.ISalaryRepository;

@Service
public class SalaryService implements ISalaryService {

	@Autowired
	private ISalaryRepository repository;

	public Page<Salary> getAllSalarys(Pageable pagable) {
		// TODO Auto-generated method stub
		return repository.findAll(pagable);
	}
	
	public Salary findBySalaryName(String name) {
		return repository.findBySalaryName(name);
	}

	public Salary getSalaryByID(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}
//	
//	public Salary getSalaryByName(String name) {
//		// TODO Auto-generated method stub
//		return repository.findBySalaryName(name);
//	}
//
	public void createSalary(Salary salary) {
		// TODO Auto-generated method stub
		repository.save(salary);
		
	}
//
	public void updateSalary(Salary salary) {
		// TODO Auto-generated method stub
		repository.save(salary);
		
	}
//
	public void deleteSalary(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}
//	
	public boolean isSalaryExistsByID(int id) {
		// TODO Auto-generated method stub
		return repository.existsById(id);
	}
//
//	public boolean isSalaryExistsByName(String name) {
//		// TODO Auto-generated method stub
//		return repository.existsBySalaryName(name);
//	}



	

	


}

