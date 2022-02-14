package com.vti;

import java.util.List;

import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
//import com.vti.repository.ArticleRepository;
import com.vti.repository.DepartmentRepository;
import com.vti.repository.GroupRepository;

public class Program {
	public static void main(String[] args) {
		

//		DepartmentRepository repository = new DepartmentRepository();
//
//		System.out.println("***********GET ALL DEPARTMENTS***********");
//
//		List<Department> departments = repository.getAllDepartments();
//		System.out.println(departments);

		GroupRepository groupRepository = new GroupRepository();

		System.out.println("***********GET ALL GROUPS***********");
		List<Group> groups = groupRepository.getAllGroups();
		for (Group group : groups) {
			System.out.println(group);
		}
//		System.out.println(group);
//		Group group = groupRepository.getGroupByID((short) 1);
//		System.out.println("***********CREATE GROUP***********");
//		
//		Group group2 = new Group();
//		group2.setGroupID((short)11);
//		group2.setGroupName("test");
//		groupRepository.createGroup(group2);

//		System.out.println("\n\n***********CREATE ARTICLE***********");
//
//		Position article = new Position();
//		article.setTitle("Article 6");
//		article.setStatus(Position.Status.OPEN);
//		repository.createArticle(article);

	}
}
