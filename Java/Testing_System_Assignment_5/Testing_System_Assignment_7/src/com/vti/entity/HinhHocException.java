package com.vti.entity;

public class HinhHocException extends Exception {
	public HinhHocException() {
		super("Số lượng hình tối đa là:  " + Configs.SO_LUONG_TOI_DA);
	}

}
