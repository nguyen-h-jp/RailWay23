package com.vti.entity;

public class SecondaryStudent extends Student {
	static int countStudent = 0;

	public SecondaryStudent(int id, String name) {
		super(id, name);
		if (Student.countStudent <= 7) {
			countStudent++;

		} else {
			System.out.println("Không thể thạo thêm học sinh");
		}
		// TODO Auto-generated constructor stub
	}

	public static int getCountStudent() {
		return countStudent;
	}

}
