package com.vti.backend.presentationlayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.AccountService;
import com.vti.backend.businesslayer.GroupService;
import com.vti.backend.businesslayer.interfaces.IAccountService;
import com.vti.backend.businesslayer.interfaces.IGroupService;
import com.vti.entity.Account;
import com.vti.entity.Group;
import com.vti.utils.JDBCUtils;
import com.vti.utils.ScannerUtils;

public class AccountController {
	IAccountService accountService = new AccountService();
	IGroupService groupService = new GroupService();

	/**
	 * Description: lấy danh sách group theo account id
	 */
	public List<Group> getGroupListByAccountID(int accountID) {
		try {
			return groupService.getGroupListByAccountID(accountID);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * Description: lấy danh sách account
	 */
	public List<Account> getAccountList() {
		List<Account> accountList = null;
		try {
			accountList = accountService.getAccountList();
		} catch (SQLException e) {
			JDBCUtils.close();
			ScannerUtils.close();
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return accountList;
	}

	/**
	 * Description: tạo mới account
	 */
	public int createAccount(Account account) {
		try {
			return accountService.createAccount(account);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Description: lấy thông tin account theo id
	 */
	public List<Account> getAccountByID(int accountID) throws SQLException {
		return accountService.getAccountByID(accountID);
	}

	/**
	 * Description: kiểm tra account có tồn tại không(kiểm tra theo username)
	 */
	public boolean isAccountExists(String username) throws SQLException {
		return accountService.isAccountExists(username);
	}

	/**
	 * Description: kiểm tra account có tồn tại không(kiểm tra theo account id)
	 */
	public boolean isAccountExists(int accountID) throws SQLException {
		return accountService.isAccountExists(accountID);
	}

	/**
	 * Description: cập nhật account theo account id
	 */
	public int updateAccountByID(int accountID, Account account) throws SQLException {
		return accountService.updateAccountByID(accountID, account);
	}

	/**
	 * Description: xóa thông tin account
	 */
	public int deleteAccountByID(int accountID) throws SQLException {
		return accountService.deleteAccountByID(accountID);
	}
}
