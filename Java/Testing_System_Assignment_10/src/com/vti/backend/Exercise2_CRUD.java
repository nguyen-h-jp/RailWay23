package com.vti.backend;

import java.sql.SQLException;
import java.util.Scanner;

public class Exercise2_CRUD {
	public void question1() throws ClassNotFoundException, SQLException {
		System.out.println(DepartmentDao.getDepartments());
	}

	public void question2_3(Scanner sc) throws ClassNotFoundException, SQLException {

		System.out.println("Nhập vào id của department cần tìm");
		int inputNumber = sc.nextInt();
		sc.nextLine();
		if (DepartmentDao.getDepartmentByID(inputNumber).size() == 0) {
			System.out.println("Không tồn tại department có id là: " + inputNumber);
		} else {
			System.out.println(DepartmentDao.getDepartmentByID(inputNumber));
		}
	}

	public void question4(Scanner sc) throws ClassNotFoundException, SQLException {
		System.out.println("Nhập vào tên của department cần tìm");
		String inputString = sc.nextLine();
		System.out.println(DepartmentDao.isDepartmentNameExists(inputString));
	}
	public void question5(Scanner sc) throws ClassNotFoundException, SQLException {
		System.out.println("Nhập vào tên của department cần thêm");
		String inputString = sc.nextLine();
		DepartmentDao.createDepartment(inputString);
		System.out.println("Danh sách các department sau khi thêm: " + DepartmentDao.getDepartments());
		
	}
	
	public void question6(Scanner sc) throws ClassNotFoundException, SQLException {
		System.out.println("Update department name theo id");
		System.out.println("Nhập vào id của department cần update");
		int inputNumber = sc.nextInt();
		sc.nextLine();
		System.out.println("Nhập vào tên mới");
		String inputString = sc.nextLine();
		DepartmentDao.updateDepartmentName(inputNumber, inputString);
		System.out.println("Danh sách các department sau khi update: " + DepartmentDao.getDepartments());
	}
	
	public void question7(Scanner sc) throws ClassNotFoundException, SQLException {
		System.out.println("Xóa department theo id");
		System.out.println("Nhập vào id của department cần xóa");
		int inputNumber = sc.nextInt();
		sc.nextLine();
		DepartmentDao.deleteDepartment(inputNumber);
		System.out.println("Danh sách các department còn lại sau khi xóa: " + DepartmentDao.getDepartments());
	}
	

}
