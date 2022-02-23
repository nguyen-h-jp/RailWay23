package com.vti.frontend;

import java.util.ArrayList;
import java.util.List;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.repository.DepartmentRepository;

public class DepartmentProgram {
	public static void main(String[] args) {
		
		DepartmentRepository departmentRepository = new DepartmentRepository();
		
//		List<Department> list = new ArrayList<Department>();
//		list = departmentRepository.getAllDepartments();
//		for (Department department : list) {	
//			System.out.println(department);
//		}
		
		
//		List<DepartmentDTO> departmentDTOs = new ArrayList<DepartmentDTO>();
//		
//		departmentDTOs = departmentRepository.getAllDepartmentsUsingConstructor(1, 9, "a", 8);
//		
//		for (DepartmentDTO departmentDTO : departmentDTOs) {
//			System.out.println(departmentDTO);
//		}
		
		
//		@SuppressWarnings("deprecation")
//		Long totalCount = new Long(0);
//		
//		totalCount = departmentRepository.getTotalCount("a", 5);
//		System.out.println(totalCount);
		
//		Department department = new Department();
//		
//		department = departmentRepository.getDepartmentByID(2);
//		System.out.println(department.getDepartmentID() + " " +  department.getDepartmentName());
		
//		Department department = new Department();
//		department = departmentRepository.getDepartmentByName("Sale");
//		System.out.println(department.getDepartmentID() + " " +  department.getDepartmentName());
		
		
//		departmentRepository.updateDepartment(7, "Bán Hàng 5", 7, 1);
//		 bị lỗi chưa add được address
		departmentRepository.deleteDepartment (10);
		
		
	}
}
