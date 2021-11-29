package com.vti.entity;

public class Student {
	private int id;
	private String name;
	private String homeTown;
	private int diemHocLuc;
	
	public Student(String name, String homeTown, int diemHocLuc) {
		super();
		this.name = name;
		this.homeTown = homeTown;
		this.diemHocLuc = diemHocLuc;
	}
	
	public int setDiemHocLuc1(int diem) {
		this.diemHocLuc = diem;
		return this.diemHocLuc;
	}
	
	public int plusDiemHocLuc(int themDiem) {
		this.diemHocLuc += themDiem;
		return this.diemHocLuc;
	}
	
	public void inThongTinSV() {
		if(this.diemHocLuc < 4) {
			System.out.println(this.name + ", " + "Yếu");
		}
		else if (this.diemHocLuc < 6) {
			System.out.println(this.name + ", " + "Trung bình");
		}
		else {
			System.out.println(this.name + ", " + "Giỏi");
		}
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", homeTown=" + homeTown + ", diemHocLuc=" + diemHocLuc + "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHomeTown() {
		return homeTown;
	}
	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}
	public int getDiemHocLuc() {
		return diemHocLuc;
	}
	public void setDiemHocLuc(int diemHocLuc) {
		this.diemHocLuc = diemHocLuc;
	}
	
}
