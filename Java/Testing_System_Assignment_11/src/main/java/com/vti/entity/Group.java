package com.vti.entity;

import java.util.Date;
import java.util.List;

/*Table 4: Group
 GroupID: định danh của nhóm (auto increment)
 GroupName: tên nhóm
 CreatorID: id của người tạo group
 CreateDate: ngày tạo group*/

public class Group {
	int groupID;
	String groupName;
	Account creator;
	Date createDate;
	List<Account> member;

	public Group(String groupName) {
		super();
		this.groupName = groupName;
	}

	@Override
	public String toString() {
		return "Group [groupName=" + groupName + "]";
	}

}
