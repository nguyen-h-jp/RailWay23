/**
 * Description: 
 */
package com.vti.entity;

/**
 * Description:
 */
public class Employee extends User {
	String proSkill;

	public Employee(int id, String fullName, String email, String password, String proSkill) {
		super(id, fullName, email, password);
		this.proSkill = proSkill;
	}

	public String getProSkill() {
		return proSkill;
	}

	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}

	@Override
	public String toString() {
		return "Employee [proSkill=" + proSkill + ", id=" + userID + ", fullName=" + fullName + ", email=" + email
				+ ", password=" + password + "]";
	}

}
