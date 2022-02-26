package com.vti.service;

import java.util.List;

import com.vti.entity.Account;

public interface IAccountService {

	public List<Account> getAllAccounts();

	public Account getAccountByID(int id);

	public Account getAccountByName(String name);

	public void createAccount(Account department);

	public void updateAccount(int id, String newName);

	public void updateAccount(Account department);

	public void deleteAccount(int id);

	public boolean isAccountExistsByID(int id);

	public boolean isAccountExistsByName(String name);

}
