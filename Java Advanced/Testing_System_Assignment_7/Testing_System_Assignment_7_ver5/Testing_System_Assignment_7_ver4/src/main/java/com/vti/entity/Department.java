package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "department")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "departmentID")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "department_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int departmentID;

	@Column(name = "department_name", length = 30, nullable = false, unique = true)
	private String departmentName;
	
	@OneToMany(mappedBy = "department")
	@JsonIgnoreProperties("department")
	private List<Account> accounts;

//	public int getDepartmentID() {
//		return departmentID;
//	}
//
//	public void setDepartmentID(int departmentID) {
//		this.departmentID = departmentID;
//	}
//
//	public String getDepartmentName() {
//		return departmentName;
//	}
//
//	public void setDepartmentName(String departmentName) {
//		this.departmentName = departmentName;
//	}
//
//	
//	public List<Account> getAccounts() {
//		return accounts;
//	}
//
//	public void setAccounts(List<Account> account) {
//		this.accounts = account;
//	}

	@Override
	public String toString() {
		return "Department [departmentID=" + departmentID + ", departmentName=" + departmentName + "]";
	}
	




	
}
