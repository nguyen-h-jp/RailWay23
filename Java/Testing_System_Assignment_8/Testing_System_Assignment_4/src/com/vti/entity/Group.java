package com.vti.entity;
import java.util.Arrays;
import java.util.Date;

/*Table 4: Group
 GroupID: định danh của nhóm (auto increment)
 GroupName: tên nhóm
 CreatorID: id của người tạo group
 CreateDate: ngày tạo group*/

public class Group {
	private int groupID;
	private String groupName;
	private Account creator;
	private Date createDate;
	private Account[] accounts;
	
	public Group() {
		
	}
	
	public Group(String groupName, Account creator, Account[] accounts, Date createDate) {
		super();
		this.setGroupName(groupName);
		this.setCreator(creator);
		this.setCreateDate(createDate);
		this.setAccounts(accounts);
	}
	
	public Group(String groupName, Account creator, String[] username, Date createDate) {
		super();
		this.setGroupName(groupName);
		this.setCreator(creator);
		this.setCreateDate(createDate);
		this.setAccounts(new Account[] {});
		if (username.length > 0) {
			for (String uname : username) {
				Account account = new Account();
				account.setUserName(uname);
				this.setAccounts(Arrays.copyOf(this.getAccounts(), this.getAccounts().length + 1));
				this.getAccounts()[this.getAccounts().length - 1] = account;
			}
		}		
	}

	// account1, 2 ,3

	@Override
	public String toString() {
		return "Group [groupID=" + getGroupID() + ", groupName=" + getGroupName() + ", creator=" + getCreator() + ", createDate="
				+ getCreateDate() + ", accounts=" + Arrays.toString(getAccounts()) + "]";
	}

	public int getGroupID() {
		return groupID;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Account getCreator() {
		return creator;
	}

	public void setCreator(Account creator) {
		this.creator = creator;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Account[] getAccounts() {
		return accounts;
	}

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}
}
