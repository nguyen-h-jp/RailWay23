package com.vti.academy;

import java.time.LocalDate;

import com.vti.academy.enums.PositionName;

public class Exercise6_Method {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Department
		Department department1 = new Department();
		department1.departmentID = 1;
		department1.departmentName = "Sales";
		Department department2 = new Department();
		department2.departmentID = 2;
		department2.departmentName = "Marketing";
		Department department3 = new Department();
		department3.departmentID = 3;
		department3.departmentName = "Bảo vệ";
		
		// Position
		Position position1 = new Position();
		position1.positionID = 1;
		position1.positionName = PositionName.DEV.getPositionName();
				
		Position position2 = new Position();
		position2.positionID = 2;
		position2.positionName = PositionName.TEST.getPositionName();
				
		Position position3 = new Position();
		position3.positionID = 3;
		position3.positionName = PositionName.SCRUM_MASTER.getPositionName();
				
		Position position4 = new Position();
		position4.positionID = 4;
		position4.positionName = PositionName.PM.getPositionName();
			
		//Tao truoc group
		Group group1 = new Group();
		group1.groupID = 1;
		group1.groupName = "Nhóm 1";
				
		Group group2 = new Group();
		group2.groupID = 2;
		group2.groupName = "Nhóm 2";
				
		Group group3 = new Group();
		group3.groupID = 3;
		group3.groupName = "Nhóm 3";
		
		//Account
		Account account1 = new Account();
		account1.accountID = 1;
		account1.email = "nguyenvana@gmail.com";
		account1.userName = "a_nguyenvan";
		account1.fullName = "Nguyễn Văn A";
		account1.department = department1;
		account1.position = position1;
		account1.createDate = LocalDate.now();
		account1.groups = new  Group[] {group1, group3};
				
		Account account2 = new Account();
		account2.accountID = 2;
		account2.email = "nguyenvanb@gmail.com";
		account2.userName = "b_nguyenvan";
		account2.fullName = "Nguyễn Văn B";
		account2.department = department2;
		account2.position = position2;
		account2.createDate = LocalDate.now();
		account2.groups = new  Group[] {group1, group2, group3};
		
		Account account3 = new Account();
		account3.accountID = 3;
		account3.email = "nguyenvanc@gmail.com";
		account3.userName = "c_nguyenvan";
		account3.fullName = "Nguyễn Văn C";
		account3.department = department3;
		account3.position = position3;
		account3.createDate = LocalDate.now();
		account3.groups = new  Group[] {group1, group2};
		
		Account account4 = new Account();
		account4.accountID = 4;
		account4.email = "nguyenvand@gmail.com";
		account4.userName = "d_nguyenvan";
		account4.fullName = "Nguyễn Văn d";
		account4.department = department3;
		account4.position = position3;
		account4.createDate = LocalDate.now();
		account4.groups = new  Group[] {group1, group2};
		
		Account account5 = new Account();
		account5.accountID = 5;
		account5.email = "nguyenvane@gmail.com";
		account5.userName = "e_nguyenvan";
		account5.fullName = "Nguyễn Văn e";
		account5.department = department3;
		account5.position = position3;
		account5.createDate = LocalDate.now();
		account5.groups = new  Group[] {group1, group2};
		
		// add account to group
		group1.accounts = new Account[] {account1, account2, account3};
		group2.accounts = new Account[] {account2, account3};
		group3.accounts = new Account[] {account1, account2};

		// create list of all accounts
		Account[] accountArray = {account1, account2, account3, account4, account5};
		
		// create list of all department
		Department[] departmentList = {department1, department2, department3};
		// create lis of all groups 
		Group[] groupArray = {group1, group2, group3};
		
//		Question1();
//		Question2(account1);
		Question3();
		
	}
	
//	Question 1:
//		Tạo method để in ra các số chẵn nguyên dương nhỏ hơn 10
	
	static void Question1() {
		for(int i = 1; i < 10; i++) {
			if(i % 2 == 0) {
				System.out.println(i);
			}
		}
	}
	
//	Question 2: Tạo method để in thông tin (của ?) các account
	
	static void Question2(Account acc) {
		System.out.println("Thông tin account: ");
		System.out.println("Id: " + acc.accountID);
		System.out.println("Email: " + acc.email);
		System.out.println("FullName: " + acc.fullName);
		System.out.println("UserName: " + acc.userName);
		System.out.println("CreateDate: " + acc.createDate);
	}

//	Question 3:
//		Tạo method để in ra các số nguyên dương nhỏ hơn 10
	
	static void Question3() {
		for(int i = 1; i < 10; i++) {
			System.out.println(i);
		}
	}
}
