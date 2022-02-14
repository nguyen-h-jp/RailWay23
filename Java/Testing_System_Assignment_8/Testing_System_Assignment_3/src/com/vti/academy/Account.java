package com.vti.academy;
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
	int accountID;
	String email;
	String userName;
	String fullName;
	Department department;
	Position position;
	Date createDate;
	Group[] groups;
}
