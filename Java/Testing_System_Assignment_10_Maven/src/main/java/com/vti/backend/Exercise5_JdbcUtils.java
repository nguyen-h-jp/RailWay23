package com.vti.backend;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Exercise5_JdbcUtils {
	public static Connection connection;

	public static void isConnectedForTesting() {
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream("src\\main\\resource\\database.properties"));
			String url = properties.getProperty("url");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
			// đăng kí driver với driver manager
			System.out.println("Kết nối thành công");

		} catch (IOException e) {
			System.out.println("Lỗi không đọc được file");
		} catch (ClassNotFoundException e) {
			System.out.println("Lỗi tạo driver");
		} catch (SQLException e) {
			System.out.println("Lỗi kết nối sql");
		}
	}

	public static Connection connect() throws SQLException {
		try {
			if (connection == null || connection.isClosed()) {
				System.out.println("Connection không tồn tại");
				isConnectedForTesting();
			} else {
				System.out.println("Connection đã tồn tại");
			}
		} catch (SQLException e) {
			throw new SQLException("Lỗi kết nối sql");
		}
		return connection;
	}

	public static void disconnect() throws SQLException {
		try {
			if (connection == null || connection.isClosed()) {
				System.out.println("Connection không tồn tại");
			} else {
				connection.close();
				System.out.println("Đã đóng connect");
			}

		} catch (SQLException e) {
			throw new SQLException("Lỗi kết nối sql");
		}
	}
}
