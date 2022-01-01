package com.vti.backend;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Group;
import com.vti.utils.JDBCUtils;

public class GroupRepository {

//	private DepartmentRepository departmentRepository = new DepartmentRepository();
//	private PositionRepository positionRepository = new PositionRepository();
//	private IGroupRepository groupRepository = new GroupRepository();
//	private AccountRepository accountRepository = new AccountRepository();

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

	public List<Group> getGroupListByGroupIDList(List<Integer> groupIDList) throws SQLException {
		List<Group> groupList = new ArrayList<Group>();
		for (Integer integer : groupIDList) {
			groupList.add(getGroupByGroupID(integer));
		}
		return null;

	}

	public Group getGroupByGroupID(int groupID) throws SQLException {
		Group group = null;
		String sql = "SELECT * FROM group where group_id = ?;";
		PreparedStatement preparedStatement = JDBCUtils.createPreparedStatement(sql);
		preparedStatement.setInt(1, groupID);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			group = new Group(resultSet.getInt("group_id"), resultSet.getString("group_name"));

		}
		return group;
	}

	public List<Account> getAccountListInGroup(int groupID) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
