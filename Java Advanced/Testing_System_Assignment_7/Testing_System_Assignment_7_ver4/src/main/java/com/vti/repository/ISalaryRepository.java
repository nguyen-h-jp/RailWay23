package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.entity.Salary;

public interface ISalaryRepository extends JpaRepository<Salary, Integer> {
	
	public Salary findBySalaryName(String name);

//	
//	public void createSalary(Salary salary);
//	
//	public void updateSalary(int id, String newName);
//
//	public void updateSalary(Salary salary);
//
//	public void deleteBySalaryID(int id);
//	
//	public boolean existsBySalaryName(String name);
//
//	public boolean isSalaryExistsByID(int id);

}
