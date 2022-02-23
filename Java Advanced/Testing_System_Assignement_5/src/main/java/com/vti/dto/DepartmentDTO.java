package com.vti.dto;

import com.vti.entity.Department;

public class DepartmentDTO {
	private String departmentName;

	
	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public DepartmentDTO() {
	}

	public Department toEntity() {
		return new Department(departmentName);
	}

}
