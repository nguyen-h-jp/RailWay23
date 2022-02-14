package com.vti.backend;

import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;

import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;

public class Exercise2_Exception {
	public void question1() {
		try {
			float result = divide(7, 1);
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("can not divide 0");
		}

	}

	private static float divide(int a, int b) {
		return a / b;
	}

	public void question2() {
		try {
			float result = divide(7, 0);
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("can not divide 0");
		} finally {
			System.out.println("divide completed");
		}

	}

	public void question3() {

		try {
			int[] numbers = { 1, 2, 3 };
			System.out.println(numbers[10]);

		} catch (Exception e) {
			System.out.println("Index 10 out of bounds for length 3");
		}

	}

	public void question4() {
		Department[] deptArr = {};
		for (int i = 0; i < 5; ++i) {
			Department dept = new Department(i);
			deptArr = ArrayUtils.add(deptArr, dept);

		}
		getIndex(deptArr, 5);

	}

	public void getIndex(Department[] dp, int a) {

		try {
			System.out.println(dp[a].toString());

		} catch (Exception e) {
			System.out.println("Cannot find department");
		}
	}

	public int inputAge5(Scanner sc) {

		try {
			System.out.println("Nhập vào 1 số");

			int inputNumber = Integer.parseInt(sc.nextLine().trim());
			System.out.println(inputNumber);
			if (inputNumber < 0) {
				System.out.println("Wrong inputing! The age must be greater than 0, please input again.");
			}
			return inputNumber;

		} catch (Exception e) {
			System.out.println("wrong inputing! Please input an age as int, input again.");
		}
		return 0;
	}

	public int inputAge6(Scanner sc) {
		boolean isOk = false;
		while (isOk == false) {
			try {
				System.out.println("Nhập vào 1 số");

				int inputNumber = Integer.parseInt(sc.nextLine().trim());
				if (inputNumber < 0) {

					System.out.println("Wrong inputing! The age must be greater than 0, please input again.");
					isOk = false;

				} else {
					isOk = true;
				}

			} catch (Exception e) {
				isOk = false;
				System.out.println("wrong inputing! Please input an age as int, input again.");
			}

		}
		return 0;
	}

	public void question9Pos(Scanner sc) {
		System.out.println("Tạo position");
		Position pos1 = new Position(sc);
		Position pos2 = new Position(sc);
		Position pos3 = new Position(sc);
		Position pos4 = new Position(sc);
		
		System.out.println("Tạo position thành công");
		System.out.println(pos1.toString());
		System.out.println(pos2.toString());
		System.out.println(pos3.toString());
		System.out.println(pos4.toString());

	}
	
	public void question9Dep(Scanner sc) {
		System.out.println("Tạo department");
		Department dept1 = new Department(sc);
		System.out.println("Tạo department thành công");
		System.out.println(dept1.toString());
	}

	public void question10(Scanner sc) {
		System.out.println("Tạo group");
		Group gr = new Group(sc);
		System.out.println(gr.toString());
	}
}
