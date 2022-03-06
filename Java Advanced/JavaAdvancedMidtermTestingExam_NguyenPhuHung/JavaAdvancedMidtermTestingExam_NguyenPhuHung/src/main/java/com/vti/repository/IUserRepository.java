package com.vti.repository;

import com.vti.entity.User;

public interface IUserRepository {

	public User getUserByEmailPassword(String email, String password);

	// đăng kí tài khoản cho nhân viên
	public void createUser(User user);
	
	public  User getUserByName(String name);
}
