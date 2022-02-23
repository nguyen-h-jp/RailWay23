package com.vti.frontend;

import java.util.ArrayList;
import java.util.List;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.repository.DepartmentRepository;
import com.vti.repository.DepartmentRepositoryCriteria;

public class DepartmentCriteriaProgram {
	public static void main(String[] args) {
		
		DepartmentRepositoryCriteria departmentRepositoryCriteria = new DepartmentRepositoryCriteria();
		List<DepartmentDTO> departmentDTOs = new ArrayList<DepartmentDTO>();
		departmentDTOs = departmentRepositoryCriteria.getAllDepartmentsUsingConstructor(1, 2, "Sale", 1);
		System.out.println(departmentDTOs);
		
		
	}
}
