package com.vti.academy;

public class Exercise3_BoxingUnboxing {

	public static void main(String[] args) {
//		Question1();
//		Question2();
		Question3();
	}
//	Question 1:
//		Khởi tạo lương có datatype là Integer có giá trị bằng 5000.
//		Sau đó convert lương ra float và hiển thị lương lên màn hình (với số float có 2 số sau dấu thập phân)
	
	static void Question1() {
		Integer salary = Integer.valueOf(5000);
		float floatSalary = salary;
		System.out.printf("%.2f", floatSalary);
	}
	
//	Question 2:
//		Khai báo 1 String có value = "1234567"
//		Hãy convert String đó ra số int
	
	static void Question2() {
		String value = "1234567";
		int intValue = Integer.valueOf(value);
		System.out.printf("%d", intValue);
	}
	
//	Question 3:
//		Khởi tạo 1 số Integer có value là chữ "1234567"
//		Sau đó convert số trên thành datatype int

	static void Question3() {
		Integer value = Integer.valueOf("1234567");
		int intValue = value.intValue();
		System.out.printf("%d", intValue);
	}		
}
