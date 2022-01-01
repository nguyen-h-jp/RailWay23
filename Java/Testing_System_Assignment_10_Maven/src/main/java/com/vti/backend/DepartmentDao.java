package com.vti.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Department;

public class DepartmentDao {
	private static List<Department> listDepartment;

	public DepartmentDao() {
		listDepartment = new ArrayList<Department>();
	}

	public static List<Department> getDepartments() throws ClassNotFoundException, SQLException {
		listDepartment = new ArrayList<Department>();
		
		final String DB_URL = "jdbc:mysql://localhost:3306/testing_system?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		final String USER_NAME = "root";
		final String PASSWORD = "root";
		// đăng kí driver với driver manager
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		// tạo một đối tượng statement
		String sql = "SELECT department_id, department_name FROM testing_system.department;";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		if (listDepartment.size() != 0) {
			listDepartment.clear();
		}
		while (resultSet.next()) {
			listDepartment
					.add(new Department(resultSet.getInt("department_id"), resultSet.getString("department_name")));
		}

		// đóng kết nối
		connection.close();
		return listDepartment;
	}

	public static List<Department> getDepartmentByID(int id) throws ClassNotFoundException, SQLException {
		List<Department> resultList = new ArrayList<Department>();

		for (Department department : getDepartments()) {
			if (department.getDepartmentID() == id)
				resultList.add(department);
		}
		return resultList;
	}

	public static boolean isDepartmentNameExists(String name) throws ClassNotFoundException, SQLException {
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

	public static boolean isDepartmenIdExists(int id) throws ClassNotFoundException, SQLException {
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

	public static void createDepartment(String name) throws ClassNotFoundException, SQLException {
		if (isDepartmentNameExists(name)) {
			System.out.println("Department đã tồn tại");
		} else {
			final String DB_URL = "jdbc:mysql://localhost:3306/testing_system?autoReconnect=true&useSSL=false&characterEncoding=latin1";
			final String USER_NAME = "root";
			final String PASSWORD = "root";
			// đăng kí driver với driver manager
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			// tạo một đối tượng statement
			String sql = "INSERT INTO `testing_system`.`department` (`department_name`) VALUES (?);";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			// thực hiện truy vấn sql
			int effectedRecordAmount = preparedStatement.executeUpdate();
			System.out.println("Số record bị ảnh hưởng: " + effectedRecordAmount);
			// đóng kết nối
			connection.close();
		}
	}

	public static void updateDepartmentName(int id, String newName) throws ClassNotFoundException, SQLException {
		if (isDepartmenIdExists(id)) {
			if (isDepartmentNameExists(newName)) {
				System.out.println("Department này đã tồn tại");
			} else {
				final String DB_URL = "jdbc:mysql://localhost:3306/testing_system?allowMultiQueries=true";
				final String USER_NAME = "root";
				final String PASSWORD = "root";
				// đăng kí driver với driver manager
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
				// tạo một đối tượng statement
				String sql = "ALTER DATABASE `testing_system` CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;"
						+ "UPDATE `testing_system`.`department` SET `department_name` = ? WHERE (`department_id` = ?);";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, newName);
				preparedStatement.setInt(2, id);
				// thực hiện truy vấn sql
				int effectedRecordAmount = preparedStatement.executeUpdate();
				System.out.println("Số record bị ảnh hưởng: " + effectedRecordAmount);
				// đóng kết nối
				connection.close();
			}
		} else {
			System.out.println("ID không tồn tại");
		}
	}

	public static void deleteDepartment(int id) throws ClassNotFoundException, SQLException {
		if (isDepartmenIdExists(id)) {
			final String DB_URL = "jdbc:mysql://localhost:3306/testing_system?allowMultiQueries=true";
			final String USER_NAME = "root";
			final String PASSWORD = "root";
			// đăng kí driver với driver manager
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			// tạo một đối tượng statement
			String sql = "DELETE FROM `testing_system`.`department` WHERE (`department_id` = ?);";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			// thực hiện truy vấn sql
			int effectedRecordAmount = preparedStatement.executeUpdate();
			System.out.println("Số record bị ảnh hưởng: " + effectedRecordAmount);
			// đóng kết nối
			connection.close();
		}
	}

}
