package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "`manager`")
public class Manager implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "account_id")
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short groupId;

	@Column(name = "management_number_of_year", nullable = false)
	private int managementNumberOfYear;
	
	@OneToOne
	@JoinColumn(name = "account_id", referencedColumnName = "account_id")
	private Account account;

	public Manager() {
	}

	public short getGroupId() {
		return groupId;
	}

	public void setGroupId(short groupId) {
		this.groupId = groupId;
	}

	public int getManagementNumberOfYear() {
		return managementNumberOfYear;
	}

	public void setManagementNumberOfYear(int managementNumberOfYear) {
		this.managementNumberOfYear = managementNumberOfYear;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Manager [groupId=" + groupId + ", managementNumberOfYear=" + managementNumberOfYear + ", account="
				+ account.getUsername() + "]";
	}

	


	
	
	
	
}