package com.vti.repository;

import java.util.List;

import com.vti.entity.Device;

public interface IDeviceRepository {

	// lấy danh sách thiết bị
	public List<Device> getAllDevices();
	
	// thêm mới thiết bị
	public void createDevice(Device device);

}
