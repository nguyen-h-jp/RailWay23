package com.vti.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Manager;
import com.vti.utils.HibernateUtils;

public class ManagerRepository {

	private HibernateUtils hibernateUtils;

	public ManagerRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Manager> getAllManagers() {

		Session session = null;
		List<Manager> list = new ArrayList<Manager>();

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query
			list = (List<Manager>) session.createQuery("FROM Manager").list();
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

	public Manager getManagerByID(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// get manager by id
			Manager manager = session.get(Manager.class, id);

			return manager;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public Manager getManagerByName(String name) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Manager> query = session.createQuery("FROM Manager WHERE name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			Manager manager = query.uniqueResult();

			return manager;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createManager(Manager manager) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create
			session.save(manager);

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}


	public void updateManager(Manager manager) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(manager);
			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteManager(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get manager
			Manager manager = (Manager) session.load(Manager.class, id);

			// delete
			session.delete(manager);
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

	public boolean isManagerExistsByID(short id) {

		// get manager
		Manager manager = getManagerByID(id);

		// return result
		if (manager == null) {
			return false;
		}

		return true;
	}

	public boolean isManagerExistsByName(String name) {
		Manager manager = getManagerByName(name);

		if (manager == null) {
			return false;
		}
		return true;
	}

}
