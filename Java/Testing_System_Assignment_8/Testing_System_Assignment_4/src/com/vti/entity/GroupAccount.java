package com.vti.entity;
import java.util.Date;

/*Table 5: GroupAccount
 GroupID: định danh của nhóm
 AccountID: định danh của User
 JoinDate: Ngày user tham gia vào nhóm*/

public class GroupAccount {
	private Group group;
	private Account account;
	private Date joinDate;
	
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
}
