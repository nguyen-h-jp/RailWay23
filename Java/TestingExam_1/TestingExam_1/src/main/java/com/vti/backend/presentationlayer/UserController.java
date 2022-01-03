/**
 * Description: 
 */
package com.vti.backend.presentationlayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.UserService;
import com.vti.backend.businesslayer.interfaces.IUserService;
import com.vti.entity.User;

/**
 * Description:
 */
public class UserController {
	IUserService userService = new UserService();

	public User getUserByUserID(int userID) {
		try {
			return userService.getUserByUserID(userID);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public List<User> getUserInformation() {
		try {
			return userService.getUserInformation();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public int deleteUserByUserID(int userID) {
		try {
			return userService.deleteUserByUserID(userID);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return 0;
	}

	public int login(String email, String password) {
		try {
			return userService.login(email, password);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return 0;
	}

	public int createEmployee(String fullName, String email) {
		try {
			return userService.createEmployee(fullName, email);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return 0;
	}
}
