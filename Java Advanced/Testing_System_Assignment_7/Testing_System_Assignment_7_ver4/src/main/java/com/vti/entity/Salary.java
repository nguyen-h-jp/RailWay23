package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "salary")
public class Salary implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "salary_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int salaryID;

	@Column(name = "salary_name", nullable = false)
	@Convert(converter = SalaryConverter.class)
	private SalaryName salaryName;
	
	@OneToMany(mappedBy = "salary")
	@JsonIgnoreProperties("salary")
	private List<Account> accounts;

	public Salary() {
	}

	public int getSalaryID() {
		return salaryID;
	}

	public void setSalaryID(int salaryID) {
		this.salaryID = salaryID;
	}

	public SalaryName getSalaryName() {
		return salaryName;
	}

	public void setSalaryName(SalaryName salaryName) {
		this.salaryName = salaryName;
	}

	

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Salary [salaryID=" + salaryID + ", salaryName=" + salaryName + "]";
	}



	public enum SalaryName {
		A("600"), B("700"), C("1500"), D("2000");

		private String salaryName;

		private SalaryName(String salaryName) {
			this.salaryName = salaryName;
		}

		public String getSalaryName() {
			return salaryName;
		}

		public static SalaryName toEnum(String sqlSalaryName) {
			for (SalaryName item : SalaryName.values()) {
				if (item.getSalaryName().equals(sqlSalaryName)) {
					return item;
				}
			}
			return null;
		}
	}
}
