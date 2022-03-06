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
@Table(name = "`user`")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "user_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userID;

	@Column(name = "full_name", length = 100, nullable = false)
	private String fullName;

	@Column(name = "email", length = 50, nullable = false, unique = true)
	private String email;

	@Column(name = "phone", length = 15, nullable = false, unique = true)
	private String phone;

	@Column(name = "`password`", length = 30, nullable = false)
	private String password;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnoreProperties("user")
	private List<UserDevice> userDevices;

}
