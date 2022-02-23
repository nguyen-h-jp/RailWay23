/**
 * Description: 
 */
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "exam")
public class Exam implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "exam_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short examID;

	@Column(name = "`code`", length = 10, nullable = false, unique = true)
	private String code;

	@Column(name = "title", length = 50, nullable = false, unique = true)
	private String title;

	@Column(name = "duration", nullable = false, unique = false, columnDefinition = "TINYINT DEFAULT 45")
	private Short duration;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", nullable = true)
	@CreationTimestamp
	private Date createDate;

	@ManyToOne
	@JoinColumn(name = "category_id", referencedColumnName = "category_id")
	private CategoryQuestion categoryQuestion;

	@ManyToOne
	@JoinColumn(name = "creator_id", referencedColumnName = "account_id")
	private Account account;

	@ManyToMany
	@JoinTable(name = "exam_question", joinColumns = { @JoinColumn(name = "exam_id") }, inverseJoinColumns = {
			@JoinColumn(name = "question_id") })
	private List<Question> questions;

	public Exam() {
	}

	public short getExamID() {
		return examID;
	}

	public void setExamID(short examID) {
		this.examID = examID;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Short getDuration() {
		return duration;
	}

	public void setDuration(Short duration) {
		this.duration = duration;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public CategoryQuestion getCategoryQuestion() {
		return categoryQuestion;
	}

	public void setCategoryQuestion(CategoryQuestion categoryQuestion) {
		this.categoryQuestion = categoryQuestion;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Exam [examID=" + examID + ", code=" + code + ", title=" + title + ", duration=" + duration
				+ ", createDate=" + createDate + ", categoryQuestion=" + categoryQuestion.getCategoryName() + ", account=" + account.getUsername()
				+ ", questions=" + questions + "]";
	}

	

}