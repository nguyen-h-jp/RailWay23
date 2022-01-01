package com.vti.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
	public static Connection connection = null;
	public final static String IO_EXCEPTION = "Lỗi không tìm thấy file";
	public final static String FILE_NOT_FOUND_EXCEPTION = "Lỗi không đọc được file";
	public final static String CLASS_NOT_FOUND_EXCEPTION = "Lỗi đăng kí driver";
	public final static String SQL_EXCEPTION = "Lỗi kết nối SQL";

	// Hàm lấy connection
	public static Connection getConnection() {
		try {
			if (connection == null || connection.isClosed()) {
				Properties properties = new Properties();
				properties.load(new FileInputStream("src\\main\\resource\\database.properties"));
				final String DB_URL = properties.getProperty("url");
				final String USER_NAME = properties.getProperty("username");
				final String PASSWORD = properties.getProperty("password");
				final String DRIVER_NAME = properties.getProperty("driverName");
				// đăng kí driver cho sql
				Class.forName(DRIVER_NAME);
				// tạo kết nối bằng DriverManager
				connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			}
		} catch (ClassNotFoundException e) {
			System.out.println(CLASS_NOT_FOUND_EXCEPTION);
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(SQL_EXCEPTION);
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println(FILE_NOT_FOUND_EXCEPTION);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(IO_EXCEPTION);
			e.printStackTrace();
		}
		return connection;
	}

	// Hủy kết nối
	public static void close() {
		try {
			if (connection == null || connection.isClosed()) {
				return;
			} else
				connection.close();
		} catch (SQLException e) {
			System.out.println(SQL_EXCEPTION);
			e.printStackTrace();
		}
	}

	// dùng cho câu truy vấn không có tham số(?)
	public static Statement createStatement() {
		Statement statement = null;
		try {
			statement = getConnection().createStatement();
		} catch (SQLException e) {
			System.out.println(SQL_EXCEPTION);
			e.printStackTrace();
		}
		return statement;
	}

	// dùng cho câu truy vấn có tham số(?)
	public static PreparedStatement createPreparedStatement(String sql) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = getConnection().prepareStatement(sql);
		} catch (SQLException e) {
			System.out.println(SQL_EXCEPTION);
			e.printStackTrace();
		}
		return preparedStatement;
	}

}
