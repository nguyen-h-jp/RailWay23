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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "`account`")
@Inheritance(strategy = InheritanceType.JOINED)
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountID;

	@Column(name = "email", length = 50, nullable = false, unique = true)
	private String email;

	@Column(name = "full_name", length = 50, nullable = false, unique = true)
	private String fullName;
	
	@Column(name = "`password`", length = 50, nullable = false, unique = true)
	private String password;
	
	@Column(name = "confirm_password", length = 50, nullable = false, unique = true)
	private String confirmPassword;
	
	@Column(name = "phone", length = 50, nullable = false, unique = true)
	private String phone;
	
	@ManyToOne
//	@JsonManagedReference
//	@JsonBackReference
	@JsonIgnoreProperties("account")
	@JoinColumn(name = "department_id", referencedColumnName = "department_id")
	private Department department;


	public Account() {
	}


	public int getAccountID() {
		return accountID;
	}


	public void setAccountID(short accountID) {
		this.accountID = accountID;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", email=" + email + ", fullName=" + fullName + ", password="
				+ password + ", confirmPassword=" + confirmPassword + ", phone=" + phone + ", department=" + department
				+ "]";
	}


	

	


	

}