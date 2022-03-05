package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.entity.Account;

public interface IAccountRepository extends JpaRepository<Account, Integer> {
	
	
	
	
//	public Account findByAccountName(String name);

//	
//	public void createAccount(Account account);
//	
//	public void updateAccount(int id, String newName);
//
//	public void updateAccount(Account account);
//
//	public void deleteByAccountID(int id);
//	
//	public boolean existsByAccountName(String name);
//
//	public boolean isAccountExistsByID(int id);

}
