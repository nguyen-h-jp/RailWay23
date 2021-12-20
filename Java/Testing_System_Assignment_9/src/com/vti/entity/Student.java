package com.vti.entity;

public class Student {
	private String name;

	public String getName() {
		return name;
	}

	private int id;

	// bước 4
	/**
	 * @deprecated replaced by {@link #newGetterID()}
	 */

	// bước 1
	public int getId() {
		return id;
	}

	// bước 3
	public String newGetterID() {
		return "MSV: " + id;
	}

	private int countStudent = 0;

	public Student(String name) {
		super();
		countStudent++;
		this.name = name;
		this.id = countStudent;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

}
