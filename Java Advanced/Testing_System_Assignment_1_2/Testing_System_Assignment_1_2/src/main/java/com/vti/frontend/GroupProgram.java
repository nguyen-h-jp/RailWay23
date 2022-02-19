package com.vti.frontend;

import com.vti.repository.GroupRepository;

public class GroupProgram {
	public static void main(String[] args) {
		


		GroupRepository groupRepository = new GroupRepository();

//		System.out.println("***********GET ALL GROUPS***********");
//		List<Group> groups = groupRepository.getAllGroups();
//		for (Group group : groups) {
//			System.out.println(group);
//		}
		
		
//		System.out.println("***********CREATE GROUP***********");
//		Group group1 = new Group();
//		group1.setGroupName("test3");
//		Date date = new Date();
//		group1.setCreateDate(date);
//		groupRepository.createGroup(group1);
		
//		System.out.println("***********GET GROUP BY ID***********");
//		Group group = new Group();
//		group = groupRepository.getGroupByID((short)1);
//		System.out.println(group);
		
//		System.out.println("***********GET GROUP BY NAME***********");
//		Group group = new Group();
//		group = groupRepository.getGroupByName("VTI Sale 03");
//		System.out.println(group);
		
//		System.out.println("***********UPDATE GROUP BY ID***********");
//		groupRepository.updateGroup((short)10, "Test5");;
		
//		System.out.println("***********UPDATE GROUP 2***********");
//		Group group = new Group();
//		group.setGroupId((short)1);
//		group.setGroupName("Fixed Group");
//		groupRepository.updateGroup(group);
		
		
//		System.out.println("***********DELETE GROUP***********");
//		groupRepository.deleteGroup((short)3);
		
//		System.out.println("***********IS GROUP EXIST BY ID***********");
//		boolean check = false;
//		check = groupRepository.isGroupExistsByID((short)1);
//		System.out.println(check);
		
		System.out.println("***********IS GROUP EXIST BY NAME***********");
		boolean check = false;
		check = groupRepository.isGroupExistsByName("VTI Sale 031");
		System.out.println(check);
	}
}
