package com.vti.backend.businesslayer.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Group;

public interface IGroupService {
	/**
	 * Description: lấy danh sách group(lấy theo account id)
	 */
	public List<Group> getGroupListByAccountID(int accountID) throws SQLException;
}
