package com.vti.repository;

import java.util.List;

import com.vti.entity.Account;

public interface IAccountRepository {

	public List<Account> getAllAccounts();

	public Account getAccountByID(int id);

	public Account getAccountByName(String fullName);

	public void createAccount(Account account);

	public void updateAccount(int id, String fullName);

	public void updateAccount(Account account);

	public void deleteAccount(int id);

	public boolean isAccountExistsByID(int id);

	public boolean isAccountExistsByName(String fullName);

}
