package com.vti.frontend;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.entity.Question;
import com.vti.repository.DepartmentRepository;
import com.vti.repository.PositionRepository;
import com.vti.repository.QuestionRepository;

public class QuestionProgram {
	public static void main(String[] args) {
		
		QuestionRepository questionRepository = new QuestionRepository();
		
		// lay danh sach cac question
		
//		List<Question> list = new ArrayList<Question>();
//		list = questionRepository.getAllQuestions();
//		
//		System.out.println(list);
		
		// tao moi question
		
		Question question = new Question();
		
		question.setContent("Hỏi về vũ trụ");
		Date date = new Date();
		question.setCreateDate(date);
		
		questionRepository.createQuestion(question);
	}
}
