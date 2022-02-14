package com.vti.backend;

import java.util.Scanner;

public class ScannerUtils {
	public static int inputInt7(String err, Scanner sc) {
		boolean isOk = false;
		int result = 0;
		while (isOk == false) {

			try {
				System.out.println("Nhập vào số nguyên dương");
				int inputInt = Integer.parseInt(sc.nextLine().trim());
				if (inputInt > 0) {

					result = inputInt;
					isOk = true;
				} else {
					System.out.println(err);
					isOk = false;
				}
			} catch (Exception e) {
				isOk = false;
				System.out.println(err);
			}

		}

		return result;

	}

	public static void inputFloat8(String err, Scanner sc) {
		boolean isOk = false;
		while (isOk == false) {

			try {
				System.out.println("Nhập vào số thực Float");
				float inputInt = Float.parseFloat(sc.nextLine().trim());
				System.out.println("Ok");
				isOk = true;
			} catch (Exception e) {
				isOk = false;
				System.out.println(err);
			}

		}
	}

	public static void inputDouble8(String err, Scanner sc) {
		boolean isOk = false;
		while (isOk == false) {

			try {
				System.out.println("Nhập vào số thực Double");
				double inputInt = Double.parseDouble(sc.nextLine().trim());
				System.out.println("Ok");
				isOk = true;
			} catch (Exception e) {
				isOk = false;
				System.out.println(err);
			}

		}
	}

	public static String inputString8(Scanner sc) {

		System.out.println("Nhập vào String");
		String inputString;
		return inputString = sc.nextLine();

	}

}
