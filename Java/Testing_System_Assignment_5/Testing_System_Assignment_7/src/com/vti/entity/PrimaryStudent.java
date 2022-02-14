package com.vti.entity;

public class PrimaryStudent extends Student {
	static int countStudent = 0;

	public PrimaryStudent(int id, String name) {
		super(id, name);
		if (Student.countStudent <= 7) {
			countStudent++;

		} else {
			System.out.println("Không thể thạo thêm học sinh");
		}
	}

	public static int getCountStudent() {
		return countStudent;
	}

}
