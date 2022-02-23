package com.vti.frontend;

import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Employee;
import com.vti.repository.EmployeeRepository;

public class EmployeeProgram {
	public static void main(String[] args) {

//		AddressRepository addressRepository = new AddressRepository();
		EmployeeRepository employeeRepository = new EmployeeRepository();

		List<Employee> list = new ArrayList<Employee>();
		list = employeeRepository.getAllEmployees();
		for (Employee employee : list) {
			// danh sach employee
			System.out.println(employee);
		}
	}
}
