package com.vti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.dto.UserDTO;
import com.vti.entity.User;
import com.vti.repository.IUserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepository repository;

	public UserDTO getUserByEmailPassword(String email, String password) {
		UserDTO userDTO = new UserDTO();
		User user = repository.getUserByEmailPassword(email, password);
		if(user == null) {
			userDTO.setMessage("login fail");
			userDTO.setUser(user);
		}else {
			userDTO.setMessage("login success");
			userDTO.setUser(user);
		}
		return userDTO;
	}

	public void createUser(User User) {
		repository.createUser(User);
	}
}
