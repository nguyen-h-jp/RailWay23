package com.vti.backend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.vti.entity.*;
import com.vti.entity.enums.PositionName;

public class Exercise1_Constructor {
	public void question1() throws ParseException {

//		Question 1:
//			Tạo constructor cho department:
//			a) không có parameters
//			b) Có 1 parameter là nameDepartment và default id của Department = 0
//			Khởi tạo 1 Object với mỗi constructor ở trên

		System.out.println("\n-- Question 1:");
		System.out.println("a) Hàm khởi tạo không tham số");
		Department dep1 = new Department();
		dep1.setDepartmentID(1);
		dep1.setDepartmentName("Sales");
		System.out.println(dep1.toString());

		System.out.println("b) Hàm khởi tạo có tham số");
		Department dep2 = new Department("Kinh doanh");
		System.out.println(dep2.toString());
	}

	public void question2() throws ParseException {
		// createDate
		String dateString = "20-11-2011";
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date createDate = formatter.parse(dateString);
//		Question 2:
//			Tạo constructor cho Account:
//			a) Không có parameters
//			b) Có các parameter là id, Email, Username, FirstName, LastName (với FullName = FirstName + LastName)
//			c) Có các parameter là id, Email, Username, FirstName, LastName (với FullName = FirstName + LastName) và Position của User, default createDate = now
//			d) Có các parameter là id, Email, Username, FirstName, LastName (với FullName = FirstName + LastName) và Position của User, createDate
//			Khởi tạo 1 Object với mỗi constructor ở trên
		System.out.println("\n-- Question 2:");
		System.out.println("a) Hàm khởi tạo không tham số");
		Account acc1 = new Account();
		acc1.setAccountID(1);
		acc1.setEmail("nguyenvana@gmail.com");
		acc1.setUserName("a_nguyenvan");
		acc1.setFullName("Nguyễn Văn A");
		System.out.println(acc1.toString());

		System.out.println("b) Hàm khởi tạo có tham số");
		Account acc2 = new Account(2, "nguyenvanb@gmail.com", "b_nguyenvan", "Nguyễn", "Văn B");
		System.out.println(acc2.toString());

		System.out.println("c) Hàm khởi tạo có tham số");
		Account acc3 = new Account(3, "nguyenvanc@gmail.com", "c_nguyenvan", "Nguyễn", "Văn C", null);
		System.out.println(acc3.toString());

		System.out.println("d) Hàm khởi tạo có tham số");
		Account acc4 = new Account(4, "nguyenvanc@gmail.com", "c_nguyenvan", "Nguyễn", "Văn C", null, createDate);
		System.out.println(acc4.toString());
	}

	public void question3() throws ParseException {

		// Department
		Department department1 = new Department();
		department1.setDepartmentID(1);
		department1.setDepartmentName("Sales");
		Department department2 = new Department();
		department2.setDepartmentID(2);
		department2.setDepartmentName("Marketing");
		Department department3 = new Department();
		department3.setDepartmentID(3);
		department3.setDepartmentName("Bảo vệ");

		// Position
		Position position1 = new Position();
		position1.setPositionID(1);
		position1.setPositionName(PositionName.DEV.getPositionName());

		Position position2 = new Position();
		position2.setPositionID(2);
		position2.setPositionName(PositionName.TEST.getPositionName());

		Position position3 = new Position();
		position3.setPositionID(3);
		position3.setPositionName(PositionName.SCRUM_MASTER.getPositionName());

		Position position4 = new Position();
		position4.setPositionID(4);
		position4.setPositionName(PositionName.PM.getPositionName());

		// Account
		Account account1 = new Account();
		account1.setAccountID(1);
		account1.setEmail("nguyenvana@gmail.com");
		account1.setUserName("a_nguyenvan");
		account1.setFullName("Nguyễn Văn A");
		account1.setDepartment(department1);
		account1.setPosition(position1);
		account1.setCreateDate(new Date());
//				account1.groups = new  Group[] {group1, group2};

		Account account2 = new Account();
		account2.setAccountID(2);
		account2.setEmail("nguyenvanb@gmail.com");
		account2.setUserName("b_nguyenvan");
		account2.setFullName("Nguyễn Văn B");
		account2.setDepartment(department2);
		account2.setPosition(position2);
		account2.setCreateDate(new Date());
//				account2.groups = new  Group[] {group1};

		Account account3 = new Account();
		account3.setAccountID(3);
		account3.setEmail("nguyenvanc@gmail.com");
		account3.setUserName("c_nguyenvan");
		account3.setFullName("Nguyễn Văn C");
		account3.setDepartment(department3);
		account3.setPosition(position3);
		account3.setCreateDate(new Date());
//				account2.groups = new  Group[] {group1};

		// createDate
		String dateString = "20-11-2011";
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date createDate = formatter.parse(dateString);

		Account[] accountArr = new Account[] { account1, account2 };

//		Question 3:
//			Tạo constructor cho Group:
//			a) không có parameters
//			b) Có các parameter là GroupName, Creator, array Account[] accounts, CreateDate
//			c) Có các parameter là GroupName, Creator, array String[] usernames , CreateDate
//			Với mỗi username thì sẽ khởi tạo 1 Account (chỉ có thông tin username, các thông tin còn lại = null).
//			Khởi tạo 1 Object với mỗi constructor ở trên

		System.out.println("\n-- Question 3:");
		System.out.println("a) Hàm khởi tạo không tham số");
		Group gr1 = new Group();
		gr1.setGroupName("Nhóm 1");
		gr1.setCreator(account1);
		gr1.setCreateDate(createDate);
		gr1.setAccounts(new Account[] { account1, account2 });
		System.out.println(gr1);
		for (Account account : gr1.getAccounts()) {
			System.out.println(account.toString());
		}

		System.out.println("b) Hàm khởi tạo có tham số");
		Group gr2 = new Group("Nhóm 2", account1, accountArr, createDate);
		System.out.println(gr2);
		for (Account account : accountArr) {
			System.out.println(account.toString());
		}

		System.out.println("c) Hàm khởi tạo có tham số");
		String[] usernames = { "hung", "hung2", "hung3" };

		Group gr3 = new Group("Nhóm 3", account3, usernames, createDate);
		System.out.println(gr3.toString());
		for (Account account : gr3.getAccounts()) {
			System.out.println(account);
		}
	}
}
