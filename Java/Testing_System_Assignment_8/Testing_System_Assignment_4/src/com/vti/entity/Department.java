package com.vti.entity;

import java.util.Objects;

/*Table 1:Department
 DepartmentID: định danh của phòng ban (auto increment)
 DepartmentName: tên đầy đủ của phòng ban (VD: sale, marketing, …)
*/

public class Department {
	private int departmentID;
	private String departmentName;
	
	public int getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}

	public Department(){
		
	}
	
	public Department(String nameDepartment) {
		this.setDepartmentName(nameDepartment);
		this.setDepartmentID(0);
	}

	@Override
	public String toString() {
		return "Department [departmentID=" + getDepartmentID() + ", departmentName=" + getDepartmentName() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(getDepartmentID(), getDepartmentName());
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}
