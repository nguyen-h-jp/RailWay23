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
@Table(name = "`position`")
public class Position implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "positionID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short positionID;

	@Column(name = "positionName", length = 50, nullable = false, unique = true)
	private String title;

	@Column(name = "positionName", nullable = false)
	@Convert(converter = PositionNameConverter.class)
	private PositionName positionName;

	public Position() {
	}



	public short getPositionID() {
		return positionID;
	}



	public void setPositionID(short positionID) {
		this.positionID = positionID;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public PositionName getPositionName() {
		return positionName;
	}



	public void setPositionName(PositionName positionName) {
		this.positionName = positionName;
	}



	@Override
	public String toString() {
		return "Position [positionID=" + positionID + ", title=" + title + ", positionName=" + positionName + "]";
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
