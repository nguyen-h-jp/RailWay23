package com.vti.entity;

public abstract class HinhHoc {
	float a;
	float b;
	static int count = 0;

	abstract float tinhChuVi(float a, float b);

	abstract float tinhDienTich(float a, float b);

	public HinhHoc(float a, float b) throws HinhHocException {
		super();
		count++;
		if (count <= Configs.SO_LUONG_TOI_DA) {
			this.a = a;
			this.b = b;
		} else {
			throw new HinhHocException();
		}
	}
}
