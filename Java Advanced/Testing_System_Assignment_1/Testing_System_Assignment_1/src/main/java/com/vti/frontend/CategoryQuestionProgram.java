package com.vti.frontend;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Answer;
import com.vti.entity.CategoryQuestion;
import com.vti.entity.Position;
import com.vti.repository.AccountRepository;
import com.vti.repository.AnswerRepository;
import com.vti.repository.CategoryQuestionRepository;
import com.vti.repository.PositionRepository;

public class CategoryQuestionProgram {
	public static void main(String[] args) {
		
		CategoryQuestionRepository categoryQuestionRepository = new CategoryQuestionRepository();
		
		// lay danh sach category question
//		List<CategoryQuestion> list = new ArrayList<CategoryQuestion>();
//		
//		list = categoryQuestionRepository.getAllCategoryQuestions();
//		System.out.println(list);
		
		// tao moi category question
		CategoryQuestion categoryQuestion = new CategoryQuestion();
		categoryQuestion.setCategoryName("Janpanese");
		categoryQuestionRepository.createCategoryQuestion(categoryQuestion);
	
	}
}
