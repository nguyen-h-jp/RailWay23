/**
 * Description: 
 */
package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "department_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int departmentID;
	
	@Column(name = "department_name", length = 30, nullable = false, unique = true)
	private String departmentName;
	
	@OneToOne(mappedBy = "department")
	private DetailDepartment detailDepartment;
	
	public Department() {
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

	public DetailDepartment getDetailDepartment() {
		return detailDepartment;
	}

	public void setDetailDepartment(DetailDepartment detailDepartment) {
		this.detailDepartment = detailDepartment;
	}

	@Override
	public String toString() {
		String departmentEmulationPoint = detailDepartment != null ? String.valueOf(detailDepartment.getEmulationPoint()) : "Unknown";
		return "Department [departmentID=" + departmentID + ", departmentName=" + departmentName + ", detailDepartmentEmulationPoint="
				+ departmentEmulationPoint + "]";
	}

	

	

	

	

	

	
	
}