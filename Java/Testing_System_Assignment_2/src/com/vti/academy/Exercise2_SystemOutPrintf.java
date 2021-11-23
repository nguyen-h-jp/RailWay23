package com.vti.academy;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

import com.vti.academy.enums.PositionName;

public class Exercise2_SystemOutPrintf {

	public static void main(String[] args) {
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

//		Question 1:
//			Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in ra số nguyên đó
		
//		Question1();
		
//		Question 2:
//			Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out printf để in ra số nguyên đó thành định dạng như sau: 100,000,000
		
//		Question2();
		
//		Question 3:
//			Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf để in ra số thực đó chỉ bao gồm 4 số đằng sau
		
//		Question3();
		
//		Question 4:
//			Khai báo Họ và tên của 1 học sinh và in ra họ và tên học sinh đó theo định dạng như sau:
//			Họ và tên: "Nguyễn Văn A" thì sẽ in ra trên console như sau:
//			Tên tôi là "Nguyễn Văn A" và tôi đang độc thân.
		
//		Question4();
		
//		Question 5:
//			Lấy thời gian bây giờ và in ra theo định dạng sau:
//			24/04/2020 11h:16p:20s
		
		Question5();
		
//		Question 6:
//			In ra thông tin account (như Question 8 phần FOREACH) theo định dạng table (giống trong Database)
		
		Question6(accountArray);	
	}
	
//	cac method
	
//	question 1
	
	static void Question1() {
		System.out.println("Question 1: ");
		int i = 5;
		System.out.printf("%d %n", i);
		System.out.println();
	}
	
//	question 2
	
	static void Question2() {
		System.out.println("Question 2: ");
		int i = 100000000;
		System.out.printf(Locale.US, "%,d%n", i);
		System.out.println();
	}
	
//	question 3
	
	static void Question3() {
		System.out.println("Question 3: ");
		double i = 5.567098;
		System.out.printf("%.4f%n", i);
		System.out.println();
	}
	
//	question 4
	
	static void Question4() {
		System.out.println("Question 4: ");
		String s = "Nguyễn Văn A";
		System.out.printf("Tôi tên là: %s%n", s);
		System.out.println();
	}
	
	
//	Question 5:
//	Lấy thời gian bây giờ và in ra theo định dạng sau:
//	24/04/2020 11h:16p:20s
//	question 5
//	 HH:mm:ss:SS
	static void Question5() {
		System.out.println("Question 5: ");
		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH");
		SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("mm");
		SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("ss");
		String date1 = simpleDateFormat1.format(new Date());
		String date2 = simpleDateFormat2.format(new Date());
		String date3 = simpleDateFormat3.format(new Date());
		String date4 = simpleDateFormat4.format(new Date());
		System.out.println(date1);
		System.out.println(date2);
		System.out.println(date3);
		System.out.println(date4);
//		System.out.println(simpleDateFormat1);
		System.out.printf("%s %sh:%sp:%ss",date1,date2,date3,date4);
		System.out.println();
	}
	
//	question 6
	
	static void Question6(Account[] acc) {
		System.out.println("Question 6: ");
		for(Account ac: acc) {
			System.out.printf("%s%15s%15s%n", ac.email, ac.fullName, ac.position.positionName);
		}
		System.out.println();
	}
}

