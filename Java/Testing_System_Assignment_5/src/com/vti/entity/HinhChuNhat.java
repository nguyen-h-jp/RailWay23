package com.vti.entity;

public class HinhChuNhat {
	float a;
	float b;

	public HinhChuNhat(float a, float b) {
		super();
		this.a = a;
		this.b = b;
	}

	public float tinhChuVi() {
		System.out.println("Tính chu vi theo hình chữ nhật");
		return 2 * (a + b);
	}

	public float tinhDienTich() {
		System.out.println("Tính chu vi theo hình chữ nhật");
		return a * b;
	}

}
