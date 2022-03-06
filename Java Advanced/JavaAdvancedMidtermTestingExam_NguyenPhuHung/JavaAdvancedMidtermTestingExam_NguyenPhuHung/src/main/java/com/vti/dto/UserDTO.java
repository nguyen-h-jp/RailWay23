package com.vti.dto;

import com.vti.entity.User;

public class UserDTO {
	private String message;
	private User user;

	public UserDTO() {
	}

	public UserDTO(String message, User user) {
		this.message = message;
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserDTO [message=" + message + ", user=" + user + "]";
	}

}