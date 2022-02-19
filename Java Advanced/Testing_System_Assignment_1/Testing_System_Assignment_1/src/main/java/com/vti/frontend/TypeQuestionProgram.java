package com.vti.frontend;

import java.util.ArrayList;
import java.util.List;

import com.vti.entity.TypeQuestion;
import com.vti.repository.TypeQuestionRepository;

public class TypeQuestionProgram {
	public static void main(String[] args) {
	
		TypeQuestionRepository typeQuestionRepository = new TypeQuestionRepository();
		
		// lay danh sach type question
		
		List<TypeQuestion> list = new ArrayList<TypeQuestion>();
		
		list = typeQuestionRepository.getAllTypeQuestions();
		
		System.out.println(list);
		
	}
	
	
}
