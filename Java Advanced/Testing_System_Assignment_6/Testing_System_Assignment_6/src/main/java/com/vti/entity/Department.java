package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	
	@OneToMany(mappedBy = "department")
//	@JsonBackReference
//	@JsonManagedReference
	@JsonIgnoreProperties("department")
	private List<Account> account;

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

	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Department [departmentID=" + departmentID + ", departmentName=" + departmentName + ", account="
				+ account + "]";
	}

	
}
