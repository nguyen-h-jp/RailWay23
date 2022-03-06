package com.vti.service;

import com.vti.dto.UserDTO;
import com.vti.entity.User;

public interface IUserService {

	public UserDTO getUserByEmailPassword(String email, String password);

	public void createUser(User user);

}
