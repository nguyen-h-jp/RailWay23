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
@Table(name = "`position`")
public class Position implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "position_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int positionID;

//	@Column(name = "position_name", length = 50, nullable = false, unique = true)
//	private String title;

	@Column(name = "position_name", nullable = false)
	@Convert(converter = PositionNameConverter.class)
	private PositionName positionName;

	@OneToMany(mappedBy = "position")
	@JsonIgnoreProperties("position")
	private List<Account> accounts;
	
	public Position() {
	}


	public int getPositionID() {
		return positionID;
	}

	public void setPositionID(int positionID) {
		this.positionID = positionID;
	}

	public PositionName getPositionName() {
		return positionName;
	}

	public void setPositionName(PositionName positionName) {
		this.positionName = positionName;
	}
	

	public List<Account> getAccounts() {
		return accounts;
	}


	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}


	@Override
	public String toString() {
		return "Position [positionID=" + positionID + ", positionName=" + positionName + "]";
	}

	public enum PositionName {
		DEV("Dev"), TEST("Test"), SCRUM_MASTER("ScrumMaster"), PM("PM");

		private String positionName;

		private PositionName(String positionName) {
			this.positionName = positionName;
		}

		public String getPositionName() {
			return positionName;
		}

		public static PositionName toEnum(String sqlPositionName) {
			for (PositionName item : PositionName.values()) {
				if (item.getPositionName().equals(sqlPositionName)) {
					return item;
				}
			}
			return null;
		}
	}
}
