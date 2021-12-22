package com.vti.frontend;

import java.sql.SQLException;
import java.util.Scanner;

import com.vti.backend.Exercise2_CRUD;

public class Program2 {

	public static void main(String[] args) {
		Exercise2_CRUD ex2 = new Exercise2_CRUD();
		Scanner sc = new Scanner(System.in);
		try {
//			ex2.question1();
//			ex2.question2_3(sc);
//			ex2.question4(sc);
//			ex2.question5(sc);
//			ex2.question6(sc);
			ex2.question7(sc);
		} catch (ClassNotFoundException e) {
			System.out.println("Lỗi tạo driver không thành công");
		} catch (SQLException e) {
			System.out.println("Lỗi kết nối database không thành công");
		}
	}

}
