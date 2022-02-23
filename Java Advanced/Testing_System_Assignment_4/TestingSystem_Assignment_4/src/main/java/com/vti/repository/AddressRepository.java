package com.vti.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Address;
import com.vti.utils.HibernateUtils;

public class AddressRepository {

	private HibernateUtils hibernateUtils;

	public AddressRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Address> getAllAddresss() {

		Session session = null;
		List<Address> list = new ArrayList<Address>();

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query
			list = (List<Address>) session.createQuery("FROM Address").list();
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

	public Address getAddressByID(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// get address by id
			Address address = session.get(Address.class, id);

			return address;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public Address getAddressByName(String name) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Address> query = session.createQuery("FROM Address WHERE name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			Address address = query.uniqueResult();

			return address;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createAddress(Address address) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create
			session.save(address);

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateAddress(short id, String newName) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get address
			Address address = (Address) session.load(Address.class, id);

			// update
			address.setAddressName(newName);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateAddress(Address address) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(address);
			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteAddress(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get address
			Address address = (Address) session.load(Address.class, id);

			// delete
			session.delete(address);
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

	public boolean isAddressExistsByID(short id) {

		// get address
		Address address = getAddressByID(id);

		// return result
		if (address == null) {
			return false;
		}

		return true;
	}

	public boolean isAddressExistsByName(String name) {
		Address address = getAddressByName(name);

		if (address == null) {
			return false;
		}
		return true;
	}

}
