package com.vti.entity;

public class HinhTron extends HinhHoc {

	public HinhTron(float a, float b) throws HinhHocException {
		super(a, b);
		// TODO Auto-generated constructor stub
	}

	@Override
	float tinhChuVi(float a, float b) {
		// TODO Auto-generated method stub
		return 2 * a * Configs.PI;
	}

	@Override
	float tinhDienTich(float a, float b) {
		// TODO Auto-generated method stub
		return (float) (Configs.PI * (Math.pow(a, 2)));
	}

}
