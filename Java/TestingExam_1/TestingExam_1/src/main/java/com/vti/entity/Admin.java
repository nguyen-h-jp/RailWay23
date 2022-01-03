/**
 * Description: 
 */
package com.vti.entity;

/**
 * Description:
 */
public class Admin extends User {
	int expInYear;

	public Admin(int id, String fullName, String email, String password, int expInYear) {
		super(id, fullName, email, password);
		this.expInYear = expInYear;
	}

	public int getExpInYear() {
		return expInYear;
	}

	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}

	@Override
	public String toString() {
		return "Admin [expInYear=" + expInYear + ", id=" + userID + ", fullName=" + fullName + ", email=" + email
				+ ", password=" + password + "]";
	}

}
