package com.vti.entity;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import com.vti.backend.ScannerUtils;

public class Group {
	static int groupCount = 0;
	int id;
	String name;
	Account creator;
	Date createDate;
	Account[] accounts;

	public Group(Scanner sc) {
		groupCount++;
		this.id = groupCount;
		System.out.println("Nhập tên group");
		this.name = ScannerUtils.inputString8(sc);
		this.createDate = new Date();
		System.out.println("Bạn có muốn thêm account vào group này không, 1. Có, 2. Không");
		while (true) {
			int inputNumber = ScannerUtils.inputInt7("Số nhập vào không hợp lệ, vui lòng nhập lại", sc);
			switch (inputNumber) {
			case 1:
				System.out.println("Nhập số lượng account muốn thêm vào group này");
				int soLuongAccount = ScannerUtils.inputInt7("Số nhập vào không hợp lệ, vui lòng nhập lại", sc);
				Account[] accountsArr = new Account[soLuongAccount];
				for (int i = 0; i < accountsArr.length; i++) {
					System.out.println("Nhập vào account thứ " + (i + 1));
					Account acc = new Account(sc);
					accountsArr[i] = acc;
				}
				this.accounts = accountsArr;
				return;
			case 2:
				return;
			default:
				System.out.println("Vui lòng nhập 1 hoặc 2");
				break;
			}
		}

	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", creator=" + creator + ", createDate=" + createDate
				+ ", accounts=" + Arrays.toString(accounts) + "]";
	}
}
