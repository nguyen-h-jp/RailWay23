package com.vti.backend;

import java.util.Date;

import com.vti.entity.Student;

public class Exercise2_Annotations {
	public void question1() {

		@SuppressWarnings("deprecation")
		Date date = new Date(2020, 05, 18);
		System.out.println(date);
	}

	public void question2() {

		// bước 2
		Student student = new Student("Nguyễn Văn A");
		System.out.println(student.getName());
		// demo method mới newGetterID()
		System.out.println(student.newGetterID());
	}
}
