package com.vti.academy;

import java.time.LocalDate;

import com.vti.academy.enums.PositionName;

public class Exersice1_FlowControl {
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
		
		// create list of all department
		Department[] departmentList = {department1, department2, department3};
		
		
//		IF
//		Question 1:
//		Kiểm tra account thứ 2
//		Nếu không có phòng ban (tức là department == null) thì sẽ in ra text "Nhân viên này chưa có phòng ban"
//		Nếu không thì sẽ in ra text "Phòng ban của nhân viên này là …"
		
		Question1(account1);
		
//		Question 2:
//			Kiểm tra account thứ 2
//			Nếu không có group thì sẽ in ra text "Nhân viên này chưa có group"
//			Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra text "Group của nhân viên này là Java Fresher, C# Fresher"
//			Nếu có mặt trong 3 Group thì sẽ in ra text "Nhân viên này là người quan trọng, tham gia nhiều group"
//			Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên này là người hóng chuyện, tham gia tất cả các group"
		
		Question2(account2);
		
//		Question 3:
//			Sử dụng toán tử ternary để làm Question 1
		
		Question3(account2);
		
//		Question 4:
//			Sử dụng toán tử ternary để làm yêu cầu sau:
//			Kiểm tra Position của account thứ 1
//			Nếu Position = Dev thì in ra text "Đây là Developer"
//			Nếu không phải thì in ra text "Người này không phải là Developer"
		
		Question4(account1);
		
//		SWITCH CASE
//		Question 5:
//		Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format sau:
//		Nếu số lượng account = 1 thì in ra "Nhóm có một thành viên"
//		Nếu số lượng account = 2 thì in ra "Nhóm có hai thành viên"
//		Nếu số lượng account = 3 thì in ra "Nhóm có ba thành viên"
//		Còn lại in ra "Nhóm có nhiều thành viên"
		
		Question5(group1);
		
//		Question 6:
//			Sử dụng switch case để làm lại Question 2
		
		Question6(account1);
		
//		Question 7:
//			Sử dụng switch case để làm lại Question 4
		
		Question7(account1);
		
//		FOREACH
//		Question 8:
//		In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ
		
		Question8(accountArray);
		
//		Question 9:
//			In ra thông tin các phòng ban bao gồm: id và name
		
		Question9(departmentList);
		
//		FOR
//		Question 10:
//		In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ theo định dạng như sau:
//		Thông tin account thứ 1 là:
//		Email: NguyenVanA@gmail.com
//		Full name: Nguyễn Văn A
//		Phòng ban: Sale
//		Thông tin account thứ 2 là:
//		Email: NguyenVanB@gmail.com
//		Full name: Nguyễn Văn B
//		Phòng ban: Marketting
		
		Question10(accountArray);
		
//		Question 11:
//			In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau:
//			Thông tin department thứ 1 là:
//			Id: 1
//			Name: Sale
//			Thông tin department thứ 2 là:
//			Id: 2
//			Name: Marketing
		
		Question11(departmentList);
		
//		Question 12:
//			Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10
		
		Question12(accountArray);
		
//		Question 13:
//			In ra thông tin tất cả các account ngoại trừ account thứ 2
		
		Question13(accountArray);
		
//		Question 14:
//			In ra thông tin tất cả các account có id < 4
		
		Question14(accountArray);
		
//		Question 15:
//			In ra các số chẵn nhỏ hơn hoặc bằng 20
		
		Question15();	
		
//		WHILE
//		Question 16:
//		Làm lại các Question ở phần FOR bằng cách sử dụng WHILE kết hợp với lệnh break, continue
		
