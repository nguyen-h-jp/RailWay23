package com.vti.backend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.vti.entity.Student;

public class Exercise1_Collection {
	public void question1(Scanner sc) {
//		Khai báo 1 ArrayList students
		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student("Nguyễn Văn A"));
		studentList.add(new Student("Nguyễn Văn A"));
		studentList.add(new Student("Nguyễn Văn A"));
//		In ra tổng số phần tử của students
		System.out.println("a) Tổng số phần tử của Student là: " + studentList.size());
//		Lấy phần tử thứ 4 của students
		try {
			System.out.println(studentList.get(4));

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Đã xảy ra lỗi");
		}
//		In ra phần tử đầu và phần tử cuối của students
		System.out.println("Phần tử đầu là: " + studentList.get(0));
		System.out.println("Phần tử cuối là: " + studentList.get(studentList.size() - 1));
//		Thêm 1 phần tử vào vị trí đầu của students
		studentList.add(0, new Student("Nguyễn Văn B"));
		System.out.println("Sau khi thêm 1 phần tử vào vị trí đầu: " + studentList);
//		Thêm 1 phần tử vào vị trí cuối của students
		studentList.add(studentList.size(), new Student("Nguyễn Văn C"));
		System.out.println("Sau khi thêm 1 phần tử vào vị trí cuối: " + studentList);
//		Đảo ngược vị trí của student
		Collections.reverse(studentList);
		System.out.println(studentList);
//		Tạo 1 method tìm kiếm student theo id
		System.out.println("Nhập vào id cần tìm kiếm: ");
		int inputID = sc.nextInt();
		sc.nextLine();
		int temp1 = 0;
		for (Student student : studentList) {
			if (student.getId() == inputID) {
				System.out.println(student);
				temp1++;
			}
		}
		if (temp1 != 1) {
			System.out.println("Không tìm thấy student");
		}
//		Tạo 1 method tìm kiếm student theo name
		System.out.println("Nhập vào tên cần tìm kiếm: ");
		String inputName = sc.nextLine();
		int temp2 = 0;
		for (Student student : studentList) {
			if (student.getName().equals(inputName)) {
				System.out.println(student);
				temp2++;
			}
		}
		if (temp2 != 1) {
			System.out.println("Không tìm thấy student");
		}
//		Tạo 1 method để in ra các student có trùng tên
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < studentList.size() - 1; i++) {
			String namei = studentList.get(i).getName();
			for (int j = i + 1; j < studentList.size(); j++) {
				String namej = studentList.get(j).getName();
				if (namei.equals(namej)) {
					set.add(i);
					set.add(j);
				}
			}
		}
		for (Integer integer : set) {
			System.out.println(studentList.get(integer));
		}
//		Xóa name của student có id = 2;)
		for (Student student : studentList) {
			if (student.getId() == 2) {
				student.setName(null);
			}
		}
		System.out.println(studentList);
//		Delete student có id = 5;
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getId() == 5) {
				studentList.remove(i);
			}
		}
		System.out.println(studentList);
//		Tạo 1 ArrayList tên là studentCopies và add tất cả students vào studentCopies
		List<Student> studentCopies = new ArrayList<>(studentList);
		System.out.println(studentCopies);
	}

	public void question6() {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Nguyễn Văn A");
		map.put(2, "Nguyễn Văn B");
		map.put(3, "Nguyễn Văn C");
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			Integer key = entry.getKey();
			String val = entry.getValue();
			System.out.println("ID: " + key + ", Tên: " + val);
		}
	}

}
