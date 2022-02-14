package com.vti.entity;


public class CanBo {
	private String hoTen;
	private int tuoi;
	private String gioiTinh;
	private String diaChi;
	public CanBo(String hoTen, int tuoi, String gioiTinh, String diaChi) {
		super();
		this.setHoTen(hoTen);
		this.setTuoi(tuoi);
		this.setGioiTinh(gioiTinh);
		this.setDiaChi(diaChi);
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	@Override
	public String toString() {
		return "CanBo [hoTen=" + hoTen + ", tuoi=" + tuoi + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + "]";
	}
}
