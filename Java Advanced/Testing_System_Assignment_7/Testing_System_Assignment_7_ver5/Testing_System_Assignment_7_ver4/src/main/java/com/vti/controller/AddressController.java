package com.vti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.Address;
import com.vti.service.IAddressService;

@RestController
@RequestMapping(value = "api/v1/addresss")
public class AddressController {

	@Autowired
	private IAddressService service;

	@GetMapping()
	public Page<Address> getAllAddresss(Pageable pagable) {
		return service.getAllAddresss(pagable);
	}
	
	@GetMapping(value = "/")
	public Address findByAddressName(@RequestParam(name = "name") String name) {
		return service.findByAddressName(name);
	}
	
	@GetMapping(value = "/{id}")
	public Address getAddressByID(@PathVariable(name = "id") Integer id) {
		return service.getAddressByID(id);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteAddress(@PathVariable(name = "id") int id) {
		service.deleteAddress(id);
	}
	
	@PutMapping(value = "/{id}")
	public void updateAddress(@PathVariable(name = "id") int id, @RequestBody Address address) {
		address.setAddressID(id);
		service.updateAddress(address);
	}
	
	@PostMapping()
	public void createAddress(@RequestBody Address address) {
		service.createAddress(address);
	}
	

}

