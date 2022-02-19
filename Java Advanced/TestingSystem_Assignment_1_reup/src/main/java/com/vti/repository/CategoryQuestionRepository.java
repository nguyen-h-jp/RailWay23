package com.vti.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.CategoryQuestion;
import com.vti.entity.Department;
import com.vti.utils.HibernateUtils;

public class CategoryQuestionRepository {

	private HibernateUtils hibernateUtils;

	public CategoryQuestionRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<CategoryQuestion> getAllCategoryQuestions() {

		Session session = null;
		List<CategoryQuestion> list = new ArrayList<CategoryQuestion>();

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query
			list = (List<CategoryQuestion>) session.createQuery("FROM CategoryQuestion").list();
			session.getTransaction().commit();

		} catch (Exception e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		}

		finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

//	public Department getDepartmentByID(short id) {
//
//		Session session = null;
//
//		try {
//
//			// get session
//			session = hibernateUtils.openSession();
//
//			// get department by id
//			Department department = session.get(Department.class, id);
//
//			return department;
//
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//	}

//	@SuppressWarnings("unchecked")
//	public Department getDepartmentByName(String name) {
//
//		Session session = null;
//
//		try {
//
//			// get session
//			session = hibernateUtils.openSession();
//
//			// create hql query
//			Query<Department> query = session.createQuery("FROM Department WHERE name = :nameParameter");
//
//			// set parameter
//			query.setParameter("nameParameter", name);
//
//			// get result
//			Department department = query.uniqueResult();
//
//			return department;
//
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//	}

	public void createCategoryQuestion(CategoryQuestion categoryQuestion) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create
			session.save(categoryQuestion);

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

//	public void updateDepartment(short id, String newName) {
//
//		Session session = null;
//
//		try {
//
//			// get session
//			session = hibernateUtils.openSession();
//			session.beginTransaction();
//
//			// get department
//			Department department = (Department) session.load(Department.class, id);
//
//			// update
//			department.setDepartmentName(newName);
//
//			session.getTransaction().commit();
//
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//	}

	public void updateDepartment(Department department) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(department);
			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteDepartment(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department
			Department department = (Department) session.load(Department.class, id);

			// delete
			session.delete(department);
			session.getTransaction().commit();

		} catch (Exception e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		}

		finally {
			if (session != null) {
				session.close();
			}
		}
	}

//	public boolean isDepartmentExistsByID(short id) {
//
//		// get department
//		Department department = getDepartmentByID(id);
//
//		// return result
//		if (department == null) {
//			return false;
//		}
//
//		return true;
//	}
//
//	public boolean isDepartmentExistsByName(String name) {
//		Department department = getDepartmentByName(name);
//
//		if (department == null) {
//			return false;
//		}
//		return true;
//	}

}
