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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "question")
public class Question implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "question_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short questionID;

	@Column(name = "content", length = 100, nullable = false, unique = true)
	private String content;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", nullable = true)
	@CreationTimestamp
	private Date createDate;
	
	@ManyToOne
	@JoinColumn(name = "category_id", referencedColumnName = "category_id")
	private CategoryQuestion categoryQuestion;
	
	@ManyToOne
	@JoinColumn(name = "type_id", referencedColumnName = "type_id")
	private TypeQuestion typeQuestion;
	
	@OneToOne
	@JoinColumn(name = "creator_id", referencedColumnName = "account_id")
	private Account account;
	
	@ManyToMany(mappedBy = "questions")
	private List<Exam> exams;

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

	public CategoryQuestion getCategoryQuestion() {
		return categoryQuestion;
	}

	public void setCategoryQuestion(CategoryQuestion categoryQuestion) {
		this.categoryQuestion = categoryQuestion;
	}

	public TypeQuestion getTypeQuestion() {
		return typeQuestion;
	}

	public void setTypeQuestion(TypeQuestion typeQuestion) {
		this.typeQuestion = typeQuestion;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	@Override
	public String toString() {
		return "Question [questionID=" + questionID + ", content=" + content + ", createDate=" + createDate
				+ ", categoryQuestion=" + categoryQuestion.getCategoryName() + ", typeQuestion=" + typeQuestion.getTypeName() + ", account=" + account.getUsername()
				+ ", exams=" + exams + "]";
	}

	

	
	
}