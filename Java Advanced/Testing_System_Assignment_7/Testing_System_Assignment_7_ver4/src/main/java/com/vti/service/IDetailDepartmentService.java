package com.vti.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.entity.Department;
import com.vti.entity.DetailDepartment;

public interface IDetailDepartmentService {

	public Page<DetailDepartment> getAllDetailDepartments(Pageable pagable);
	
	public DetailDepartment getDetailDepartmentByID(Integer id);

//	public DetailDepartment getDetailDepartmentByID(Integer id);
//
//	public DetailDepartment getDetailDepartmentByName(String name);
//
	public void createDetailDepartment(DetailDepartment detailDepartment);
//
	public void updateDetailDepartment(DetailDepartment detailDepartment);
//
	public void deleteDetailDepartment(int id);
//
	public boolean isDetailDepartmentExistsByID(int id);
//
//	public boolean isDetailDepartmentExistsByName(String name);

}
