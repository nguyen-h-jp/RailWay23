package com.vti.backend;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Department;
import com.vti.utils.JDBCUtils;

public class DepartmentRepository {

	/**
	 * lấy danh sách department
	 */
	public List<Department> getDepartments() throws SQLException {
		List<Department> listDepartment = new ArrayList<Department>();
		// tạo một đối tượng statement
		String sql = "SELECT department_id, department_name FROM department;";
		Statement statement = JDBCUtils.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		if (listDepartment.size() != 0) {
			listDepartment.clear();
		}
		while (resultSet.next()) {
			listDepartment
					.add(new Department(resultSet.getInt("department_id"), resultSet.getString("department_name")));
		}
		return listDepartment;
	}

	/**
	 * tìm department theo department id
	 */
	public Department getDepartmentByID(int id) throws SQLException {
		Department department = null;
		// tạo một đối tượng statement
		String sql = "SELECT * FROM department where department_id = ?;";
		PreparedStatement preparedStatement = JDBCUtils.createPreparedStatement(sql);
		preparedStatement.setInt(1, id);
		// thực hiện truy vấn sql
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			String departmentName = resultSet.getString("department_name");
			department = new Department(id, departmentName);
		}
		return department;
	}

	/**
	 * kiểm tra department có tồn tại không(kiểm tra theo department name)
	 */
	public boolean isDepartmentNameExists(String name) throws SQLException {
		int countCheck = 0;
		for (Department department : getDepartments()) {
			if (department.getDepartmentName().equals(name)) {
				countCheck++;
			}
		}
		if (countCheck != 0) {
			return true;
		} else
			return false;
	}

	/**
	 * kiểm tra department có tồn tại không(kiểm tra theo department id)
	 */
	public boolean isDepartmenIdExists(int id) throws SQLException {
		int countCheck = 0;
		for (Department department : getDepartments()) {
			if (department.getDepartmentID() == id) {
				countCheck++;
			}
		}
		if (countCheck != 0) {
			return true;
		} else
			return false;
	}

}
