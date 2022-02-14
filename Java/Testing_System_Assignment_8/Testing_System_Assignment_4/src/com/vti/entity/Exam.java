package com.vti.entity;
import java.util.Date;

/*Table 10: Exam
 ExamID: định danh của đề thi (auto increment)
 Code: mã đề thi
 Title: tiêu đề của đề thi
 CategoryID: định danh của chủ đề thi
 Duration: thời gian thi
 CreatorID: id của người tạo đề thi
 CreateDate: ngày tạo đề thi*/

public class Exam {
	private int examID;
	private String code;
	private String title;
	private CategoryQuestion category;
	private String duration;
	private Account creator;
	private Date createDate;
	
	public int getExamID() {
		return examID;
	}
	public void setExamID(int examID) {
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
	public CategoryQuestion getCategory() {
		return category;
	}
	public void setCategory(CategoryQuestion category) {
		this.category = category;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
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
}
