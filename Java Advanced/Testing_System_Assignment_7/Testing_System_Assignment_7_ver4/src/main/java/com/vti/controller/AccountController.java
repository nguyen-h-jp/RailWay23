package com.vti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.Account;
import com.vti.service.IAccountService;

@RestController
@RequestMapping(value = "api/v1/accounts")
public class AccountController {

	@Autowired
	private IAccountService service;

	@GetMapping()
	public Page<Account> getAllAccounts(Pageable pagable) {
		return service.getAllAccounts(pagable);
	}
	
//	@GetMapping(value = "/")
//	public Account findByAccountName(@RequestParam(name = "name") String name) {
//		return service.findByAccountName(name);
//	}
	
	@GetMapping(value = "/{id}")
	public Account getAccountByID(@PathVariable(name = "id") Integer id) {
		return service.getAccountByID(id);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteAccount(@PathVariable(name = "id") int id) {
		service.deleteAccount(id);
	}
	
	@PutMapping(value = "/{id}")
	public void updateAccount(@PathVariable(name = "id") int id, @RequestBody Account account) {
		account.setAccountID(id);
		service.updateAccount(account);
	}
	
	@PostMapping()
	public void createAccount(@RequestBody Account account) {
		service.createAccount(account);
	}
	

}

