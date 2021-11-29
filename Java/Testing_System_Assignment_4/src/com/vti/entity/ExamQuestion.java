package com.vti.entity;

/*Table 11: ExamQuestion
 ExamID: định danh của đề thi
 QuestionID: định danh của câu hỏi*/

public class ExamQuestion {
	private Exam exam;
	private Question question;
	
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
}
