package com.vti.frontend;

import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Department;
import com.vti.repository.DepartmentRepository;

public class DepartmentProgram {
	public static void main(String[] args) {
		
		DepartmentRepository departmentRepository = new DepartmentRepository();
		
		List<Department> list = new ArrayList<Department>();
		list = departmentRepository.getAllDepartments();
		for (Department department : list) {	
			System.out.println(department);
//			System.out.println(department.getDetailDepartment());
		}
	}
}
