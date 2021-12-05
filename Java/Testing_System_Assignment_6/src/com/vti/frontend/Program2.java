package com.vti.frontend;

import java.util.Scanner;

import com.vti.backend.Exercise2_Exception;
import com.vti.backend.ScannerUtils;

public class Program2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exercise2_Exception ex2 = new Exercise2_Exception();
		Scanner sc = new Scanner(System.in);
//		ex2.question1();
//		ex2.question2();
//		ex2.question3();
//		ex2.question4();
//		ex2.inputAge6(sc);// question 5
//		ScannerUtils.inputInt7("Số nhập vào không hợp lệ, vui lòng nhập lại", sc);
//		ScannerUtils.inputFloat8("Số nhập vào không hợp lệ, vui lòng nhập lại", sc);
//		ScannerUtils.inputDouble8("Số nhập vào không hợp lệ, vui lòng nhập lại", sc);
//		ScannerUtils.inputString8(sc);
//		ScannerUtils.inputString8(sc);
//		ex2.question9Pos(sc);
//		ex2.question9Dep(sc);
		ex2.question10(sc);
		sc.close();
	}

}
