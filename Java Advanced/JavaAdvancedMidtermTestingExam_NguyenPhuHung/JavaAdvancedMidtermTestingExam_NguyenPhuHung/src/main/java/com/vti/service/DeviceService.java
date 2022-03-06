package com.vti.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Device;
import com.vti.entity.User;
import com.vti.entity.UserDevice;
import com.vti.repository.IDeviceRepository;
import com.vti.repository.IUserRepository;

@Service
public class DeviceService implements IDeviceService {

	@Autowired
	private IDeviceRepository deviceRepository;
	
	@Autowired
	private IUserRepository userRepository;

	public List<Device> getAllDevices() {
		return deviceRepository.getAllDevices();
	}
	
	public void createDevice(Device device) {
		deviceRepository.createDevice(device);
	}
	
	public List<Device> getDeviceListByFullName(String userFullName, String yearMonth) {
		List<Device> results = new ArrayList<Device>();
		User user = userRepository.getUserByName(userFullName);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
		for(UserDevice userDevice : user.getUserDevices()) {
			// chuyển định dạng ngày sang yyyy-MM
			String registerDate = dateFormat.format(userDevice.getRegisterDate());	
			if( yearMonth.equals(registerDate)) {
				results.add(userDevice.getDevice());	
			}
		}
		return results;
	}
}
