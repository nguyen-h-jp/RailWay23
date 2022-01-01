package com.vti.backend.datalayer.interfaces;

import java.sql.SQLException;

import com.vti.entity.Position;

public interface IPositionRepository {
	/**
	 * Description: lấy position theo position id
	 */
	public Position getPositionByID(int id) throws SQLException;
}
