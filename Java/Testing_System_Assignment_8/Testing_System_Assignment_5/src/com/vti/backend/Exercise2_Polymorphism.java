package com.vti.backend;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import com.vti.entity.HinhVuong;
import com.vti.entity.Student;

public class Exercise2_Polymorphism {

	private Student[] studentArr;
	private Random random;

	public Exercise2_Polymorphism() {
		studentArr = new Student[] {};
		random = new Random();
	}

	public void question1(Scanner sc) {
		while (true) {
			System.out.println("1. Tạo 10 học sinh và chia thành 3 nhóm");
			System.out.println("2. Kêu gọi cả lớp điểm danh");
			System.out.println("3. Gọi nhóm 1 đi học bài");
			System.out.println("4. Gọi nhóm 2 đi dọn vệ sinh");
			System.out.println("5. Exit");
			int num = 0;
			boolean isOk = false;
			do {
				System.out.println("Nhập vào chức năng muốn sử dụng, từ 1 - 4");
				num = sc.nextInt();
				if (num > 5 || num == 0) {
					System.out.println("Số nhập vào không hợp lệ, vui lòng nhập lại!");
				} else {
					isOk = true;
				}
			} while (isOk == false);

			switch (num) {
			case 1:
				themHocSinh();
				break;
			case 2:
				for (Student student : studentArr) {
					student.diemDanh();
				}
				break;
			case 3:
				for (Student student : studentArr) {
					if (student.getGroup() == 1) {
						student.hocBai();
					}
				}
				break;
			case 4:
				for (Student student : studentArr) {
					if (student.getGroup() == 2) {
						student.diDonVeSinh();
					}
				}
				break;
			case 5:
				return;
			default:
				System.out.println("Số nhập vào không hợp lệ, vui lòng nhập lại");
			}
		}
	}

	private void themHocSinh() {
		for (int i = 0; i < 10; i++) {
			Student student = new Student((i + 1), "Student " + (i + 1), random.nextInt(3) + 1);
			studentArr = Arrays.copyOf(studentArr, studentArr.length + 1);
			studentArr[studentArr.length - 1] = student;
		}
		for (Student student : studentArr) {
			System.out.println(student);
		}
	}

	public void question3() {
		HinhVuong hv = new HinhVuong(5);
		System.out.println(hv.tinhChuVi());
		System.out.println(hv.tinhDienTich());
	}
}
