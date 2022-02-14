package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "salary")
public class Salary implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "salaryID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short salaryID;

	@Column(name = "salaryName", nullable = false)
	@Convert(converter = SalaryConverter.class)
	private SalaryName salaryName;

	public Salary() {
	}



	public short getSalaryID() {
		return salaryID;
	}



	public void setSalaryID(short salaryID) {
		this.salaryID = salaryID;
	}



	public SalaryName getSalaryName() {
		return salaryName;
	}



	public void setSalaryName(SalaryName salaryName) {
		this.salaryName = salaryName;
	}

	


	@Override
	public String toString() {
		return "Salary [salaryID=" + salaryID + ", salaryName=" + salaryName + "]";
	}




	public enum SalaryName {
		A("600"), B("700"), C("1500");

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
