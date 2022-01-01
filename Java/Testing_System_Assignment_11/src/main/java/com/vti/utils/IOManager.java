package com.vti.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class IOManager {

	public static String readFile(String pathFile) {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(pathFile);
			byte[] byteInput;
			byteInput = fileInputStream.readAllBytes();
			return new String(byteInput, 0, byteInput.length);
		} catch (FileNotFoundException e) {
			System.out.println("Lỗi không tìm thấy file");
			e.printStackTrace();
			return "";
		} catch (IOException e) {
			System.out.println("Đã có lỗi xảy ra");
			e.printStackTrace();
			return "";
		} finally {
			try {
				fileInputStream.close();
			} catch (IOException e) {
				System.out.println("Đã có lỗi xảy ra");
				e.printStackTrace();
			}
		}
	}

	public static void writeFile(String pathFile, boolean isContinuing, String content) {
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(pathFile, isContinuing);
			fileOutputStream.write(content.getBytes());
		} catch (FileNotFoundException e) {
			System.out.println("Lỗi không tìm thấy file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Đã có lỗi xảy ra");
			e.printStackTrace();
		}
		try {
			fileOutputStream.close();
		} catch (IOException e) {
			System.out.println("Đã có lỗi xảy ra");
			e.printStackTrace();
		}
	}

	public static List<Object> readObjectFile(String pathFile) {
		List<Object> objectsList = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(pathFile);
			ObjectInputStream objectInputStream = new ObjectInputStream(fis);
			objectsList = (List<Object>) objectInputStream.readObject();

		} catch (FileNotFoundException e) {
			System.out.println("Lỗi không tìm thấy file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Đã có lỗi xảy ra");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objectsList;
	}

	public static void writeObjectFile(String pathFile, List<Object> objList) {
		FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream(pathFile, false);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(objList);
			fileOutputStream.close();
			objectOutputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("Lỗi không tìm thấy file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Đã có lỗi xảy ra");
			e.printStackTrace();
		}
	}
}
