package com.vti.entity;

public class Admin extends User {

	private String proSkill;

	public Admin(int id, String fullName, String userName, String email, String password, String proSkill) {
		super(id, fullName, userName, email, password);
		// TODO Auto-generated constructor stub
		this.proSkill = proSkill;
	}

	@Override
	public String toString() {
		return "Admin [proSkill=" + proSkill + ", id=" + getId() + ", fullName=" + getFullName() + ", userName="
				+ getUserName() + ", email=" + getEmail() + "]";
	}

}
