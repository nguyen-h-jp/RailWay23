package com.vti.academy;
import java.time.LocalDate;
import java.util.Random;

public class Exercise4_RandomNumber {

	public static void main(String[] args) {
//		question 1:
//			In ngẫu nhiên ra 1 số nguyên
//		question1();
		
//		question 2:
//			In ngẫu nhiên ra 1 số thực
//		question2();
		
//		question 3:
//			Khai báo 1 array bao gồm các tên của các bạn trong lớp, sau đó in ngẫu nhiên ra tên của 1 bạn
		
//		question3();
		
//		question 4:
//			Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 24-07-1995 tới ngày 20-12-1995
		
//		question4();
		
//		question 5:
//			Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 1 năm trở lại đây
		
//		question5();
		
//		question 6:
//			Lấy ngẫu nhiên 1 ngày trong quá khứ
		
//		question6();
		
//		question 7:
//			Lấy ngẫu nhiên 1 số có 3 chữ số
		
		question7();
	}
	
//	các method
//	question1
	static void question1() {
		System.out.println("question 1: ");
		Random random = new Random();
		int x = random.nextInt();
		System.out.println("Số nguyên ngẫu nhiên là: " + x );
		System.out.println();
	}
	
//	question2
	static void question2() {
		System.out.println("question 2: ");
		Random random = new Random();
		Double x = random.nextDouble();
		System.out.printf("Số thực ngẫu nhiên là: " + x );
		System.out.println();
		System.out.println();
	}
	
//	question3
	static void question3() {
		System.out.println("question 3: ");
		String[] memberArr = {"Hoàng", "Duy", "Hùng", "Đức", "Thảo", "Thanh"};
		//int length = memberArr.length; 6
		Random random = new Random();
		int x = random.nextInt(memberArr.length);
		System.out.println("In ngẫu nhiên tên 1 bạn: " + memberArr[x]); // 0 - 5
		System.out.println();
	}
	
//	question4
	static void question4() {
		System.out.println("question 4: ");
		Random random = new Random();
		int minDay = (int) LocalDate.of(1995,07,24).toEpochDay();
		int maxDay = (int) LocalDate.of(1995,07,25).toEpochDay();
		long randomInt = minDay - random.nextInt(maxDay - minDay + 1);
		LocalDate randomDay = LocalDate.ofEpochDay(randomInt);
		System.out.println("Ngày ngẫu nhiên là: " + randomDay);
		System.out.println();
	}
	
//	question5
	static void question5() {
		System.out.println("question 5: ");
		Random random = new Random();
		int now = (int) LocalDate.now().toEpochDay();
		int randomDay =  now - random.nextInt(365 + 1); 
		LocalDate resultRandomDay = LocalDate.ofEpochDay(randomDay);
		System.out.println("Ngày ngẫu nhiên trong 1 năm trở lại đây là: " + resultRandomDay);
		System.out.println();
	}
	
//	question6
	static void question6() {
		System.out.println("question 6: ");
		int maxDay = (int) LocalDate.now().toEpochDay();
//		int minDay = (int) LocalDate.now().toEpochDay();
		Random random = new Random();
		int randomDay = random.nextInt(maxDay);
		LocalDate result = LocalDate.ofEpochDay(randomDay);
		System.out.println("Ngày ngẫu nhiên trong quá khứ là: " + result);
		System.out.println();
	}
	
//	question7
	static void question7() {
		System.out.println("question 7: ");
		Random random = new Random();
		int result = random.nextInt(999-100+1) + 100;
		System.out.println("Số ngẫu nhiên có 3 chữ số là: " + result);
		System.out.println();
	}
}
