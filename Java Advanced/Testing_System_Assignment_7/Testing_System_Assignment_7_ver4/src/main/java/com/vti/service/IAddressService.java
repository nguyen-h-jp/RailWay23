package com.vti.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.entity.Address;

public interface IAddressService {

	public Page<Address> getAllAddresss(Pageable pagable);
	
	public Address findByAddressName(String name);
	
	public Address getAddressByID(Integer id);

//	public Address getAddressByID(Integer id);
//
//	public Address getAddressByName(String name);
//
	public void createAddress(Address address);
//
	public void updateAddress(Address address);
//
	public void deleteAddress(int id);
//
	public boolean isAddressExistsByID(int id);
//
//	public boolean isAddressExistsByName(String name);

}
