package com.vti.frontend;

import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Salary;
import com.vti.repository.SalaryRepository;

public class SalaryProgram {
	public static void main(String[] args) {

		SalaryRepository salaryRepository = new SalaryRepository();
		
		

		List<Salary> list = new ArrayList<Salary>();
		list = salaryRepository.getAllSalarys();
		for (Salary salary : list) {
			// danh sach salary
			System.out.println(salary.getSalaryName());
			for (Account account : salary.getAccounts()) {
				System.out.println(account.getUsername());
			}
		}
	}
}
