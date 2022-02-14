package com.vti.entity;

import java.util.Scanner;

import com.vti.backend.ScannerUtils;
import com.vti.entity.enums.PositionName;

public class Position {
	static int positionCount = 0;
	int id;
	String name;

	@Override
	public String toString() {
		return "Position [id=" + id + ", name=" + name + "]";
	}

	public Position(Scanner sc) {
		super();
		positionCount++;
		this.id = positionCount;
		System.out.println("Nhập vào tên vị trí, 1. Dev, 2. Test, 3. Scrum Master, 4. PM");
		while (true) {
			int inputNumber = ScannerUtils.inputInt7("Số nhập vào không hợp lệ, vui lòng nhập lại", sc);
			switch (inputNumber) {
			case 1:
				this.name = PositionName.DEV.getPositionName();
				return;
			case 2:
				this.name = PositionName.TEST.getPositionName();
				return;
			case 3:
				this.name = PositionName.SCRUM_MASTER.getPositionName();
				return;
			case 4:
				this.name = PositionName.PM.getPositionName();
				return;
			default:
				System.out.println("Vui lòng nhập vị trí từ 1 đến 4");
			}
		}
	}

}
