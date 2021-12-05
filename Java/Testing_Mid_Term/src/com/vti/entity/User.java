package com.vti.entity;

public class User {
	private int id;
	private String fullName;
	private String userName;
	private String email;
	private String password;

	public User(int id, String fullName, String userName, String email, String password) {
		super();
		this.setId(id);
		this.setFullName(fullName);
		this.setUserName(userName);
		this.setEmail(email);
		this.setPassword(password);
	}

	@Override
	public String toString() {
		return "User [id=" + getId() + ", fullName=" + getFullName() + ", userName=" + getUserName() + ", email="
				+ getEmail() + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
