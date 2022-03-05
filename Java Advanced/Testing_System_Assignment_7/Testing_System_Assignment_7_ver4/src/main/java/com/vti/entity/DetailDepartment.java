/**
 * Description: 
 */
package com.vti.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "detail_department")
@PrimaryKeyJoinColumn(name = "department_id")
public class DetailDepartment extends Department implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "emulation_point")
	private int emulationPoint;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "address_id")
	@JsonIgnoreProperties("detailDepartments")
	private Address address;
	
	public DetailDepartment() {
	}

	
	public int getEmulationPoint() {
		return emulationPoint;
	}

	public void setEmulationPoint(int emulationPoint) {
		this.emulationPoint = emulationPoint;
	}

	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "DetailDepartment [emulationPoint=" + emulationPoint + ", address=" + address.getAddressName() + ", getDepartmentName()="
				+ getDepartmentName() + "]";
	}


	


	








	
	

	

	
	

	

	

	

	

	

		
}