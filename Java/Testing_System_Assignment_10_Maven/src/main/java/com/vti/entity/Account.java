package com.vti.entity;

import java.util.Date;
import java.util.List;

import com.vti.utils.DateUtils;

/*Table 3: Account
 AccountID: định danh của User (auto increment)
 Email:
 Username:
 FullName:
 DepartmentID: phòng ban của user trong hệ thống
 PositionID: chức vụ của User
 CreateDate: ngày tạo tài khoản*/

public class Account {
	int accountID;
	String email;
	String userName;
	String fullName;
	Department department;
	Position position;
	Date createDate;
	List<Group> groups;

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public Account(int accountID, String email, String userName, String fullName, Department department,
			Position position, Date createDate) {
		super();
		this.accountID = accountID;
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
		this.department = department;
		this.position = position;
		this.createDate = createDate;
	}

	public Account(int accountID, String email, String userName, String fullName, Department department,
			Position position, Date createDate, List<Group> groups) {
		super();
		this.accountID = accountID;
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
		this.department = department;
		this.position = position;
		this.createDate = createDate;
		this.groups = groups;
	}

	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", email=" + email + ", userName=" + userName + ", fullName="
				+ fullName + ", department=" + department + ", position=" + position + ", createDate="
				+ DateUtils.formatDate(createDate, DateUtils.mySQLDatePattern) + ", groups=" + groups + "]";
	}

}
