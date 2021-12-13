//package com.vti.backend;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.Scanner;
//
//import org.apache.commons.lang3.ArrayUtils;
//
//import com.vti.entity.StudentExcercise5;
//
//public class Exercise5_DemoFile_IO_Stream {
//	public void question1(Scanner sc) {
//		StudentExcercise5[] studentArr = new StudentExcercise5[] {};
//		StudentExcercise5 stuEx51 = new StudentExcercise5(sc);
//		StudentExcercise5 stuEx52 = new StudentExcercise5(sc);
//		StudentExcercise5 stuEx53 = new StudentExcercise5(sc);
//
//		studentArr = ArrayUtils.add(studentArr, stuEx51);
//		studentArr = ArrayUtils.add(studentArr, stuEx52);
//		studentArr = ArrayUtils.add(studentArr, stuEx53);
//		for (StudentExcercise5 studentExcercise5 : studentArr) {
//			System.out.println(studentExcercise5.toString());
//		}
//		String fileName = "C:\\Users\\USER\\Desktop\\manage_file\\StudentInformation.txt";
//		File studentInformationFile = new File(fileName);
//		if (!studentInformationFile.exists()) {
//			try {
//				studentInformationFile.createNewFile();
//			} catch (IOException e) {
//				System.out.println("File không tồn tại");
//			}
//
//		}
//		StudentExcercise5.writeObj(studentArr, fileName);
////		StudentExcercise5.readObj(studentArr, file);
//	}
//}
