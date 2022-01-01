package com.vti.backend.datalayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.backend.datalayer.interfaces.IDepartmentRepository;
import com.vti.entity.Department;
import com.vti.utils.JDBCUtils;

public class DepartmentRepository implements IDepartmentRepository {

	/**
	 * lấy danh sách department
	 */
	@Override
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
	@Override
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
	@Override
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
	@Override
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

	@Override
	public void createDepartment(String name) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateDepartmentName(int id, String newName) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteDepartment(int id) throws SQLException {
		// TODO Auto-generated method stub

	}

//	@Override
//	public void createDepartment(String name) throws SQLException {
//		if (isDepartmentNameExists(name)) {
//			System.out.println("Department đã tồn tại");
//		} else {
//			final String DB_URL = "jdbc:mysql://localhost:3306/testing_system?autoReconnect=true&useSSL=false&characterEncoding=latin1";
//			final String USER_NAME = "root";
//			final String PASSWORD = "root";
//			// đăng kí driver với driver manager
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
//			// tạo một đối tượng statement
//			String sql = "INSERT INTO `testing_system`.`department` (`department_name`) VALUES (?);";
//			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setString(1, name);
//			// thực hiện truy vấn sql
//			int effectedRecordAmount = preparedStatement.executeUpdate();
//			System.out.println("Số record bị ảnh hưởng: " + effectedRecordAmount);
//			// đóng kết nối
//			connection.close();
//		}
//	}

//	@Override
//	public void updateDepartmentName(int id, String newName) throws ClassNotFoundException, SQLException {
//		if (isDepartmenIdExists(id)) {
//			if (isDepartmentNameExists(newName)) {
//				System.out.println("Department này đã tồn tại");
//			} else {
//				final String DB_URL = "jdbc:mysql://localhost:3306/testing_system?allowMultiQueries=true";
//				final String USER_NAME = "root";
//				final String PASSWORD = "root";
//				// đăng kí driver với driver manager
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
//				// tạo một đối tượng statement
//				String sql = "ALTER DATABASE `testing_system` CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;"
//						+ "UPDATE `testing_system`.`department` SET `department_name` = ? WHERE (`department_id` = ?);";
//				PreparedStatement preparedStatement = connection.prepareStatement(sql);
//				preparedStatement.setString(1, newName);
//				preparedStatement.setInt(2, id);
//				// thực hiện truy vấn sql
//				int effectedRecordAmount = preparedStatement.executeUpdate();
//				System.out.println("Số record bị ảnh hưởng: " + effectedRecordAmount);
//				// đóng kết nối
//				connection.close();
//			}
//		} else {
//			System.out.println("ID không tồn tại");
//		}
//	}

//	@Override
//	public void deleteDepartment(int id) throws SQLException, ClassNotFoundException {
//		if (isDepartmenIdExists(id)) {
//			final String DB_URL = "jdbc:mysql://localhost:3306/testing_system?allowMultiQueries=true";
//			final String USER_NAME = "root";
//			final String PASSWORD = "root";
//			// đăng kí driver với driver manager
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
//			// tạo một đối tượng statement
//			String sql = "DELETE FROM `testing_system`.`department` WHERE (`department_id` = ?);";
//			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setInt(1, id);
//			// thực hiện truy vấn sql
//			int effectedRecordAmount = preparedStatement.executeUpdate();
//			System.out.println("Số record bị ảnh hưởng: " + effectedRecordAmount);
//			// đóng kết nối
//			connection.close();
//		}
//	}

}
