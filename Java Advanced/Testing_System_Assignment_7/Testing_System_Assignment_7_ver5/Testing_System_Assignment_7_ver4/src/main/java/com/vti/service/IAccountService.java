package com.vti.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.entity.Account;

public interface IAccountService {

	public Page<Account> getAllAccounts(Pageable pagable);
	
//	public Account findByAccountName(String name);
	
	public Account getAccountByID(Integer id);

//	public Account getAccountByID(Integer id);
//
//	public Account getAccountByName(String name);
//
	public void createAccount(Account account);
//
	public void updateAccount(Account account);
//
	public void deleteAccount(int id);
//
	public boolean isAccountExistsByID(int id);
//
//	public boolean isAccountExistsByName(String name);

}
