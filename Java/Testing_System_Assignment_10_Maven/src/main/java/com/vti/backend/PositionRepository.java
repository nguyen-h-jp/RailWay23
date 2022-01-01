package com.vti.backend;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vti.entity.Position;
import com.vti.entity.enums.PositionName;
import com.vti.utils.JDBCUtils;

public class PositionRepository {

	public Position getPositionByID(int id) throws SQLException {
		Position position = null;
		// tạo một đối tượng statement
		String sql = "SELECT * FROM position where position_id = ?;";
		PreparedStatement preparedStatement = JDBCUtils.createPreparedStatement(sql);
		preparedStatement.setInt(1, id);
		// thực hiện truy vấn sql
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			String positionName = resultSet.getString("position_name");
			position = new Position(id, PositionName.fromString(positionName));
		}
		return position;

	}
}