		Question1610ByWhile(accountArray);
		Question1611ByWhile(departmentList);
		Question1612ByWhile(accountArray);
		Question1613ByWhile(accountArray);
		Question1614ByWhile(accountArray);
		Question1615ByWhile();
		
//		DO WHILE
//		Question 17:
//		Làm lại các Question ở phần FOR bằng cách sử dụng DO WHILE kết hợp với lệnh break, continue
		Question1710ByDoWhile(accountArray);
		Question1711ByDoWhile(departmentList);
		Question1712ByDoWhile(accountArray);
		Question1713ByDoWhile(accountArray);
		Question1714ByDoWhile(accountArray);
		Question1715ByDoWhile();
	}
	
//	tao cac method
	
//	question 1
	static void Question1(Account acc) {
		System.out.println("Question 1: ");
		System.out.println();
		if (acc.department == null) {
			System.out.println("Nhân viên này chưa có phòng ban");
		} else {
			System.out.println("Phòng ban của nhân viên này là: " + acc.department.departmentName);
		}
		System.out.println();
	}
//	question 2 
	static void Question2(Account acc) {
		System.out.println("Question 2: ");
		System.out.println();
		int countGroupOfAccount2 = acc.groups == null ? 0 : acc.groups.length;

		if (countGroupOfAccount2 == 0) {
			System.out.println("Nhân viên này chưa có group");
		} else if (countGroupOfAccount2 == 1) {
			System.out.println("Group của nhân viên này là: " + acc.groups[0].groupName);
		} else if (countGroupOfAccount2 == 2) {
			System.out.println("Group của nhân viên này là: " + acc.groups[0].groupName + ", " + acc.groups[1].groupName);
		} else if (countGroupOfAccount2 == 3) {
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
		} else {
			System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
		}
		System.out.println();
	}
	
//	question 3
	static void Question3(Account acc) {
		System.out.println("Question 3: ");
		System.out.println();
		System.out.println(acc.department == null ? "Nhân viên này chưa có phòng ban" : "Phòng ban của nhân viên này là: " + acc.department.departmentName);
		System.out.println();
	}
	
//	question 4
	static void Question4(Account  acc) {
		System.out.println("Question 4: ");
		System.out.println();
		System.out.println(acc.position.positionName == "Dev" ? "Đây là Developer" : "Người này không phải Developer");
		System.out.println();
	}
	

//	question 5
	static void Question5(Group acc) {
		System.out.println("Question 5: ");
		System.out.println();
		int countAccountInGroup = acc.accounts == null ? 0 : acc.accounts.length;
		
		switch(countAccountInGroup){
			case 1: System.out.println("Nhóm có một thành viên");
			break;
			case 2: System.out.println("Nhóm có hai thành viên");
			break;
			case 3: System.out.println("Nhóm có ba thành viên");
			break;
			default: System.out.println("Nhóm có nhiều thành viên hoặc không có thành viên");
			break;
		}
		System.out.println();
	}
	
//	question 6
	static void Question6(Account acc) {
		System.out.println("Question 6: ");
		System.out.println();
		int countGroupOfAccount2 = acc.groups == null ? 0 : acc.groups.length;

		switch(countGroupOfAccount2) {
			case 0: System.out.println("Nhân viên này chưa có group");
			break;
			case 1: System.out.println("Group của nhân viên này là: " + acc.groups[0].groupName);
			break;
			case 2: System.out.println("Group của nhân viên này là: " + acc.groups[0].groupName + ", " + acc.groups[1].groupName);
			break;
			case 3: System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
			break;
			default : System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
			break;
		}
		System.out.println();
	}
	
//	question 7
	static void Question7(Account acc) {
		System.out.println("Question 7: ");
		System.out.println();
		String account1PositionName = acc.position.positionName;
		
		switch(account1PositionName) {
			case "Dev": System.out.println("Đây là Developer");
			break;
			default : System.out.println("Người này không phải Developer");
			break;
		}
		System.out.println();
	}
	
//	question 8
	static void Question8(Account[] acc) {
		System.out.println("Question 8: ");
		System.out.println();
		for(Account ac: acc) {
			System.out.println(ac.email + ", " + ac.fullName + ", " + ac.position.positionName);
		}
		System.out.println();
	}
	
