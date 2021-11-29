package com.vti.backend;

import com.vti.entity.Student;

public class Exercise4_Encapsulation {

//	Question 1:
//		Tạo Object Student có các property id, name, hometown, điểm học lực
//		a) Tất cả các property sẽ để là private để các class khác không
//		chỉnh sửa hay nhìn thấy
//		b) Tạo constructor cho phép khi khởi tạo mỗi student thì người
//		dùng sẽ nhập vào tên, hometown và có điểm học lực = 0
//		c) Tạo 1 method cho phép set điểm vào
//		d) Tạo 1 method cho phép cộng thêm điểm
//		e) Tạo 1 method để in ra thông tin của sinh viên bao gồm có tên,
//		điểm học lực ( nếu điểm <4.0 thì sẽ in ra là Yếu, nếu điểm >
//		4.0 và < 6.0 thì sẽ in ra là trung bình, nếu điểm > 6.0 và < 8.0
//		thì sẽ in ra là khá, nếu > 8.0 thì in ra là Giỏi)
//		Demo các chức năng trên bằng class ở front-end.
	public void question1() {
		System.out.println("\n-- Question 1:");
		System.out.println("b) Khởi tạo Student có tham số");
		Student student1 = new Student("Nguyễn Văn A", "Bắc Ninh", 6);
		System.out.println(student1.toString());
		
		System.out.println("c, d, e) Tạo 1 method cho phép set điểm vào");
		System.out.println("Điểm đã set cho sinh viên này là: " + student1.setDiemHocLuc1(5));
		System.out.println("Điểm sau khi đã cộng thêm cho sinh viên này là: " + student1.plusDiemHocLuc(3));
		student1.inThongTinSV();	
	}
}
