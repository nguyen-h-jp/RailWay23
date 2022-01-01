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

	public Group(int groupID, String groupName, Account creator, Date createDate) {
		super();
		this.groupID = groupID;
		this.groupName = groupName;
		this.creator = creator;
		this.createDate = createDate;
	}

	public Group(int groupID, String groupName, Account creator, Date createDate, List<Account> member) {
		super();
		this.groupID = groupID;
		this.groupName = groupName;
		this.creator = creator;
		this.createDate = createDate;
		this.member = member;
	}

	public Group(int groupID, String groupName) {
		super();
		this.groupID = groupID;
		this.groupName = groupName;
	}

	@Override
	public String toString() {
		return "Group [groupName=" + groupName + "]";
	}

}
