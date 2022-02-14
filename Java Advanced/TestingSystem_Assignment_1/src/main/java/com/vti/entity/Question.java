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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "question")
public class Question implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "questionID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short questionID;

	@Column(name = "content", length = 100, nullable = false, unique = true)
	private String content;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createDate", nullable = true)
	private Date createDate;

	public Question() {
	}

	public short getQuestionID() {
		return questionID;
	}

	public void setQuestionID(short questionID) {
		this.questionID = questionID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Question [questionID=" + questionID + ", content=" + content + ", createDate=" + createDate + "]";
	}
}