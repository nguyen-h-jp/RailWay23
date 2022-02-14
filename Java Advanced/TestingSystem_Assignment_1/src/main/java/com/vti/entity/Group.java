/**
 * Description: 
 */
package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "`group`")
public class Group implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "groupID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short groupID;

	@Column(name = "groupName", length = 50, nullable = false, unique = true)
	private String groupName;

//	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createDate", nullable = true)
	private Date createDate;

	public Group() {
	}

	public short getGroupID() {
		return groupID;
	}

	public void setGroupID(short groupID) {
		this.groupID = groupID;
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

	@Override
	public String toString() {
		return "Group [groupID=" + groupID + ", groupName=" + groupName + ", createDate=" + createDate + "]";
	}
}