//	question 9
	static void Question9(Department[] dp) {
		System.out.println("Question 9: ");
		System.out.println();
		for(Department d : dp) {
			System.out.println(d.departmentID + ", " + d.departmentName);
		}
		System.out.println();
	}
	
//	question 10
	static void Question10(Account[] arr) {
		System.out.println("Question 10: ");
		System.out.println();
		for(int i = 0; i < arr.length; ++i) {
			System.out.println("Thông tin tài khoản thứ " + (i + 1) + " là:");
			System.out.println("Email: " + arr[i].email + "\nFull name: "  + arr[i].fullName + "\nPhòng ban: " + arr[i].department.departmentName);
		}
		System.out.println();
	}
	
//	question 11
	static void Question11(Department[] dp) {
		System.out.println("Question 11: ");
		System.out.println();
		for(int i = 0; i < dp.length; ++i) {
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("\tId: " + dp[i].departmentID + "\n\tName: " + dp[i].departmentName);
		}
		System.out.println();
	}
	
//	question 12
	static void Question12(Account[] arr) {
		System.out.println("Question 12: ");
		System.out.println();
		for(int i = 0; i < 2; ++i) {
			System.out.println("Thông tin tài khoản thứ " + (i + 1) + " là:");
			System.out.println("Email: " + arr[i].email + "\nFull name: "  + arr[i].fullName + "\nPhòng ban: " + arr[i].department.departmentName);
		}
		System.out.println();
	}
	
//	question 13
	static void Question13(Account[] arr) {
		System.out.println("Question 13: ");
		System.out.println();
		for(int i = 0; i < arr.length; ++i) {
			if(i != 1) {
				System.out.println("Thông tin tài khoản thứ " + (i + 1) + " là:");
				System.out.println("Email: " + arr[i].email + "\nFull name: "  + arr[i].fullName + "\nPhòng ban: " + arr[i].department.departmentName);
			}	
		}
		System.out.println();
	}
	
//	question 14
	static void Question14(Account[] arr) {
		System.out.println("Question 14: ");
		System.out.println();
		for(int i = 0; i <= arr.length; ++i) {
			if(i == 4) {
				break;
			}
			System.out.println("Thông tin tài khoản thứ " + (i + 1) + " là:");
			System.out.println("Email: " + arr[i].email + "\nFull name: "  + arr[i].fullName + "\nPhòng ban: " + arr[i].department.departmentName);
		}
		System.out.println();
	}
	
//	question 15
	static void Question15() {
		System.out.println("Question 15: ");
		System.out.println();
		for (int i = 0; i <= 20; ++i) {
			if(i % 2 == 0) {
				System.out.println(i);
			}
		}
		System.out.println();
	}
	
