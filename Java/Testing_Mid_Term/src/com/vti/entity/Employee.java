package com.vti.entity;

public class Employee extends User {

	private int expInYear;

	public Employee(int id, String fullName, String userName, String email, String password, int expInYear) {
		super(id, fullName, userName, email, password);
		// TODO Auto-generated constructor stub
		this.expInYear = expInYear;
	}

	@Override
	public String toString() {
		return "Employee [expInYear=" + expInYear + ", id=" + getId() + ", fullName=" + getFullName() + ", userName="
				+ getUserName() + ", email=" + getEmail() + "]";
	}

}
