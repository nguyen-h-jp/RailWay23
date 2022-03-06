package com.vti.service;

import java.util.List;

import com.vti.entity.Device;

public interface IDeviceService {

	public List<Device> getAllDevices();

	public void createDevice(Device device);
	
	// lấy danh sách thiết bị theo full name
	public List<Device> getDeviceListByFullName(String userFullName, String yearMonth);

}
