package com.vti.frontend;

import java.util.ArrayList;
import java.util.List;

import com.vti.entity.DetailDepartment;
import com.vti.repository.DetailDepartmentRepository;

public class DetailDepartmentProgram {
	public static void main(String[] args) {
		
		DetailDepartmentRepository detailDepartmentRepository = new DetailDepartmentRepository();
		List<DetailDepartment> list = new ArrayList<DetailDepartment>();
		list = detailDepartmentRepository.getAllDetailDepartments();
		for (DetailDepartment detailDepartment : list) {
			System.out.println(detailDepartment);
		}
	}
}
