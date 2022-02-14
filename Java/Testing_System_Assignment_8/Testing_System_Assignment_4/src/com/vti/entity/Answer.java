package com.vti.entity;

/*Table 9: Answer
 AnswerID: định danh của câu trả lời (auto increment)
 Content: nội dung của câu trả lời
 QuestionID: định danh của câu hỏi
 isCorrect: câu trả lời này đúng hay sai*/

public class Answer {
	private int answerID;
	private String content;
	private Question question;
	private boolean isCorrect; // 1 is true, 0 is false
	
	public int getAnswerID() {
		return answerID;
	}
	public void setAnswerID(int answerID) {
		this.answerID = answerID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
}
