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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "device")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Device implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "device_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deviceID;

	@Column(name = "device_name", length = 50, nullable = false, unique = true)
	private String deviceName;
	
	@Column(name = "quantity")
	private int quantity;
	
	@OneToMany(mappedBy = "device")
	@JsonIgnoreProperties("device")
	private List<UserDevice> userDevices;	
}
