package com.vti.frontend;

import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Address;
import com.vti.repository.AddressRepository;

public class AddressProgram {
	public static void main(String[] args) {
		
		AddressRepository addressRepository = new AddressRepository();
		
		List<Address> list = new ArrayList<Address>();
		list = addressRepository.getAllAddresss();
		for (Address address : list) {
			// danh sach address
			System.out.println(address);
		}
	}
}
