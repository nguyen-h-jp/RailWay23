package com.vti.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Exercise1_Basic {
	public void question1() {
		try {
			final String DB_URL = "jdbc:mysql://localhost:3306/testing_system?autoReconnect=true&useSSL=false&characterEncoding=latin1";
			final String USER_NAME = "root";
			final String PASSWORD = "root";
			// đăng kí driver với driver manager
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			System.out.println("Kết nối thành công");
		} catch (ClassNotFoundException e) {
			System.out.println("Lỗi tạo driver không thành công");
		} catch (SQLException e) {
			System.out.println("Lỗi kết nối database không thành công");
		}
	}

	public void question2() {
		try {
			final String DB_URL = "jdbc:mysql://localhost:3306/testing_system?autoReconnect=true&useSSL=false&characterEncoding=latin1";
			final String USER_NAME = "root";
			final String PASSWORD = "root";
			// đăng kí driver với driver manager
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			System.out.println("Kết nối thành công");
			// tạo một đối tượng statement
			Statement statement = connection.createStatement();
			// thực hiện truy vấn sql
			String sql = "SELECT position_id, position_name FROM position";
			// thực hiện truy vấn sql
			ResultSet resultSet = statement.executeQuery(sql);
			// xử lý result set
			while (resultSet.next()) {
				System.out.println(resultSet.getInt("position_id") + " " + resultSet.getString("position_name"));
			}
			// đóng kết nối
			connection.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Lỗi tạo driver không thành công");
		} catch (SQLException e) {
			System.out.println("Lỗi kết nối database không thành công");
		}
	}

	public String getPositionNameFromNumber(Scanner sc) {

		String result = "";
		boolean isOk = false;
		while (!isOk) {
			System.out.println("Nhập vào position name: 1. Dev, 2. Test, 3. Scrum Master, 4. PM");
			int inputNumber = sc.nextInt();
			sc.nextLine();

			switch (inputNumber) {
			case 1:
				result = "Dev";
				isOk = true;
				break;
			case 2:
				result = "Test";
				isOk = true;
				break;
			case 3:
				result = "Scrum Master";
				isOk = true;
				break;
			case 4:
				result = "PM";
				isOk = true;
				break;
			default:
				System.out.println("Số vừa nhập không hợp lệ, vui lòng nhập lại");
				break;
			}

		}
		return result;
	}

	public void question3(Scanner sc) {
		try {
			final String DB_URL = "jdbc:mysql://localhost:3306/testing_system?autoReconnect=true&useSSL=false&characterEncoding=latin1";
			final String USER_NAME = "root";
			final String PASSWORD = "root";
			// đăng kí driver với driver manager
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			System.out.println("Kết nối thành công");
			// tạo một đối tượng statement
			String sql = "INSERT INTO `position` (`position_name`) VALUES (?);";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			String positionName = getPositionNameFromNumber(sc);
			preparedStatement.setString(1, positionName);
			// thực hiện truy vấn sql
			int effectedRecordAmount = preparedStatement.executeUpdate();
			System.out.println("Số record bị ảnh hưởng: " + effectedRecordAmount);
			// đóng kết nối
			connection.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Lỗi tạo driver không thành công");
		} catch (SQLException e) {
			System.out.println("Lỗi kết nối database không thành công");
		}
	}

	public void question4(Scanner sc) {
		try {
			final String DB_URL = "jdbc:mysql://localhost:3306/testing_system?autoReconnect=true&useSSL=false&characterEncoding=latin1";
			final String USER_NAME = "root";
			final String PASSWORD = "root";
			// đăng kí driver với driver manager
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			System.out.println("Kết nối thành công");
			// tạo một đối tượng statement
			String sql = "UPDATE `testing_system`.`position` SET `position_name` = 'Test' WHERE (`position_id` = '5');";
			Statement statement = connection.createStatement();
			// thực hiện truy vấn sql
			int effectedRecordAmount = statement.executeUpdate(sql);
			System.out.println("Số record bị ảnh hưởng: " + effectedRecordAmount);
			// đóng kết nối
			connection.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Lỗi tạo driver không thành công");
		} catch (SQLException e) {
			System.out.println("Lỗi kết nối database không thành công");
		}
	}

	public void question5(Scanner sc) {
		try {
			final String DB_URL = "jdbc:mysql://localhost:3306/testing_system?autoReconnect=true&useSSL=false&characterEncoding=latin1";
			final String USER_NAME = "root";
			final String PASSWORD = "root";
			// đăng kí driver với driver manager
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			System.out.println("Kết nối thành công");
			// tạo một đối tượng statement
			String sql = "DELETE FROM `testing_system`.`position` WHERE (`position_id` = ?);";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			System.out.println("Nhập vào id của position cần xóa");
			int inputNumber = sc.nextInt();
			sc.nextLine();
			preparedStatement.setInt(1, inputNumber);
			// thực hiện truy vấn sql
			int effectedRecordAmount = preparedStatement.executeUpdate();
			if (effectedRecordAmount != 0) {
				System.out.println("Xóa thành công");
			} else {
				System.out.println("Id vừa nhập không tồn tại");
			}
			// đóng kết nối
			connection.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Lỗi tạo driver không thành công");
		} catch (SQLException e) {
			System.out.println("Lỗi kết nối database không thành công");
		}
	}

}
