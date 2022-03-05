package com.vti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vti.entity.Department;
import com.vti.entity.DetailDepartment;
import com.vti.repository.IDepartmentRepository;
import com.vti.repository.IDetailDepartmentRepository;

@Service
public class DetailDepartmentService implements IDetailDepartmentService {

	@Autowired
	private IDetailDepartmentRepository repository;

	public Page<DetailDepartment> getAllDetailDepartments(Pageable pagable) {
		// TODO Auto-generated method stub
		return repository.findAll(pagable);
	}
	

	public DetailDepartment getDetailDepartmentByID(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}
//	
//	public DetailDepartment getDetailDepartmentByName(String name) {
//		// TODO Auto-generated method stub
//		return repository.findByDetailDepartmentName(name);
//	}
//
	public void createDetailDepartment(DetailDepartment detailDepartment) {
		// TODO Auto-generated method stub
		repository.save(detailDepartment);
		
	}
//
	public void updateDetailDepartment(DetailDepartment detailDepartment) {
		// TODO Auto-generated method stub
		repository.save(detailDepartment);
		
	}
//
	public void deleteDetailDepartment(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}
//	
	public boolean isDetailDepartmentExistsByID(int id) {
		// TODO Auto-generated method stub
		return repository.existsById(id);
	}
//
//	public boolean isDetailDepartmentExistsByName(String name) {
//		// TODO Auto-generated method stub
//		return repository.existsByDetailDepartmentName(name);
//	}

	

	


}

