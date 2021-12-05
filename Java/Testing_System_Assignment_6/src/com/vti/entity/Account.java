package com.vti.entity;

import java.util.Scanner;

import com.vti.backend.ScannerUtils;

public class Account {
	public static int accountCount = 0;
	int id;
	String email;
	String userName;
	String fullName;

	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", userName=" + userName + ", fullName=" + fullName + "]";
	}

	public Account(Scanner sc) {
		System.out.println("Nhập thông tin account");
		accountCount++;
		this.id = accountCount;
		System.out.println("Nhập email");
		this.email = ScannerUtils.inputString8(sc);
		System.out.println("Nhập userName");
		this.userName = ScannerUtils.inputString8(sc);
		System.out.println("Nhập fullName");
		this.fullName = ScannerUtils.inputString8(sc);
	}
}
