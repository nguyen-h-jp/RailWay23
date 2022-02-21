/**
 * Description: 
 */
package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "`employee`")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "account_id")
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short accountID;

	@Column(name = "working_number_of_year", nullable = false)
	private short workingNumberOfYear;

	@OneToOne
	@JoinColumn(name = "account_id", referencedColumnName = "account_id")
	private Account account;

	public Employee() {
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(short accountID) {
		this.accountID = accountID;
	}

	public int getWorkingNumberOfYear() {
		return workingNumberOfYear;
	}

	public void setWorkingNumberOfYear(short workingNumberOfYear) {
		this.workingNumberOfYear = workingNumberOfYear;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Employee [accountID=" + accountID + ", workingNumberOfYear=" + workingNumberOfYear + ", account="
				+ account.getUsername() + "]";
	}


	

}