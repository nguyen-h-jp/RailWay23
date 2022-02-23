package com.vti.frontend;

import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Manager;
import com.vti.repository.ManagerRepository;

public class ManagerProgram {
	public static void main(String[] args) {

		ManagerRepository managerRepository = new ManagerRepository();
		

		List<Manager> list = new ArrayList<Manager>();
		list = managerRepository.getAllManagers();
		for (Manager manager : list) {
			// danh sach manager
			System.out.println(manager);
		}
	}
}
