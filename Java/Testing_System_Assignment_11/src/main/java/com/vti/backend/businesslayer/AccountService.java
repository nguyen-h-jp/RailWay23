package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.interfaces.IAccountService;
import com.vti.backend.datalayer.AccountRepository;
import com.vti.backend.datalayer.interfaces.IAccountRepository;
import com.vti.entity.Account;

public class AccountService implements IAccountService {
	IAccountRepository accountRepository = new AccountRepository();

	@Override
	public int createAccount(Account account) throws SQLException {
		return accountRepository.createAccount(account);
	}

	@Override
	public List<Account> getAccountList() throws SQLException {
		return accountRepository.getAccountList();
	}

	@Override
	public List<Account> getAccountByID(int accountID) throws SQLException {
		return accountRepository.getAccountByID(accountID);
	}

	@Override
	public boolean isAccountExists(String username) throws SQLException {
		return accountRepository.isAccountExists(username);

	}

	@Override
	public boolean isAccountExists(int accountID) throws SQLException {
		return accountRepository.isAccountExists(accountID);
	}

	@Override
	public int updateAccountByID(int accountID, Account account) throws SQLException {
		return accountRepository.updateAccountByID(accountID, account);
	}

	@Override
	public int deleteAccountByID(int accountID) throws SQLException {
		return accountRepository.deleteAccountByID(accountID);
	}

}
