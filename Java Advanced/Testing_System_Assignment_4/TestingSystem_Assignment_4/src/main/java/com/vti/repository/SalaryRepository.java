package com.vti.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Salary;
import com.vti.utils.HibernateUtils;

public class SalaryRepository {

	private HibernateUtils hibernateUtils;

	public SalaryRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Salary> getAllSalarys() {

		Session session = null;
		List<Salary> list = new ArrayList<Salary>();

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query
			list = (List<Salary>) session.createQuery("FROM Salary").list();
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

	public Salary getSalaryByID(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// get salary by id
			Salary salary = session.get(Salary.class, id);

			return salary;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public Salary getSalaryByName(String name) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Salary> query = session.createQuery("FROM Salary WHERE name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			Salary salary = query.uniqueResult();

			return salary;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createSalary(Salary salary) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create
			session.save(salary);

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}


	public void updateSalary(Salary salary) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(salary);
			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteSalary(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get salary
			Salary salary = (Salary) session.load(Salary.class, id);

			// delete
			session.delete(salary);
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

	public boolean isSalaryExistsByID(short id) {

		// get salary
		Salary salary = getSalaryByID(id);

		// return result
		if (salary == null) {
			return false;
		}

		return true;
	}

	public boolean isSalaryExistsByName(String name) {
		Salary salary = getSalaryByName(name);

		if (salary == null) {
			return false;
		}
		return true;
	}

}
