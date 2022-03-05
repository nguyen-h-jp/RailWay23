package com.vti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vti.entity.Address;
import com.vti.repository.IAddressRepository;

@Service
public class AddressService implements IAddressService {

	@Autowired
	private IAddressRepository repository;

	public Page<Address> getAllAddresss(Pageable pagable) {
		// TODO Auto-generated method stub
		return repository.findAll(pagable);
	}
	
	public Address findByAddressName(String name) {
		return repository.findByAddressName(name);
	}

	public Address getAddressByID(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}
//	
//	public Address getAddressByName(String name) {
//		// TODO Auto-generated method stub
//		return repository.findByAddressName(name);
//	}
//
	public void createAddress(Address address) {
		// TODO Auto-generated method stub
		repository.save(address);
		
	}
//
	public void updateAddress(Address address) {
		// TODO Auto-generated method stub
		repository.save(address);
		
	}
//
	public void deleteAddress(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}
//	
	public boolean isAddressExistsByID(int id) {
		// TODO Auto-generated method stub
		return repository.existsById(id);
	}
//
//	public boolean isAddressExistsByName(String name) {
//		// TODO Auto-generated method stub
//		return repository.existsByAddressName(name);
//	}


	

	


}

