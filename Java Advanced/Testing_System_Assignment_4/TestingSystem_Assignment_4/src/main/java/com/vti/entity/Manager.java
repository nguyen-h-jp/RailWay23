package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "`manager`")
@PrimaryKeyJoinColumn(name = "account_id")
public class Manager extends Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "management_number_of_year", nullable = false)
	private int managementNumberOfYear;

	public Manager() {
	}

	public int getManagementNumberOfYear() {
		return managementNumberOfYear;
	}

	public void setManagementNumberOfYear(int managementNumberOfYear) {
		this.managementNumberOfYear = managementNumberOfYear;
	}


	@Override
	public String toString() {
		return "Manager [managementNumberOfYear=" + managementNumberOfYear + ", getAccountID()=" + getAccountID()
				+ ", getEmail()=" + getEmail() + ", getUsername()=" + getUsername() + ", getFirstName()="
				+ getFirstName() + ", getLastName()=" + getLastName() + ", getCreateDate()=" + getCreateDate()
				+ ", getDepartment()=" + getDepartment().getDepartmentName() + ", getPosition()=" + getPosition().getPositionName() + ", getSalary()="
				+ getSalary().getSalaryName() + "]";
	}

	

	

	


	
	
	
	
}