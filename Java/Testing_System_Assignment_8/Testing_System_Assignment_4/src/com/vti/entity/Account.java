package com.vti.entity;
import java.util.Arrays;
import java.util.Date;

/*Table 3: Account
 AccountID: định danh của User (auto increment)
 Email:
 Username:
 FullName:
 DepartmentID: phòng ban của user trong hệ thống
 PositionID: chức vụ của User
 CreateDate: ngày tạo tài khoản*/

public class Account {
	private int accountID;
	private String email;
	private String userName;
	private String fullName;
	private Department department;
	private Position position;
	private Date createDate;
	private Group[] groups;
	
	@Override
	public String toString() {
		return "Account [accountID=" + getAccountID() + ", email=" + getEmail() + ", userName=" + getUserName() + ", fullName="
				+ getFullName() + ", department=" + getDepartment() + ", position=" + getPosition() + ", createDate=" + getCreateDate()
				+ ", groups=" + Arrays.toString(getGroups()) + "]";
	}

	public Account(){
		
	}

	public Account(int accountID, String email, String userName, String firstName, String lastName) {
		super();
		this.setAccountID(accountID);
		this.setEmail(email);
		this.setUserName(userName);
		this.setFullName(firstName.concat(" ").concat(lastName));
	}
	
	public Account(int accountID, String email, String userName, String firstName, String lastName, Position position) {
		super();
		this.setAccountID(accountID);
		this.setEmail(email);
		this.setUserName(userName);
		this.setFullName(firstName.concat(" ").concat(lastName));
		this.setPosition(position);
		this.setCreateDate(new Date());
	}
	
	public Account(int accountID, String email, String userName, String firstName, String lastName, Position position, Date createDate) {
		super();
		this.setAccountID(accountID);
		this.setEmail(email);
		this.setUserName(userName);
		this.setFullName(firstName.concat(" ").concat(lastName));
		this.setPosition(position);
		this.setCreateDate(createDate);
	}

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

	public Group[] getGroups() {
		return groups;
	}

	public void setGroups(Group[] groups) {
		this.groups = groups;
	}
	
}
