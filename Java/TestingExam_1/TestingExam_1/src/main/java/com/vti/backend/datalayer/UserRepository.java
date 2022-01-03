/**
 * Description: 
 */
package com.vti.backend.datalayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.backend.datalayer.interfaces.IUserRepository;
import com.vti.entity.Admin;
import com.vti.entity.Employee;
import com.vti.entity.User;
import com.vti.utils.JDBCUtils;

/**
 * Description:
 */
public class UserRepository implements IUserRepository {

	@Override
	public User getUserByUserID(int userID) throws SQLException {
		String sql = "SELECT * from `user` where user_id = ?;";
		User user = null;
		PreparedStatement preparedStatement = JDBCUtils.createPreparedStatement(sql);
		preparedStatement.setInt(1, userID);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			if (resultSet.getInt("type_id") == 1) {
				user = new Admin(resultSet.getInt("user_id"), resultSet.getString("full_name"),
						resultSet.getString("email"), resultSet.getString("password"), resultSet.getInt("exp_in_year"));

			} else if (resultSet.getInt("type_id") == 2) {
				user = new Employee(resultSet.getInt("user_id"), resultSet.getString("full_name"),
						resultSet.getString("email"), resultSet.getString("password"),
						resultSet.getString("pro_skill"));
			}

		}
		return user;
	}

	@Override
	public List<User> getUserInformation() throws SQLException {
		List<User> userList = new ArrayList<User>();
		String sql = "SELECT * FROM user;";
		Statement statement = JDBCUtils.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			userList.add(new User(resultSet.getInt("user_id"), resultSet.getString("full_name"),
					resultSet.getString("email")));
		}
		return userList;
	}

	@Override
	public int deleteUserByUserID(int userID) throws SQLException {
		String sql = "DELETE FROM `user` WHERE (`user_id` = ?);";
		PreparedStatement preparedStatement = JDBCUtils.createPreparedStatement(sql);
		preparedStatement.setInt(1, userID);
		int effectedRecords = preparedStatement.executeUpdate();
		return effectedRecords;
	}

	@Override
	public int login(String email, String password) throws SQLException {

		int userType = 0;
		String sql = "select * from `user` where email = ? && password = ?;";
		PreparedStatement preparedStatement = JDBCUtils.createPreparedStatement(sql);
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, password);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			if (resultSet.getInt("type_id") == 1) {
				userType = 1;
			} else {
				userType = 2;
			}

		}
		return userType;
	}

	@Override
	public int createEmployee(String fullName, String email) throws SQLException {
		String sql = "INSERT INTO `user` (`full_name`, `email`, `password`, `type_id`) VALUES (?, ?, ?, ?);";
		PreparedStatement preparedStatement = JDBCUtils.createPreparedStatement(sql);
		preparedStatement.setString(1, fullName);
		preparedStatement.setString(2, email);
		preparedStatement.setString(3, "123456");
		preparedStatement.setInt(4, 2);
		int effectedRecords = preparedStatement.executeUpdate();
		return effectedRecords;
	}

}
