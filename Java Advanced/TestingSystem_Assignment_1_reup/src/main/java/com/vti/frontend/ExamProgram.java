package com.vti.frontend;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vti.entity.Department;
import com.vti.entity.Exam;
import com.vti.entity.Position;
import com.vti.repository.DepartmentRepository;
import com.vti.repository.ExamRepository;
import com.vti.repository.PositionRepository;

public class ExamProgram {
	public static void main(String[] args) {
		
		ExamRepository examRepository = new ExamRepository();
		
		// lay danh sach cac exam
		
//		List<Exam> list = new ArrayList<Exam>();
//		list = examRepository.getAllExams();
//		System.out.println(list);
		
		// tao moi exam
		
		Exam exam = new Exam();
		exam.setCode1("MI-6");
		exam.setTitle("MI6");
		exam.setDuration((short)120);
		Date date = new Date();
		exam.setCreateDate(date);
		
		examRepository.createExam(exam);
	}
		
}
