package com.vti.backend.datalayer.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Department;

public interface IDepartmentRepository {
	/**
	 * Description: lấy danh sách department
	 */
	public List<Department> getDepartments() throws SQLException;

	/**
	 * Description: tìm department theo department id
	 */
	public Department getDepartmentByID(int id) throws SQLException;

	/**
	 * Description: kiểm tra department có tồn tại không(kiểm tra theo department
	 * name)
	 */
	public boolean isDepartmentNameExists(String name) throws SQLException;

	/**
	 * Description: kiểm tra department có tồn tại không(kiểm tra theo department
	 * id)
	 */
	public boolean isDepartmenIdExists(int id) throws SQLException;

	/**
	 * Description: tạo mới department
	 */
	public void createDepartment(String name) throws SQLException;

	/**
	 * Description: cập nhật thông tin department theo department id
	 */
	public void updateDepartmentName(int id, String newName) throws SQLException;

	/**
	 * Description: xóa department
	 */
	public void deleteDepartment(int id) throws SQLException;
}
