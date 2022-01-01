package com.vti.backend.businesslayer.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Account;

public interface IAccountService {

	/**
	 * Description: lấy danh sách account
	 */
	public List<Account> getAccountList() throws SQLException;

	/**
	 * Description: tạo mới account
	 */
	public int createAccount(Account account) throws SQLException;

	/**
	 * Description: lấy thông tin account theo id
	 */
	public List<Account> getAccountByID(int accountID) throws SQLException;

	/**
	 * Description: kiểm tra account có tồn tại không(kiểm tra theo username)
	 */
	public boolean isAccountExists(String username) throws SQLException;

	/**
	 * Description: kiểm tra account có tồn tại không(kiểm tra theo account id)
	 */
	public boolean isAccountExists(int accountID) throws SQLException;

	/**
	 * Description: cập nhật account theo account id
	 */
	public int updateAccountByID(int accountID, Account account) throws SQLException;

	/**
	 * Description: xóa thông tin account
	 */
	public int deleteAccountByID(int accountID) throws SQLException;
}
