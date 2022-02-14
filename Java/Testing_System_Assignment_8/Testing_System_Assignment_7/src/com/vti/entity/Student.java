package com.vti.entity;

public class Student {
	int id;
	String name;
	static String college = "Đại học bách khoa";
	static int moneyGroup = 0;
	static int countStudent = 0;
//	static int createdStudent = 0;

	public Student(int id, String name) {
		super();
//		createdStudent = PrimaryStudent.getCountStudent() + SecondaryStudent.getCountStudent();
		countStudent++;
		if (countStudent > 7) {
			System.out.println("Chỉ cho phép user tạo được tối đa 7 học sinh");
		} else {
			this.id = id;
			this.name = name;
		}
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", school=" + college + "]";
	}

	public static void chuyenTenTruong() {
		college = "Đại học công nghệ";
	}

	public int nopTien(int soTien) {
		moneyGroup += soTien;
		return moneyGroup;
	}

	public static void inSoTienHienTai() {
		System.out.println("Số tiền quỹ lớp hiện tại: " + moneyGroup);
	}

	public void tieuTien(int soTienTieu) {
		moneyGroup -= soTienTieu;

	}

	public static void chuyenTenTruong(String tenTruongMoi) {
		college = tenTruongMoi;
	}

	public static String getCollege() {
		return college;
	}

	public static int countStudent() {
		return countStudent;
	}

}
