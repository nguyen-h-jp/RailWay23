package com.vti.academy;

import java.time.LocalDate;
import java.util.Scanner;

public class Exercise5_InputFromConsole {

	public static void main(String[] args) {
//		Question 1:
//			Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình
		
//		Question1();
		
//		Question 2:
//			Viết lệnh cho phép người dùng nhập 2 số thực vào chương trình
		
//		Question2();
		
//		Question 3:
//			Viết lệnh cho phép người dùng nhập họ và tên
		
//		Question3();
		
//		Question 4:
//			Viết lệnh cho phép người dùng nhập vào ngày sinh nhật của họ
		
		Question4();	
	}
//	các method
//	question 1
	static void Question1() {
		System.out.println("Question 1: ");
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào số nguyên thứ 1: ");
		int a = sc.nextInt();
		System.out.println("Nhập vào số nguyên thứ 2: ");
		int b = sc.nextInt();
		System.out.println("Nhập vào số nguyên thứ 3: ");
		int c = sc.nextInt();
		System.out.println("Các số vừa nhập: " + a + ", " + b + ", " + c);
		sc.close();
		System.out.println();
	}
	
//	question 2
	static void Question2() {
		System.out.println("Question 2: ");
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào số thực thứ 1: ");
		float a = sc.nextFloat();
		System.out.println("Nhập vào số thực thứ 2: ");
		float b = sc.nextFloat();
		System.out.println("Nhập vào số thực thứ 3: ");
		float c = sc.nextFloat();
		System.out.println("Các số vừa nhập: " + a + ", " + b + ", " + c);
		sc.close();
		System.out.println();
	}
	
//	question 3
	static void Question3() {
		System.out.println("Question 3: ");
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào họ và tên: ");
		String a = sc.nextLine();
		System.out.println("Họ và tên vừa nhập: " + a);
		sc.close();
		System.out.println();
	}
	
//	question 4
	static void Question4() {
		System.out.println("Question 4: ");
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào ngày sinh: ");
		int day = sc.nextInt();
		System.out.println("Nhập vào tháng sinh: ");
		int month = sc.nextInt();
		System.out.println("Nhập vào năm sinh: ");
		int year = sc.nextInt();
		LocalDate birthDay = LocalDate.of(year, month, day);
		System.out.println("Ngày sinh của bạn là: " + birthDay);
		sc.close();
		System.out.println();
	}
	
	

}
