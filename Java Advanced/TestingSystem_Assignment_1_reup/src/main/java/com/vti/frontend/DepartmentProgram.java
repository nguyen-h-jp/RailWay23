package com.vti.frontend;

import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.repository.DepartmentRepository;
import com.vti.repository.PositionRepository;

public class DepartmentProgram {
	public static void main(String[] args) {
		
		DepartmentRepository departmentRepository = new DepartmentRepository();
		
		// lay danh sach cac phong ban
//		List<Department> list = new ArrayList<Department>();
//		list = departmentRepository.getAllDepartments();
//		System.out.println(list);
		
		// tao moi phong ban
		
		Department department = new Department();
		department.setDepartmentName("Phong chờ");
		
		departmentRepository.createDepartment(department);
	}
}
