/**
 * Description: 
 */
package com.vti.entity;

/**
 * Description:
 */
public class User {
	int userID;
	String fullName;
	String email;
	String password;

	@Override
	public String toString() {
		return "User [id=" + userID + ", fullName=" + fullName + ", email=" + email + "]";
	}

	public User(int id, String fullName, String email, String password) {
		super();
		this.userID = id;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
	}

	public User(int id, String fullName, String email) {
		super();
		this.userID = id;
		this.fullName = fullName;
		this.email = email;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int id) {
		this.userID = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
