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
@Table(name = "exam")
public class Exam implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "exam_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short examID;

	@Column(name = "`code1`", length = 10, nullable = false, unique = true)
	private String code1;
	
	@Column(name = "`code2`", length = 10, nullable = true, unique = true)
	private String code2;
	
	@Column(name = "title", length = 50, nullable = false, unique = true)
	private String title;
	
	@Column(name = "duration", nullable = false, unique = false, columnDefinition = "TINYINT DEFAULT 45")
	private short duration;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", nullable = true, columnDefinition = "DATETIME DEFAULT NOW()")
	private Date createDate;

	public Exam() {
	}

	public short getExamID() {
		return examID;
	}

	public void setExamID(short examID) {
		this.examID = examID;
	}

	public String getCode1() {
		return code1;
	}

	public void setCode1(String code1) {
		this.code1 = code1;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public short getDuration() {
		return duration;
	}

	public void setDuration(short duration) {
		this.duration = duration;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Exam [examID=" + examID + ", code1=" + code1 + ", code2=" + code2 + ", title=" + title + ", duration="
				+ duration + ", createDate=" + createDate + "]";
	}

	
}