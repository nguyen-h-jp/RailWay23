package com.vti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.LoginDTO;
import com.vti.dto.UserDTO;
import com.vti.entity.User;
import com.vti.service.IUserService;

@RestController
@RequestMapping(value = "api/v1/users")
public class UserController {

	@Autowired
	private IUserService service;

	@PostMapping()
	public void createUser(@RequestBody User User) {
		service.createUser(User);
	}

	@PostMapping(value = "/login")
	public UserDTO login(@RequestBody LoginDTO userLogin) {
		return service.getUserByEmailPassword(userLogin.getEmail(), userLogin.getPassword());
	}

}
