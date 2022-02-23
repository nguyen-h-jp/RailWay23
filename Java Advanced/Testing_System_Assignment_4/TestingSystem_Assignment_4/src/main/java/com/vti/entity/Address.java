/**
 * Description: 
 */
package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "address_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressID;
	
	@Column(name = "address_name", length = 100, nullable = false, unique = true)
	private String addressName;
	
	@OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
	private List<DetailDepartment> detailDepartments;
	
	public Address() {
	}
	
	public Address(Integer addressID, String addressName) {
		this.addressID = addressID;
		this.addressName = addressName;
	}

	public int getAddressID() {
		return addressID;
	}

	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public List<DetailDepartment> getDetailDepartments() {
		return detailDepartments;
	}

	public void setDetailDepartments(List<DetailDepartment> detailDepartments) {
		this.detailDepartments = detailDepartments;
	}

	@Override
	public String toString() {
		return "Address [addressID=" + addressID + ", addressName=" + addressName + ", detailDepartments="
				+ detailDepartments + "]";
	}

	

	
}