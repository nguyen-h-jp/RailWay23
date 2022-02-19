package com.vti.frontend;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Answer;
import com.vti.entity.Position;
import com.vti.repository.AccountRepository;
import com.vti.repository.AnswerRepository;
import com.vti.repository.PositionRepository;

public class AnswerProgram {
	public static void main(String[] args) {
		
		AnswerRepository answerRepository = new AnswerRepository();
//		List<Answer> list = new ArrayList<Answer>();
//		
//		
//		// lay danh sach cac cau tra loi
//		list = answerRepository.getAllAnswers();
//		System.out.println(list);
		
		// tao moi cau tra loi
		
//		Answer answer = new Answer();
//		answer.setContent("Trả lời x2");
//		answer.setIsCorrect(true);
//		answerRepository.createAnswer(answer);
		
		// update cau tra loi theo id
		
		answerRepository.updateAnswer((short)13, "Trả lời x3");
		
		
		
	}
}
