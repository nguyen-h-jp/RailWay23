package com.vti.academy;

import java.time.LocalDate;

public class Exercise2_DefaultValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question1();
	}
	
//	Question 1:
//		Không sử dụng data đã insert từ bài trước, tạo 1 array Account và khởi tạo 5 phần tử theo cú pháp (sử dụng vòng for để khởi tạo):
//		 Email: "Email 1"
//		 Username: "User name 1"
//		 FullName: "Full name 1"
//		 CreateDate: now

	static void Question1() {
		Account[] accountArray = new Account[5];
	
		for(int i = 0; i < 5; i++) {
			accountArray[i] = new Account();
			accountArray[i].email = "Email " + (i + 1);
			accountArray[i].userName = "User Name " + (i + 1);
			accountArray[i].fullName = "Full Name " + (i + 1);
			accountArray[i].createDate = LocalDate.now();
		}
		
		for(Account acc : accountArray) {
			System.out.println("Email: " + acc.email + ", UserName: " + acc.userName + ", FullName: " + acc.fullName + ", CreateDate: " + acc.createDate);
		}
	}
}
