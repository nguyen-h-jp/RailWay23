package com.vti.academy;

import java.util.Scanner;

public class Exercise3_BoxingUnboxing {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Question 1");
		question1();
		System.out.println();
		System.out.println("Question 2");
		question2();
		System.out.println();
		System.out.println("Question 3");
		question3();
		sc.close();
	}
//	question 1:
//		Khởi tạo lương có datatype là Integer có giá trị bằng 5000.
//		Sau đó convert lương ra float và hiển thị lương lên màn hình (với số float có 2 số sau dấu thập phân)
	
	static void question1() {
		Integer salary = Integer.valueOf(5000);
		float floatSalary = salary;
		System.out.printf("%.2f", floatSalary);
	}
	
//	question 2:
//		Khai báo 1 String có value = "1234567"
//		Hãy convert String đó ra số int
	
	static void question2() {
		String value = "1234567";
		int intValue = Integer.valueOf(value);
//		int intValue = Integer.parseInt(value);
		System.out.printf("%d", intValue);
	}
	
//	question 3:
//		Khởi tạo 1 số Integer có value là chữ "1234567"
//		Sau đó convert số trên thành datatype int

	static void question3() {
		Integer value = Integer.parseInt("1234567");
		int intValue = value.intValue();
		System.out.printf("%d", intValue);
	}		
}
