/**
 * Description: 
 */
package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "answer")
public class Answer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "answer_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short answers;

	@Column(name = "content", length = 100, nullable = false, unique = true)
	private String content;
	
	@Column(name = "is_correct", length = 1, nullable = true, unique = false, columnDefinition = "TINYINT(1) DEFAULT 1")
	private Boolean isCorrect;


	public Answer() {
	}


	public short getAnswers() {
		return answers;
	}


	public void setAnswers(short answers) {
		this.answers = answers;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Boolean getIsCorrect() {
		return isCorrect;
	}


	public void setIsCorrect(Boolean isCorrect) {
		this.isCorrect = isCorrect;
	}


	@Override
	public String toString() {
		return "Answer [answers=" + answers + ", content=" + content + ", isCorrect=" + isCorrect + "]";
	}

	


	
	

	

	
}