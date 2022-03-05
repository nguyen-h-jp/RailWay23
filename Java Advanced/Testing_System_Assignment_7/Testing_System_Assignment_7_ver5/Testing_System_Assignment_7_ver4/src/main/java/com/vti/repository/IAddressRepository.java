package com.vti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vti.entity.Address;

public interface IAddressRepository extends JpaRepository<Address, Integer> {

	public Address findByAddressName(String name);

	// @Query Annotation
	@Query("SELECT a FROM Address a")
	public List<Address> getAllAddresss();

//	
//	public void createAddress(Address address);
//	
//	public void updateAddress(int id, String newName);
//
//	public void updateAddress(Address address);
//
//	public void deleteByAddressID(int id);
//	
//	public boolean existsByAddressName(String name);
//
//	public boolean isAddressExistsByID(int id);

}
