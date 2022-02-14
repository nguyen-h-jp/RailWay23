package com.vti.entity;

public class Student implements IStudent {
	int id;
	String name;
	int group;

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", group=" + group + "]";
	}

	public Student() {
		super();
	}

	public Student(int id, String name, int group) {
		super();
		this.id = id;
		this.name = name;
		this.group = group;
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

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	@Override
	public void diemDanh() {
		// TODO Auto-generated method stub
		System.out.println(this.name + " điểm danh");
	}

	@Override
	public void hocBai() {
		// TODO Auto-generated method stub
		System.out.println(this.name + " học bài");
	}

	@Override
	public void diDonVeSinh() {
		// TODO Auto-generated method stub
		System.out.println(this.name + " đi dọn vệ sinh");
	}
}
