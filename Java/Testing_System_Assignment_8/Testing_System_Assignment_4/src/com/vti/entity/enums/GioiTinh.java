package com.vti.entity.enums;

public enum GioiTinh {
	NAM("Nam"),
	NU("Nữ"),
	KHAC("Khác");
	
	private String gioiTinh;
	
	GioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getGioiTinh() {
		return this.gioiTinh;
	}
	
	
}
