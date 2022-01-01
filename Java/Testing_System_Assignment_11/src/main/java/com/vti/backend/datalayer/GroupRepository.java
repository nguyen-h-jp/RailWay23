package com.vti.backend.datalayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.backend.datalayer.interfaces.IGroupRepository;
import com.vti.entity.Group;
import com.vti.utils.JDBCUtils;

public class GroupRepository implements IGroupRepository {

//	private IDepartmentRepository departmentRepository = new DepartmentRepository();
//	private IPositionRepository positionRepository = new PositionRepository();
//	private IGroupRepository groupRepository = new GroupRepository();

	public List<Group> getGroupListByAccountID(int accountID) throws SQLException {
		List<Group> groupList = new ArrayList<Group>();
		// tạo một đối tượng prepared statement
		String sql = "select g.*from group_account ga join `group` g on ga.group_id = g.group_id\r\n"
				+ "where ga.account_id = ?;";
		PreparedStatement preparedStatement = JDBCUtils.createPreparedStatement(sql);
		preparedStatement.setInt(1, accountID);
		// thực hiện truy vấn sql
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Group group = new Group(resultSet.getString("group_name"));
			groupList.add(group);
		}
		return groupList;
	}
}
