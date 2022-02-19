package com.vti.frontend;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.entity.Question;
import com.vti.entity.Salary;
import com.vti.repository.DepartmentRepository;
import com.vti.repository.PositionRepository;
import com.vti.repository.QuestionRepository;
import com.vti.repository.SalaryRepository;

public class SalaryProgram {
	public static void main(String[] args) {
		
		SalaryRepository salaryRepository = new SalaryRepository();
		
		// lay danh sach salary
		
//		List<Salary> list = new ArrayList<Salary>();
//		list = salaryRepository.getAllSalarys();
//		
//		System.out.println(list);
		
		// tao moi salary
		
		Salary salary = new Salary();
		salary.setSalaryName(Salary.SalaryName.D);
//		salary.setSalaryID((short)4);
		salaryRepository.createSalary(salary);
	}
	
	
}
