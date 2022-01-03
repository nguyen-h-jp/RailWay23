/**
 * Description: 
 */
package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

import com.vti.backend.businesslayer.interfaces.IUserService;
import com.vti.backend.datalayer.UserRepository;
import com.vti.backend.datalayer.interfaces.IUserRepository;
import com.vti.entity.User;

/**
 * Description:
 */
public class UserService implements IUserService {
	IUserRepository userRepository = new UserRepository();

	final static String regexEmail = "[a-z0-9._]+@[a-z0-9.]+";
	final static String regexPassword = ".*[A-Z].*";
	final static String regexWord = "[a-zA-Z]+";

	/**
	 * Description: check string by regex
	 */
	public static boolean patternMatches(String string, String regexPattern) {
		return Pattern.compile(regexPattern).matcher(string).matches();
	}

	@Override
	public User getUserByUserID(int userID) throws SQLException {
		return userRepository.getUserByUserID(userID);
	}

	@Override
	public List<User> getUserInformation() throws SQLException {
		return userRepository.getUserInformation();
	}

	@Override
	public int deleteUserByUserID(int userID) throws SQLException {
		return userRepository.deleteUserByUserID(userID);
	}

	@Override
	public int login(String email, String password) throws SQLException {
		if (!patternMatches(email, regexEmail)) {
			System.out.println("Email không hợp lệ");
		} else if (!patternMatches(password, regexPassword) || password.length() < 6 || password.length() > 12) {
			System.out.println("Password không hợp lệ");
		} else {
			return userRepository.login(email, password);
		}
		return 0;
	}

	@Override
	public int createEmployee(String fullName, String email) throws SQLException {
		if (!patternMatches(email, regexEmail)) {
			System.out.println("Email không hợp lệ");
		} else if (!patternMatches(fullName, regexWord)) {
			System.out.println("Full name không hợp lệ");
		} else {
			return userRepository.createEmployee(fullName, email);
		}
		return 0;
	}
}
