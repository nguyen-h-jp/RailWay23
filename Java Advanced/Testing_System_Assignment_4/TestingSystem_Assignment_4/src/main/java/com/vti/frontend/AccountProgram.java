package com.vti.frontend;

import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.repository.AccountRepository;

public class AccountProgram {
	public static void main(String[] args) {
		
//		AddressRepository addressRepository = new AddressRepository();
		AccountRepository accountRepository = new AccountRepository();
		
		List<Account> list = new ArrayList<Account>();
		list = accountRepository.getAllAccounts();
		for (Account account : list) {
			// danh sach account
			System.out.println(account);
		}
		
		// create account
		
//		Account account = new Account();
//		account.setEmail("test@gmail.com");
//		account.setUsername("test2");
//		account.setFirstName("first name");
//		account.setLastName("last name");
//		Department department = new Department();
//		department.setDepartmentID(1);
//		department.setDepartmentName("Test");
//		account.setDepartment(department);
//		
//		Position position = new Position();
//		position.se
		
//		
//		
//		accountRepository.createAccount(account);
		
	}
}
