package com.vti.dto;

public class DepartmentDTO {
	private int departmentID;
	private String departmentName;
	private String address;
	
	

	public DepartmentDTO() {
		
	}



	public int getDepartmentID() {
		return departmentID;
	}



	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}



	public String getDepartmentName() {
		return departmentName;
	}



	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public DepartmentDTO(int departmentID, String departmentName, String address) {

		this.departmentID = departmentID;
		this.departmentName = departmentName;
		this.address = address;
	}



	@Override
	public String toString() {
		return "DepartmentDTO [departmentID=" + departmentID + ", departmentName=" + departmentName + ", address="
				+ address + "]";
	}

}
