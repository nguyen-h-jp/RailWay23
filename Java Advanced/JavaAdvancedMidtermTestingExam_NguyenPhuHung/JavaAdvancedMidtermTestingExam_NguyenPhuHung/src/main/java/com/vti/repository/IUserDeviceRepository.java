package com.vti.repository;

import com.vti.entity.UserDevice;

public interface IUserDeviceRepository {

	// đăng kí mượn thiết bị cho nhân viên
	public void createUserDevice(UserDevice userDevice);
}
