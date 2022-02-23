package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department", catalog = "testing_system_assignment_5")
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "department_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short departmentID;

	@Column(name = "department_name", length = 30, nullable = false, unique = true)
	private String departmentName;

	public Department() {
	}

	public Department(String departmentName) {
		this.departmentName = departmentName;
	}

	
	public short getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(short departmentID) {
		this.departmentID = departmentID;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Department [departmentID=" + departmentID + ", departmentName=" + departmentName + "]";
	}

	

}
