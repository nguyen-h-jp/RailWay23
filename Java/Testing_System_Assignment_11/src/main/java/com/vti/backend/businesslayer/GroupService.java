package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.interfaces.IGroupService;
import com.vti.backend.datalayer.GroupRepository;
import com.vti.backend.datalayer.interfaces.IGroupRepository;
import com.vti.entity.Group;

public class GroupService implements IGroupService {
	IGroupRepository groupRepository = new GroupRepository();

	@Override
	public List<Group> getGroupListByAccountID(int accountID) throws SQLException {
		return groupRepository.getGroupListByAccountID(accountID);
	}
}
