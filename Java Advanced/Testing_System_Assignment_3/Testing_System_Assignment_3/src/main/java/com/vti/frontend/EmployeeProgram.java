package com.vti.frontend;

import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Account;
import com.vti.repository.AccountRepository;

public class EmployeeProgram {
	public static void main(String[] args) {
		
//		AddressRepository addressRepository = new AddressRepository();
		AccountRepository accountRepository = new AccountRepository();
		
		List<Account> list = new ArrayList<Account>();
		list = accountRepository.getAllAccounts();
		for (Account account : list) {
			// danh sach address
			System.out.println(account);
		}
	}
}
