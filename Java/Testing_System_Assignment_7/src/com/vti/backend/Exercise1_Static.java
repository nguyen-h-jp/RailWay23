package com.vti.backend;

import java.lang.reflect.Array;

import com.vti.entity.HinhChuNhat;
import com.vti.entity.HinhHoc;
import com.vti.entity.HinhHocException;
import com.vti.entity.MyMath;
import com.vti.entity.PrimaryStudent;
import com.vti.entity.SecondaryStudent;
import com.vti.entity.Student;

public class Exercise1_Static {
	public void question1() {
		Student student1 = new Student(1, "Nguyễn Văn A");
		Student student2 = new Student(2, "Nguyễn Văn B");
		Student student3 = new Student(3, "Nguyễn Văn C");
		Student[] studentArr = new Student[] { student1, student2, student3 };
		for (Student student : studentArr) {
			System.out.println(student.toString());
		}

		Student.chuyenTenTruong();
		System.out.println("Sau khi đổi tên trường");
		for (Student student : studentArr) {
			System.out.println(student.toString());
		}
	}

	public void question2() {
		Student student1 = new Student(1, "Nguyễn Văn A");
		Student student2 = new Student(2, "Nguyễn Văn B");
		Student student3 = new Student(3, "Nguyễn Văn C");
		Student[] studentArr = new Student[] { student1, student2, student3 };
		for (Student student : studentArr) {
			student.nopTien(100);
		}
		System.out.println("Sau khi đóng tiền quỹ xong: ");
		Student.inSoTienHienTai();
		System.out.println("Student thứ 1 lấy 50k đi mua bim bim, kẹo về liên hoan");
		student1.tieuTien(50);
		Student.inSoTienHienTai();
		System.out.println("Student thứ 2 lấy 20k đi mua bánh mì");
		student2.tieuTien(20);
		Student.inSoTienHienTai();
		System.out.println("Student thứ 3 lấy 150k đi mua đồ dùng học tập cho nhóm");
		student3.tieuTien(150);
		Student.inSoTienHienTai();
		System.out.println("cả nhóm mỗi người lại đóng quỹ mỗi người 50k");
		for (Student student : studentArr) {
			student.nopTien(50);
		}
		Student.inSoTienHienTai();

	}

	public void question3() {
		System.out.println(MyMath.max(5, 6));
		System.out.println(MyMath.min(7, 4));
		System.out.println(MyMath.sum(7, 4));
	}

	public void question4() {
		Student student1 = new Student(1, "Nguyễn Văn A");
		Student student2 = new Student(2, "Nguyễn Văn B");
		Student student3 = new Student(3, "Nguyễn Văn C");
		Student[] studentArr = new Student[] { student1, student2, student3 };
		for (Student student : studentArr) {
			System.out.println(student.toString());
		}

		Student.chuyenTenTruong("Đại học Công nghiệp");
		;
		System.out.println("Sau khi đổi tên trường");
		for (Student student : studentArr) {
			System.out.println(student.toString());
		}
		System.out.println(Student.getCollege());
	}

	public void question5() {
		Student student1 = new Student(1, "Nguyễn Văn A");
		Student student2 = new Student(2, "Nguyễn Văn B");
		Student student3 = new Student(3, "Nguyễn Văn C");
		System.out.println("Số học sinh là: " + Student.countStudent());
	}

	public void question6() {
		Student student1 = new PrimaryStudent(1, "Nguyễn Văn A");
		Student student2 = new PrimaryStudent(2, "Nguyễn Văn B");
		Student student3 = new SecondaryStudent(3, "Nguyễn Văn C");
		Student student4 = new SecondaryStudent(4, "Nguyễn Văn D");
		Student student5 = new SecondaryStudent(5, "Nguyễn Văn E");
		Student student6 = new SecondaryStudent(6, "Nguyễn Văn F");
		System.out.println("Số PrimaryStudent là: " + PrimaryStudent.getCountStudent());
		System.out.println("Số SecondaryStudent là: " + SecondaryStudent.getCountStudent());
		System.out.println("Số Student là: " + Student.countStudent());
	}

	public void question7() {
		Student student1 = new PrimaryStudent(1, "Nguyễn Văn A");
		Student student2 = new PrimaryStudent(2, "Nguyễn Văn B");
		Student student3 = new PrimaryStudent(3, "Nguyễn Văn C");
		Student student4 = new SecondaryStudent(4, "Nguyễn Văn D");
		Student student5 = new SecondaryStudent(5, "Nguyễn Văn E");
		Student student6 = new SecondaryStudent(6, "Nguyễn Văn F");
		Student student7 = new SecondaryStudent(7, "Nguyễn Văn G");
		Student student8 = new SecondaryStudent(8, "Nguyễn Văn H");
		System.out.println("Số PrimaryStudent là: " + PrimaryStudent.getCountStudent());
		System.out.println("Số SecondaryStudent là: " + SecondaryStudent.getCountStudent());
		System.out.println("Số Student là: " + (PrimaryStudent.getCountStudent() + SecondaryStudent.getCountStudent()));
	}

	public void question8() {

		try {
			HinhHoc hinhChuNhat1 = new HinhChuNhat(2, 3);
			HinhHoc hinhChuNhat2 = new HinhChuNhat(3, 4);
			HinhHoc hinhChuNhat3 = new HinhChuNhat(4, 5);
			HinhHoc hinhChuNhat4 = new HinhChuNhat(5, 6);
			HinhHoc hinhChuNhat5 = new HinhChuNhat(6, 7);
//			HinhHoc hinhChuNhat6 = new HinhChuNhat(7, 8);
			HinhHoc[] hinhHocArr = new HinhHoc[] { hinhChuNhat1, hinhChuNhat2, hinhChuNhat3, hinhChuNhat4,
					hinhChuNhat5 };
			System.out.println("Tạo thành công " + hinhHocArr.length + " hình");
		} catch (HinhHocException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