//	question 16
	static void Question1610ByWhile(Account[] arr) {
		System.out.println("Question 10 by While: ");
		System.out.println();
		int i = 0;
		while(i < arr.length) { 
			System.out.println("Thông tin tài khoản thứ " + (i + 1) + " là:");
			System.out.println("Email: " + arr[i].email + "\nFull name: "  + arr[i].fullName + "\nPhòng ban: " + arr[i].department.departmentName);
			++i;
		}
		System.out.println();
	}
	
	static void Question1611ByWhile(Department[] arr) {
		System.out.println("Question 11 by While: ");
		System.out.println();
		int i = 0;
		while (i < arr.length) {
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("Id: " + arr[i].departmentID + "\nName: " + arr[i].departmentName);
			++i;
		}
		System.out.println();
	}
	
	static void Question1612ByWhile(Account[] arr) {
		System.out.println("Question 12 by While: ");
		System.out.println();
		int i = 0; 
		while (i < 2) {
			System.out.println("Thông tin tài khoản thứ " + (i + 1) + " là:");
			System.out.println("Email: " + arr[i].email + "\nFull name: "  + arr[i].fullName + "\nPhòng ban: " + arr[i].department.departmentName);
			++i;
		}
		System.out.println();
	}
	
	static void Question1613ByWhile(Account[] arr) {
		System.out.println("Question 13 by While: ");
		System.out.println();
		int i = 0; 
		while (i < arr.length) {
			if (i != 1) {
				System.out.println("Thông tin tài khoản thứ " + (i + 1) + " là:");
				System.out.println("Email: " + arr[i].email + "\nFull name: "  + arr[i].fullName + "\nPhòng ban: " + arr[i].department.departmentName);
			}
			++i;	
		}
		System.out.println();
	}
	
	static void Question1614ByWhile(Account[] arr) {
		System.out.println("Question 14 by While: ");
		System.out.println();
		int i = 0;
		while (i < 4) {
			System.out.println("Thông tin tài khoản thứ " + (i + 1) + " là:");
			System.out.println("Email: " + arr[i].email + "\nFull name: "  + arr[i].fullName + "\nPhòng ban: " + arr[i].department.departmentName);
			++i;
		}
		System.out.println();
	}
	
	static void Question1615ByWhile() {
		System.out.println("Question 15 by While: ");
		System.out.println();
		int i = 0;
		while (i <= 20) {
			if(i % 2 == 0) {
				System.out.println(i);
			}
			++i;
		}
		System.out.println();
	}
	
	
	
	
//	question 17
	static void Question1710ByDoWhile(Account[] arr) {
		System.out.println("Question 10 by Do While: ");
		System.out.println();
		int i = 0;
		do { 
			System.out.println("Thông tin tài khoản thứ " + (i + 1) + " là:");
			System.out.println("Email: " + arr[i].email + "\nFull name: "  + arr[i].fullName + "\nPhòng ban: " + arr[i].department.departmentName);
			++i;
		}while(i < arr.length);
		System.out.println();
	}
	
	static void Question1711ByDoWhile(Department[] arr) {
		System.out.println("Question 11 by Do While: ");
		System.out.println();
		int i = 0;
		 do {
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("Id: " + arr[i].departmentID + "\nName: " + arr[i].departmentName);
			++i;
		}while (i < arr.length);
		System.out.println();
	}
	
	static void Question1712ByDoWhile(Account[] arr) {
		System.out.println("Question 12 by Do While: ");
		System.out.println();
		int i = 0; 
		 do {
			System.out.println("Thông tin tài khoản thứ " + (i + 1) + " là:");
			System.out.println("Email: " + arr[i].email + "\nFull name: "  + arr[i].fullName + "\nPhòng ban: " + arr[i].department.departmentName);
			++i;
		}while (i < 2);
		 System.out.println();
	}
	
	static void Question1713ByDoWhile(Account[] arr) {
		System.out.println("Question 13 by Do While: ");
		System.out.println();
		int i = 0; 
		 do {
			if (i != 1) {
				System.out.println("Thông tin tài khoản thứ " + (i + 1) + " là:");
				System.out.println("Email: " + arr[i].email + "\nFull name: "  + arr[i].fullName + "\nPhòng ban: " + arr[i].department.departmentName);
			}
			++i;	
		}while (i < arr.length);
		System.out.println();
	}
	
	static void Question1714ByDoWhile(Account[] arr) {
		System.out.println("Question 14 by Do While: ");
		System.out.println();
		int i = 0;
		do {
			System.out.println("Thông tin tài khoản thứ " + (i + 1) + " là:");
			System.out.println("Email: " + arr[i].email + "\nFull name: "  + arr[i].fullName + "\nPhòng ban: " + arr[i].department.departmentName);
			++i;
		}while (i < 4);
		System.out.println();
	}
	
	static void Question1715ByDoWhile() {
		System.out.println("Question 15 by Do While: ");
		System.out.println();
		int i = 0;
		do {
			if(i % 2 == 0) {
				System.out.println(i);
			}
			++i;
		}while (i <= 20);
		System.out.println();
	}
	
}