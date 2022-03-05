package com.vti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "`group`")
public class Group implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "group_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short groupId;

	@Column(name = "group_name", length = 50, nullable = false, unique = true)
	private String groupName;

	@Column(name = "create_date", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;
	
	@ManyToOne
	@JoinColumn(name = "creator_id", referencedColumnName = "account_id")
	private Account account;
	
	@OneToMany(mappedBy = "group")
	@JsonIgnoreProperties("group")
	private List<GroupAccount> groupAccounts;

	public Group() {
	}

	public short getGroupId() {
		return groupId;
	}

	public void setGroupId(short groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<GroupAccount> getGroupAccounts() {
		return groupAccounts;
	}

	public void setGroupAccounts(List<GroupAccount> groupAccounts) {
		this.groupAccounts = groupAccounts;
	}

	@Override
	public String toString() {
		return "Group [groupId=" + groupId + ", groupName=" + groupName + ", createDate=" + createDate + ", account="
				+ account.getUsername() + "]";
	}

	
	
	
}