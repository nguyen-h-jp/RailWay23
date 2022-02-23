package com.vti.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Address;
import com.vti.entity.Department;
import com.vti.entity.DetailDepartment;
import com.vti.utils.HibernateUtils;

public class DepartmentRepositoryCriteria {

	private HibernateUtils hibernateUtils;

	public DepartmentRepositoryCriteria() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	// a. createDepartments()
	public void createDepartment(Department department) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(department);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

//	b. getAllDepartments()
//	Chú ý: Chỉ viết 1 method và thực hiện được các yêu cầu dưới đây:
//	o Method sẽ return ra object departmentDTO chỉ chứa 3 field: id,
//	name, address của department
//	o Có 1 thể sort được theo field name
//	o Có tham số pageNumber và pageSize để cho phép người dùng
//	có thể paging
//	o Có thể search theo field name
//	o Có thể Filter cho phép người dùng nhập vào 1 số dương và kết
//	quả trả ra là các record department có EmulationPoints lớn hơn
//	số người dùng nhập vào
//	Gợi ý:
//	o Search theo field name
//	Nếu user field name != null thì sẽ thêm điều kiện vào where,
//	nếu không thì sẽ giống get all bình thường
//	o Filter
//	Nếu user field EmulationPoints != null thì sẽ thêm điều kiện
//	vào where, nếu không thì sẽ giống get all bình thường

	@SuppressWarnings("unchecked")
	public List<DepartmentDTO> getAllDepartmentsUsingConstructor(int pageNumber, int pageSize, String departmentName,
			Integer emulationPoint) {

		Session session = null;
		List<DepartmentDTO> results = new ArrayList<DepartmentDTO>();

		try {

			// get session
			session = hibernateUtils.openSession();

			Criteria criteria = session.createCriteria(DetailDepartment.class);

//			String hql = "SELECT new com.vti.dto.DepartmentDTO(d.departmentID, d.departmentName, d.address.addressName) FROM DetailDepartment d";

			// search theo field name
			if (departmentName != null) {
				criteria.add(Restrictions.ilike("departmentName", "%" + departmentName + "%"));
			}

			// filter
			if (emulationPoint != null) {
				criteria.add(Restrictions.gt("emulationPoint", emulationPoint));
			}

			// sort by name

			criteria.addOrder(Order.asc("departmentName"));

			List<DetailDepartment> resultsTemp = criteria.list();
			for (DetailDepartment detailDepartment : resultsTemp) {
				DepartmentDTO departmentDTO = new DepartmentDTO(detailDepartment.getDepartmentID(),
						detailDepartment.getDepartmentName(), detailDepartment.getAddress().getAddressName());
				results.add(departmentDTO);
			}

			int offset = (pageNumber - 1) * pageSize;
			int limit = pageSize;

			criteria.setFirstResult(offset);
			criteria.setMaxResults(limit);

			return results;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

//	c. getTotalCount()
//	Trả về tổng số bản ghi của Department
//	Chú ý: tương tự câu b, có thể truyền vào search theo field name và
//	Filter EmulationPoints

	@SuppressWarnings("unchecked")
	public Long getTotalCount(String departmentName, Integer emulationPoint) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			String hql = "SELECT COUNT(*) FROM DetailDepartment d";

			// search theo field name
			if (departmentName != null) {
				hql += " WHERE departmentName LIKE :departmentName";

			}

			// filter
			if (emulationPoint != null) {
				hql += " AND emulationPoint > :emulationPoint";

			}

			// sort by name

			hql += " ORDER BY d.departmentName ASC";

			// create hql query
			Query<Long> query = session.createQuery(hql);

			query.setParameter("departmentName", "%" + departmentName + "%");
			query.setParameter("emulationPoint", emulationPoint);

			return query.uniqueResult();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

//	d. getDepartmentByID()
//	tương tự với câu b nhưng không cần sort, paging
	public Department getDepartmentByID(int id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// get department by id
			Department department = session.get(Department.class, id);

			return department;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<Department> getAllDepartments() {

		Session session = null;
		List<Department> list = new ArrayList<Department>();

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query
			list = (List<Department>) session.createQuery("FROM Department").list();
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

//	e. getDepartmentByName()
	@SuppressWarnings("unchecked")
	public Department getDepartmentByName(String name) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Department> query = session.createQuery("FROM Department WHERE department_name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			Department department = query.uniqueResult();

			return department;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

//	f. updateDepartment()
//	Chú ý: sử dụng transaction, cho phép update được cả address,
//	EmulationPoints

	public void updateDepartment(int departmentID, String departmentName, Integer addressID, Integer emulationPoint) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			String hql = "UPDATE DetailDepartment SET departmentName = :departmentName, emulationPoint = :emulationPoint, address = :address WHERE departmentID = :departmentID";

			// create hql query

			Query query = session.createQuery(hql);

			// set parameter
			query.setParameter("departmentName", departmentName);
			query.setParameter("departmentName", departmentName);

//			Address address = new Address();
//			address.setAddressID(addressID);
//			address.setAddressName("P599");
			Address address = new Address(addressID, "P599");

			query.setParameter("address", address);
			query.setParameter("emulationPoint", emulationPoint);
			query.setParameter("departmentID", departmentID);

			//

			// get result
			int result = query.executeUpdate();

			session.getTransaction().commit();

		} catch (Exception e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateDepartment(Department department) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(department);
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

//	g. deleteDepartment()
//	Có thể delete 1 department hoặc nhiều department theo ID
//	Chú ý: sử dụng transaction

	public void deleteDepartment(Integer departmentID) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			String hql = "DELETE FROM DetailDepartment WHERE departmentID = :departmentID";

			// create hql query
			Query query = session.createQuery(hql);

			// set tham so
			query.setParameter("departmentID", departmentID);

			int result = query.executeUpdate();
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

//	h. isDepartmentExistsByID()

	public boolean isDepartmentExistsByID(short id) {

		// get department
		Department department = getDepartmentByID(id);

		// return result
		if (department == null) {
			return false;
		}

		return true;
	}

//	i. isDepartmentExistsByName()
	public boolean isDepartmentExistsByName(String name) {
		Department department = getDepartmentByName(name);

		if (department == null) {
			return false;
		}
		return true;
	}

}
