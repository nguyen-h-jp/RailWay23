package com.vti.backend.datalayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vti.backend.datalayer.interfaces.IAccountRepository;
import com.vti.backend.datalayer.interfaces.IDepartmentRepository;
import com.vti.backend.datalayer.interfaces.IGroupRepository;
import com.vti.backend.datalayer.interfaces.IPositionRepository;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.utils.DateUtils;
import com.vti.utils.JDBCUtils;

public class AccountRepository implements IAccountRepository {

	private IDepartmentRepository departmentRepository = new DepartmentRepository();
	private IPositionRepository positionRepository = new PositionRepository();
	private IGroupRepository groupRepository = new GroupRepository();

	/**
	 * lấy danh sách các account
	 */
	@Override
	public List<Account> getAccountList() throws SQLException {
		List<Account> listAccounts = new ArrayList<Account>();
		String sql = "SELECT * FROM testing_system.account;";
		Statement statement = JDBCUtils.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			Department department = departmentRepository.getDepartmentByID(resultSet.getInt("department_id"));
			Position position = positionRepository.getPositionByID(resultSet.getInt("position_id"));
			List<Group> groups = groupRepository.getGroupListByAccountID(resultSet.getInt("account_id"));
			Date createDate = DateUtils.getDate(resultSet.getString("create_date"), DateUtils.mySQLDatePattern);
			listAccounts.add(new Account(resultSet.getInt("account_id"), resultSet.getString("email"),
					resultSet.getString("username"), resultSet.getString("full_name"), department, position, createDate,
					groups));
		}
		return listAccounts;
	}

	/**
	 * tạo account
	 */
	@Override
	public int createAccount(Account account) throws SQLException {

		String sql = "INSERT INTO `account`(email, username, full_name, department_id, position_id, create_date) "
				+ "VALUES (?, ?, ?, ?, ?, ?);";
		PreparedStatement preparedStatement = JDBCUtils.createPreparedStatement(sql);
		preparedStatement.setString(1, account.getEmail());
		preparedStatement.setString(2, account.getUserName());
		preparedStatement.setString(3, account.getFullName());
		preparedStatement.setInt(4, account.getDepartment().getDepartmentID());
		preparedStatement.setInt(5, account.getPosition().getPositionID());
		preparedStatement.setString(6, DateUtils.formatDate(new Date(), DateUtils.mySQLDatePattern));
		int effectedRecords = preparedStatement.executeUpdate();
		return effectedRecords;
	}

	/**
	 * tìm account theo id
	 */
	@Override
	public List<Account> getAccountByID(int accountID) throws SQLException {
		List<Account> listAccounts = new ArrayList<Account>();
		String sql = "select * from `account` where account_id = ?;";
		PreparedStatement preparedStatement = JDBCUtils.createPreparedStatement(sql);
		preparedStatement.setInt(1, accountID);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Department department = departmentRepository.getDepartmentByID(resultSet.getInt("department_id"));
			Position position = positionRepository.getPositionByID(resultSet.getInt("position_id"));
			List<Group> groups = groupRepository.getGroupListByAccountID(resultSet.getInt("account_id"));
			Date createDate = DateUtils.getDate(resultSet.getString("create_date"), DateUtils.mySQLDatePattern);
			listAccounts.add(new Account(resultSet.getInt("account_id"), resultSet.getString("email"),
					resultSet.getString("username"), resultSet.getString("full_name"), department, position, createDate,
					groups));
		}
		return listAccounts;
	}

	/**
	 * kiểm tra account có tồn tại không(kiểm tra theo username)
	 */
	@Override
	public boolean isAccountExists(String username) throws SQLException {
		String sql = "select * from `account` where username = ?;";
		PreparedStatement preparedStatement = JDBCUtils.createPreparedStatement(sql);
		preparedStatement.setString(1, username);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		}
		return false;
	}

	/**
	 * kiểm tra account có tồn tại không(kiểm tra theo account id)
	 */
	@Override
	public boolean isAccountExists(int accountID) throws SQLException {
		String sql = "select * from `account` where account_id = ?;";
		PreparedStatement preparedStatement = JDBCUtils.createPreparedStatement(sql);
		preparedStatement.setInt(1, accountID);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		}
		return false;
	}

	/**
	 * cập nhật thông tin account theo account id
	 */
	@Override
	public int updateAccountByID(int accountID, Account account) throws SQLException {
		String sql = "UPDATE `account` SET email = ?, username = ?, full_name = ?, department_id = ?, position_id = ?, create_date = ?"
				+ " WHERE (`account_id` = ?);";
		PreparedStatement preparedStatement = JDBCUtils.createPreparedStatement(sql);
		preparedStatement.setString(1, account.getEmail());
		preparedStatement.setString(2, account.getUserName());
		preparedStatement.setString(3, account.getFullName());
		preparedStatement.setInt(4, account.getDepartment().getDepartmentID());
		preparedStatement.setInt(5, account.getPosition().getPositionID());
		preparedStatement.setString(6, DateUtils.formatDate(account.getCreateDate(), DateUtils.mySQLDatePattern));
		preparedStatement.setInt(7, accountID);
		int effectedRecords = preparedStatement.executeUpdate();
		return effectedRecords;
	}

	/**
	 * xóa account theo account id
	 */
	@Override
	public int deleteAccountByID(int accountID) throws SQLException {
		String sql = "DELETE FROM `account` WHERE (`account_id` = ?);";
		PreparedStatement preparedStatement = JDBCUtils.createPreparedStatement(sql);
		preparedStatement.setInt(1, accountID);
		int effectedRecords = preparedStatement.executeUpdate();
		return effectedRecords;
	}

}
