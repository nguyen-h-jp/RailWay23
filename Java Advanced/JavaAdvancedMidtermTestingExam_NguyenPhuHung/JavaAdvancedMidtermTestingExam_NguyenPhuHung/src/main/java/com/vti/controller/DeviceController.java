package com.vti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.Device;
import com.vti.service.IDeviceService;

@RestController
@RequestMapping(value = "api/v1/devices")
public class DeviceController {

	@Autowired
	private IDeviceService service;

	// lấy danh sách thông tin thiết bị
	@GetMapping()
	public List<Device> getAllDevices() {
		return service.getAllDevices();
	}

	// thêm mới thiết bị
	@PostMapping()
	public void createDevice(@RequestBody Device device) {
		service.createDevice(device);
	}

	// lấy danh sách thiết bị theo full name và tháng năm
	@GetMapping(value = "/devicesByFullName")
	public List<Device> getDeviceListByFullName(@RequestParam(name = "userFullName") String userFullName,
			@RequestParam(name = "yearMonth") String yearMonth) {
		return service.getDeviceListByFullName(userFullName, yearMonth);
	}
}
