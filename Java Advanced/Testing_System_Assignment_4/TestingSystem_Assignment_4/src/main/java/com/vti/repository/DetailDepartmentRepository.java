package com.vti.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.DetailDepartment;
import com.vti.utils.HibernateUtils;

public class DetailDepartmentRepository {

	private HibernateUtils hibernateUtils;

	public DetailDepartmentRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<DetailDepartment> getAllDetailDepartments() {

		Session session = null;
		List<DetailDepartment> list = new ArrayList<DetailDepartment>();

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query
			list = (List<DetailDepartment>) session.createQuery("FROM DetailDetailDepartment").list();
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

	public DetailDepartment getDetailDepartmentByID(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// get detailDepartment by id
			DetailDepartment detailDepartment = session.get(DetailDepartment.class, id);

			return detailDepartment;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public DetailDepartment getDetailDepartmentByName(String name) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<DetailDepartment> query = session.createQuery("FROM DetailDepartment WHERE name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			DetailDepartment detailDepartment = query.uniqueResult();

			return detailDepartment;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createDetailDepartment(DetailDepartment detailDepartment) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create
			session.save(detailDepartment);

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}


	public void updateDetailDepartment(DetailDepartment detailDepartment) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(detailDepartment);
			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteDetailDepartment(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get detailDepartment
			DetailDepartment detailDepartment = (DetailDepartment) session.load(DetailDepartment.class, id);

			// delete
			session.delete(detailDepartment);
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

	public boolean isDetailDepartmentExistsByID(short id) {

		// get detailDepartment
		DetailDepartment detailDepartment = getDetailDepartmentByID(id);

		// return result
		if (detailDepartment == null) {
			return false;
		}

		return true;
	}

	public boolean isDetailDepartmentExistsByName(String name) {
		DetailDepartment detailDepartment = getDetailDepartmentByName(name);

		if (detailDepartment == null) {
			return false;
		}
		return true;
	}

}
