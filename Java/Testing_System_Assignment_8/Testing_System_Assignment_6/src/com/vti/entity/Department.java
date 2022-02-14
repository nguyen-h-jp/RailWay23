package com.vti.entity;

import java.util.Scanner;

import com.vti.backend.ScannerUtils;

public class Department {
	private static int departmentCount;
	private int id;
	private String name;

	public Department(int i) {
		departmentCount++;
		this.id = departmentCount;
		this.name = "Department " + (i + 1);
	}

	public Department(String name) {
		departmentCount++;
		this.id = departmentCount;
		this.name = name;
	}

	public Department(Scanner sc) {
		departmentCount++;
		this.id = departmentCount;
		System.out.println("Nhập vào tên department");
		this.name = ScannerUtils.inputString8(sc);
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

}
