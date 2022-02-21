/**
 * Description: 
 */
package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detail_department")
public class DetailDepartment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "department_id")
	@Id
	private int departmentID;

//	@Column(name = "address_id", nullable = false, unique = true)
//	private int addressID;
	
	@Column(name = "emulation_point")
	private int emulationPoint;
	
	@OneToOne
	@JoinColumn(name = "department_id", referencedColumnName = "department_id")
	private Department department;
	
	
	@ManyToOne
	@JoinColumn(name = "address_id", referencedColumnName = "address_id")
	private Address address;
	
	public DetailDepartment() {
	}

	public int getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}

	public int getEmulationPoint() {
		return emulationPoint;
	}

	public void setEmulationPoint(int emulationPoint) {
		this.emulationPoint = emulationPoint;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "DetailDepartment [departmentID=" + departmentID + ", emulationPoint=" + emulationPoint + ", department="
				+ department.getDepartmentName() + ", address=" + address.getAddressName() + "]";
	}

	
	

	

	

	

	

	

		
}