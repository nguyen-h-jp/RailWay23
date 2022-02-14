package com.vti.entity;

public class HinhChuNhat extends HinhHoc {

	public HinhChuNhat(float a, float b) throws HinhHocException {
		super(a, b);
		// TODO Auto-generated constructor stub
	}

	@Override
	float tinhChuVi(float a, float b) {
		// TODO Auto-generated method stub
		return 2 * (a + b);
	}

	@Override
	float tinhDienTich(float a, float b) {
		// TODO Auto-generated method stub
		return a * b;
	}

}
