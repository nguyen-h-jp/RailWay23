package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.vti.entity.Account;
import com.vti.utils.HibernateUtils;

@Repository
public class AccountRepository implements IAccountRepository {

	private HibernateUtils hibernateUtils;

	public AccountRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Account> getAllAccounts() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Account> query = session.createQuery("FROM Account order by id asc");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Account getAccountByID(int id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// get account by id
			Account account = session.get(Account.class, id);

			return account;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public Account getAccountByName(String name) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Account> query = session.createQuery("FROM Account WHERE name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			Account account = query.uniqueResult();

			return account;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createAccount(Account account) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(account);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateAccount(int id, String fullName) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get account
			Account account = (Account) session.load(Account.class, id);

			// update
			account.setFullName(fullName);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateAccount(Account account) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(account);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteAccount(int id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get account
			Account account = (Account) session.load(Account.class, id);

			// delete
			session.delete(account);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isAccountExistsByID(int id) {

		// get account
		Account account = getAccountByID(id);

		// return result
		if (account == null) {
			return false;
		}

		return true;
	}

	public boolean isAccountExistsByName(String name) {
		Account account = getAccountByName(name);

		if (account == null) {
			return false;
		}
		return true;
	}

}
