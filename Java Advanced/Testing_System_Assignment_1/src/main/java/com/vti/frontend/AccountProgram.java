package com.vti.frontend;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Position;
import com.vti.repository.AccountRepository;
import com.vti.repository.PositionRepository;

public class AccountProgram {
	public static void main(String[] args) {
		
		
		AccountRepository accountRepository = new AccountRepository();
		// lay danh sach
		
		List<Account> list = new ArrayList<Account>();
		
		list = accountRepository.getAllAccounts();
		for (Account account : list) {
			System.out.println(account);
			
		}
		
		// tao moi account
		
//		Account account = new Account();
//		account.setEmail("nguyenvana@gmail.com");
//		account.setFirstName("first");
//		account.setLastName("last");
//		account.setUsername("dongphuongbatbai");
//		Date date = new Date();
//		account.setCreateDate(date);
//		
//		accountRepository.createAccount(account);
		
		// xoa tai khoan bang id
		
//		accountRepository.deleteAccount((short) 13);
		
		
	}
}
