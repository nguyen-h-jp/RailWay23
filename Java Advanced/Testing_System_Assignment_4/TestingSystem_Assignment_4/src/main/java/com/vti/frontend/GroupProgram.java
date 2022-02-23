package com.vti.frontend;

import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Group;
import com.vti.repository.GroupRepository;

public class GroupProgram {
	public static void main(String[] args) {


		GroupRepository groupRepository = new GroupRepository();
		

		List<Group> list = new ArrayList<Group>();
		list = groupRepository.getAllGroups();
		for (Group group : list) {
			// danh sach group
			System.out.println(group);
		}
	}
}
