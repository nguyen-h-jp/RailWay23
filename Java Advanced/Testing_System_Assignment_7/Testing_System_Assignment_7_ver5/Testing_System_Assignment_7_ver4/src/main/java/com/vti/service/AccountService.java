package com.vti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vti.entity.Account;
import com.vti.repository.IAccountRepository;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private IAccountRepository repository;

	public Page<Account> getAllAccounts(Pageable pagable) {
		// TODO Auto-generated method stub
		return repository.findAll(pagable);
	}
	
//	public Account findByAccountName(String name) {
//		return repository.findByAccountName(name);
//	}

	public Account getAccountByID(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}
//	
//	public Account getAccountByName(String name) {
//		// TODO Auto-generated method stub
//		return repository.findByAccountName(name);
//	}
//
	public void createAccount(Account account) {
		// TODO Auto-generated method stub
		repository.save(account);
		
	}
//
	public void updateAccount(Account account) {
		// TODO Auto-generated method stub
		repository.save(account);
		
	}
//
	public void deleteAccount(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}
//	
	public boolean isAccountExistsByID(int id) {
		// TODO Auto-generated method stub
		return repository.existsById(id);
	}
//
//	public boolean isAccountExistsByName(String name) {
//		// TODO Auto-generated method stub
//		return repository.existsByAccountName(name);
//	}



	

	


}

