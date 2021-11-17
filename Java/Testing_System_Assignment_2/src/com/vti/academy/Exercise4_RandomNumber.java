package com.vti.academy;
import java.time.LocalDate;
import java.util.Random;

public class Exercise4_RandomNumber {

	public static void main(String[] args) {
//		Question 1:
//			In ngẫu nhiên ra 1 số nguyên
		Question1();
		
//		Question 2:
//			In ngẫu nhiên ra 1 số thực
		Question2();
		
//		Question 3:
//			Khai báo 1 array bao gồm các tên của các bạn trong lớp, sau đó in ngẫu nhiên ra tên của 1 bạn
		
		Question3();
		
//		Question 4:
//			Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 24-07-1995 tới ngày 20-12-1995
		
		Question4();
		
//		Question 5:
//			Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 1 năm trở lại đây
		
		Question5();
		
//		Question 6:
//			Lấy ngẫu nhiên 1 ngày trong quá khứ
		
		Question6();
		
//		Question 7:
//			Lấy ngẫu nhiên 1 số có 3 chữ số
		
		Question7();
	}
	
//	các method
//	question1
	static void Question1() {
		System.out.println("Question 1: ");
		Random random = new Random();
		int x = random.nextInt();
		System.out.println("Số nguyên ngẫu nhiên là: " + x );
		System.out.println();
	}
	
//	question2
	static void Question2() {
		System.out.println("Question 2: ");
		Random random = new Random();
		float x = random.nextFloat();
		System.out.printf("Số thực ngẫu nhiên là: " + x );
		System.out.println();
		System.out.println();
	}
	
//	question3
	static void Question3() {
		System.out.println("Question 3: ");
		String[] a = {"Hoàng", "Duy", "Hùng", "Đức", "Thảo", "Thanh"};
		int length = a.length;
		Random random = new Random();
		int x = random.nextInt(length);
		System.out.println("In ngẫu nhiên tên 1 bạn: " + a[x]);
		System.out.println();
	}
	
//	question4
	static void Question4() {
		System.out.println("Question 4: ");
		Random random = new Random();
		int minDay = (int) LocalDate.of(1995,07,24).toEpochDay();
		int maxDay = (int) LocalDate.of(1995,12,20).toEpochDay();
		long randomInt = minDay + random.nextInt(maxDay - minDay);
		LocalDate randomDay = LocalDate.ofEpochDay(randomInt);
		System.out.println("Ngày ngẫu nhiên là: " + randomDay);
		System.out.println();
	}
	
//	question5
	static void Question5() {
		System.out.println("Question 5: ");
		Random random = new Random();
		int now = (int) LocalDate.now().toEpochDay();
		int randomDay =  now - random.nextInt(365);
		LocalDate resultRandomDay = LocalDate.ofEpochDay(randomDay);
		System.out.println("Ngày ngẫu nhiên trong 1 năm trở lại đây là: " + resultRandomDay);
		System.out.println();
	}
	
//	question6
	static void Question6() {
		System.out.println("Question 6: ");
		int maxDay = (int) LocalDate.now().toEpochDay();
		Random random = new Random();
		int randomDay = random.nextInt(maxDay);
		LocalDate result = LocalDate.ofEpochDay(randomDay);
		System.out.println("Ngày ngẫu nhiên trong quá khứ là: " + result);
		System.out.println();
	}
	
//	question7
	static void Question7() {
		System.out.println("Question 7: ");
		
		Random random = new Random();
		int result = random.nextInt(999-100+1) + 100;
		System.out.println("Số ngẫu nhiên có 3 chữ số là: " + result);
		System.out.println();
	}
}
