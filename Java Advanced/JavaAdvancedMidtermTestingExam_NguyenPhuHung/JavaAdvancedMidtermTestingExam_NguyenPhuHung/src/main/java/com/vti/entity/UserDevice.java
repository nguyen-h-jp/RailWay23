package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user_device")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class UserDevice implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserDeviceKey id;

	@ManyToOne
	@MapsId("user_id")
	@JoinColumn(name = "user_id")
	@JsonIgnoreProperties("userDevices")
	private User user;

	@ManyToOne
	@MapsId("device_id")
	@JoinColumn(name = "device_id")
	@JsonIgnoreProperties("userDevices")
	private Device device;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "register_date", nullable = false, updatable = false)
	@CreationTimestamp
	private Date registerDate;

	
	@Embeddable
	public static class UserDeviceKey implements Serializable {

		private static final long serialVersionUID = 1L;

		@Column(name = "user_id", nullable = false)
		private int userID;

		@Column(name = "device_id", nullable = false)
		private int deviceID;

		public UserDeviceKey() {
		}

		public int getUserID() {
			return userID;
		}

		public void setUserID(int userID) {
			this.userID = userID;
		}

		public int getDeviceID() {
			return deviceID;
		}

		public void setDeviceID(int deviceID) {
			this.deviceID = deviceID;
		}
	}
}
