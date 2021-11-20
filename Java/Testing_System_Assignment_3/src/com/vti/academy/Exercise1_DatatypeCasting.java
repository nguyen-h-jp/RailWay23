package com.vti.academy;

import java.util.Random;
import java.util.Scanner;

public class Exercise1_DatatypeCasting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Question1();
//		Question2();
//		Question3();
		Question4();
	}
	
//	Exercise 1 (Optional): Datatype Casting
//	Question 1:
//	Khai báo 2 số lương có kiểu dữ liệu là float.
//	Khởi tạo Lương của Account 1 là 5240.5 $
//	Khởi tạo Lương của Account 2 là 10970.055$
//	Khai báo 1 số int để làm tròn Lương của Account 1 và in số int đó ra
//	Khai báo 1 số int để làm tròn Lương của Account 2 và in số int đó ra
	
	static void Question1() {
		float salary1;
		float salary2;
		salary1 = (float) 5240.5;
		salary2 = (float) 10970.055;
		int intSalary1 = (int) salary1;
		int intSalary2 = (int) salary2;
		System.out.println(intSalary1 +  " " + intSalary2);	
	}
	
//	Question 2:
//		Lấy ngẫu nhiên 1 số có 5 chữ số (những số dưới 5 chữ số thì sẽ thêm có số 0 ở đầu cho đủ 5 chữ số)
	static void Question2() {
		Random random = new Random();
        int num = random.nextInt(100000);
        String result = String.format("%05d", num);
        System.out.println(result);
	}
	
//	Question 3:
//		Lấy 2 số cuối của số ở Question 2 và in ra.
//		Gợi ý:
//		Cách 1: convert số có 5 chữ số ra String, sau đó lấy 2 số cuối
//		Cách 2: chia lấy dư số đó cho 100
	static void Question3() {
		Random random = new Random();
        int num = random.nextInt(100000);
        String result = String.format("%05d", num);
        System.out.println(result);
        System.out.printf("%s%s",result.charAt(3),result.charAt(4));
	}
	
//	Question 4:
//		Viết 1 method nhập vào 2 số nguyên a và b và trả về thương của chúng
	
	static int Question4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào a: ");
		int a = sc.nextInt();
		System.out.println("Nhập vào b: ");
		int b = sc.nextInt();
		int result;
		result = a / b;
		System.out.println("a / b = " + result);
		return result;
	}
}
