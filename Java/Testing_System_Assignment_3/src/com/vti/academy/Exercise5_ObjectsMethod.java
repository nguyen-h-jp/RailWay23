package com.vti.academy;

public class Exercise5_ObjectsMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Department
		Department department1 = new Department();
		department1.departmentID = 1;
		department1.departmentName = "Accounting";
		Department department2 = new Department();
		department2.departmentID = 2;
		department2.departmentName = "Boss of director";
		Department department3 = new Department();
		department3.departmentID = 3;
		department3.departmentName = "Marketing";
		Department department4 = new Department();
		department4.departmentID = 4;
		department4.departmentName = "waiting room";
		Department department5 = new Department();
		department5.departmentID = 5;
		department5.departmentName = "Sale";
		Department department6 = new Department();
		department6.departmentID = 6;
		department6.departmentName = "Phòng A";
		Department[] departmentArr = { department1, department2, department3, department4, department5, department6 };
//		question1(departmentArr);
//		question2(departmentArr);
//		question3(departmentArr);
//		question4(departmentArr);
//		question5(departmentArr);
//		question6(departmentArr);
		question7(departmentArr);

	}

	/*
	 * Question 1: In ra thông tin của phòng ban thứ 1 (sử dụng toString())
	 */
	static void question1(Department[] departmentArr) {
		System.out.println(departmentArr[0].toString());
	}

	/*
	 * Question 2: In ra thông tin của tất cả phòng ban (sử dụng toString())
	 */
	static void question2(Department[] departmentArr) {
		for (Department department : departmentArr) {
			System.out.println(department.toString());
		}
	}

	/*
	 * Question 3: In ra địa chỉ của phòng ban thứ 1
	 */

	static void question3(Department[] departmentArr) {
		System.out.println(departmentArr[0].hashCode());
	}

	/*
	 * Question 4: Kiểm tra xem phòng ban thứ 1 có tên là "Phòng A" không?
	 */

	static void question4(Department[] departmentArr) {
		if (departmentArr[0].departmentName.equals("Phòng A")) {
			System.out.println("Có");
		} else {
			System.out.println("Không");
		}
	}

	/*
	 * Question 5: So sánh 2 phòng ban thứ 1 và phòng ban thứ 2 xem có bằng nhau
	 * không (bằng nhau khi tên của 2 phòng ban đó bằng nhau)
	 */
	static void question5(Department[] departmentArr) {
		if (departmentArr[0].departmentName.equals(departmentArr[1].departmentName)) {
			System.out.println("Có");
		} else {
			System.out.println("Không");
		}
	}

	/*
	 * Question 6: Khởi tạo 1 array phòng ban gồm 5 phòng ban, sau đó in ra danh
	 * sách phòng ban theo thứ tự tăng dần theo tên (sắp xếp theo vần ABCD) VD:
	 * Accounting 
	 * Boss of director 
	 * Marketing 
	 * Sale 
	 * Waiting room
	 */
	
	static void question6(Department[] departmentArr) {
		for (int i = 0; i < departmentArr.length; i++) {
			for(int j = 0; j < departmentArr.length; j++){
				if(departmentArr[i].departmentName.compareToIgnoreCase(departmentArr[j].departmentName) < 0) {
					Department temp = departmentArr[i];
					departmentArr[i] = departmentArr[j];
					departmentArr[j] = temp;
				}	
			}
		}
		for(int i = 0; i < departmentArr.length; i++) {
			System.out.println(departmentArr[i]);
		}
	}
	
	/*
	 * Question 7: Khởi tạo 1 array học sinh gồm 5 Phòng ban, 
	 * sau đó in ra danh sách phòng ban được sắp xếp theo tên 
	 * VD: 
	 * Accounting 
	 * Boss of director 
	 * Marketing
	 * waiting room 
	 * Sale
	 */
	
	static void question7(Department[] departmentArr) {
		for (int i = 0; i < departmentArr.length; i++) {
			for(int j = 0; j < departmentArr.length; j++){
				String[] stringArray1 = departmentArr[i].departmentName.split(" ");
				String[] stringArray2 = departmentArr[j].departmentName.split(" ");
				if(stringArray1[stringArray1.length - 1].compareToIgnoreCase(stringArray2[stringArray2.length - 1]) < 0) {
					Department temp = departmentArr[i];
					departmentArr[i] = departmentArr[j];
					departmentArr[j] = temp;
				}	
			}
		}
		for(int i = 0; i < departmentArr.length; i++) {
			System.out.println(departmentArr[i]);
		}
	}
}
/*//	static void reverse(Department [] departmentArr, int n) {
//		String [] temp = new String [n];
//		int j = n;
//		for (int i = 0; i < n; i++) {
//			temp [j - 1] = departmentArr[i].departmentName;
//			j--;	
//		}
//		for (String string : temp) {
//			System.out.println(string);
//		}
//	}
//	
//	static void question7(Department[] departmentArr) {
//		for (Department department : departmentArr) {
//			reverse(department.departmentName, departmentArr.length);
//			System.out.println(department);
//		}
*/	