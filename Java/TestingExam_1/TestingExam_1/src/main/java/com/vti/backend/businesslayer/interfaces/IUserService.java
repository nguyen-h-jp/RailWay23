/**
 * Description: 
 */
package com.vti.backend.businesslayer.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.User;

/**
 * Description:
 */
public interface IUserService {
	public User getUserByUserID(int userID) throws SQLException;

	public List<User> getUserInformation() throws SQLException;

	public int deleteUserByUserID(int userID) throws SQLException;

	public int login(String email, String password) throws SQLException;

	public int createEmployee(String fullName, String email) throws SQLException;
}
