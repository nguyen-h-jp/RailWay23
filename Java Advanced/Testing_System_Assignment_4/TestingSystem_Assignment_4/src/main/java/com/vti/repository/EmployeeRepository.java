package com.vti.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Employee;
import com.vti.utils.HibernateUtils;

public class EmployeeRepository {

	private HibernateUtils hibernateUtils;

	public EmployeeRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {

		Session session = null;
		List<Employee> list = new ArrayList<Employee>();

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query
			list = (List<Employee>) session.createQuery("FROM Employee").list();
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

	public Employee getEmployeeByID(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// get employee by id
			Employee employee = session.get(Employee.class, id);

			return employee;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public Employee getEmployeeByName(String name) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Employee> query = session.createQuery("FROM Employee WHERE name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			Employee employee = query.uniqueResult();

			return employee;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createEmployee(Employee employee) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create
			session.save(employee);

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}


	public void updateEmployee(Employee employee) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(employee);
			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteEmployee(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get employee
			Employee employee = (Employee) session.load(Employee.class, id);

			// delete
			session.delete(employee);
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

	public boolean isEmployeeExistsByID(short id) {

		// get employee
		Employee employee = getEmployeeByID(id);

		// return result
		if (employee == null) {
			return false;
		}

		return true;
	}

	public boolean isEmployeeExistsByName(String name) {
		Employee employee = getEmployeeByName(name);

		if (employee == null) {
			return false;
		}
		return true;
	}

}
