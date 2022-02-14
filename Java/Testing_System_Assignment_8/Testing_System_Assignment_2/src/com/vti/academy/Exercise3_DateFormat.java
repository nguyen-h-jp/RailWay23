package com.vti.academy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

import com.vti.academy.enums.PositionName;
import com.vti.academy.enums.TypeName;

public class Exercise3_DateFormat {

	public static void main(String[] args) {
		// Department
				Department department1 = new Department();
				department1.departmentID = 1;
				department1.departmentName = "Sales";
				Department department2 = new Department();
				department2.departmentID = 2;
				department2.departmentName = "Marketing";
				Department department3 = new Department();
				department3.departmentID = 3;
				department3.departmentName = "Bảo vệ";

				// Position
				Position position1 = new Position();
				position1.positionID = 1;
				position1.positionName = PositionName.DEV.getPositionName();
				
				Position position2 = new Position();
				position2.positionID = 2;
				position2.positionName = PositionName.TEST.getPositionName();
				
				Position position3 = new Position();
				position3.positionID = 3;
				position3.positionName = PositionName.SCRUM_MASTER.getPositionName();
				
				Position position4 = new Position();
				position4.positionID = 4;
				position4.positionName = PositionName.PM.getPositionName();
				
				//Tao truoc group
				Group group1 = new Group();
				group1.groupID = 1;
				group1.groupName = "Nhóm 1";
				
				
				Group group2 = new Group();
				group2.groupID = 2;
				group2.groupName = "Nhóm 2";
				
				Group group3 = new Group();
				group3.groupID = 3;
				group3.groupName = "Nhóm 3";
				
				//Account
				Account account1 = new Account();
				account1.accountID = 1;
				account1.email = "nguyenvana@gmail.com";
				account1.userName = "a_nguyenvan";
				account1.fullName = "Nguyễn Văn A";
				account1.department = department1;
				account1.position = position1;
				account1.createDate = LocalDate.now();
				account1.groups = new  Group[] {group1, group2};
				
				Account account2 = new Account();
				account2.accountID = 2;
				account2.email = "nguyenvanb@gmail.com";
				account2.userName = "b_nguyenvan";
				account2.fullName = "Nguyễn Văn B";
				account2.department = department2;
				account2.position = position2;
				account2.createDate = LocalDate.now();
				account2.groups = new  Group[] {group1};
				
				Account account3 = new Account();
				account3.accountID = 3;
				account3.email = "nguyenvanc@gmail.com";
				account3.userName = "c_nguyenvan";
				account3.fullName = "Nguyễn Văn C";
				account3.department = department3;
				account3.position = position3;
				account3.createDate = LocalDate.now();
				account2.groups = new  Group[] {group1};
			
				
				//Group creator
			
				group1.creator = account1;
				group2.creator = account1;
				group3.creator = account1;
				
				//GroupAccount
				GroupAccount gr_account1 = new GroupAccount();
				gr_account1.group = group1;
				gr_account1.account = account1;
				gr_account1.joinDate = new Date();
				
				gr_account1.group = group1;
				gr_account1.account = account2;
				gr_account1.joinDate = new Date();
				
				gr_account1.group = group1;
				gr_account1.account = account3;
				gr_account1.joinDate = new Date();
				
				gr_account1.group = group2;
				gr_account1.account = account1;
				gr_account1.joinDate = new Date();
				
				//TypeQuestion
				TypeQuestion tq1= new TypeQuestion();
				tq1.typeID = 1;
				tq1.typeName = TypeName.ESSAY.getTypeName();
				
				TypeQuestion tq2= new TypeQuestion();
				tq2.typeID = 2;
				tq2.typeName = TypeName.MULTIPLE_CHOICE.getTypeName();
				
				//CategoryQuestion
				
				CategoryQuestion cq1 = new CategoryQuestion();
				cq1.categoryID = 1;
				cq1.categoryName = "Java";
				
				CategoryQuestion cq2 = new CategoryQuestion();
				cq2.categoryID = 2;
				cq2.categoryName = ".NET";

				CategoryQuestion cq3 = new CategoryQuestion();
				cq3.categoryID = 3;
				cq3.categoryName = "SQL";
						
				CategoryQuestion cq4 = new CategoryQuestion();
				cq4.categoryID = 4;
				cq4.categoryName = "Postman";
				
				CategoryQuestion cq5 = new CategoryQuestion();
				cq5.categoryID = 5;
				cq5.categoryName = "Ruby";
				
				
				//Question
				Question question1 = new Question();
				question1.questionID = 1;
				question1.content = "Java là gì";
				question1.category = cq1;
				question1.type = tq1;
				question1.creator = account1;
				question1.createDate = new Date();
				
				Question question2 = new Question();
				question2.questionID = 2;
				question2.content = "Java được phát hành lần đầu tiên vào năm nào";
				question2.category = cq1;
				question2.type = tq2;
				question2.creator = account1;
				question2.createDate = new Date();
				
				Question question3 = new Question();
				question3.questionID = 3;
				question3.content = "Java do ai tạo ra";
				question3.category = cq1;
				question3.type = tq2;
				question3.creator = account1;
				question3.createDate = new Date();
				
				Question question4 = new Question();
				question4.questionID = 4;
				question4.content = "SQL là gì";
				question4.category = cq3;
				question4.type = tq1;
				question4.creator = account2;
				question4.createDate = new Date();
				
				//Answer
				
				Answer answer1 = new Answer();
				answer1.answerID = 1;
				answer1.content =  "Java là ngôn ngữ lập trình bậc cao";
				answer1.question = question1;
				answer1.isCorrect = true;
				
				Answer answer2 = new Answer();
				answer2.answerID = 2;
				answer2.content =  "Java là tên một hòn đảo";
				answer2.question = question1;
				answer2.isCorrect = true;
				
				Answer answer3 = new Answer();
				answer3.answerID = 3;
				answer3.content =  "SQL là ngôn ngữ truy vấn có cấu trúc";
				answer3.question = question4;
				answer3.isCorrect = true;
				
				Answer answer4 = new Answer();
				answer4.answerID = 4;
				answer4.content =  "SQL là một phần mềm";
				answer4.question = question4;
				answer4.isCorrect = false;
				
				//Exam
				Exam exam1 = new Exam();
				exam1.examID = 1;
				exam1.code = "Java01";
				exam1.title = "Bài kiểm tra về Java 01";
				exam1.category = cq1;
				exam1.duration = "90 phút";
				exam1.creator = account1;
				exam1.createDate = new Date();
				
				Exam exam2 = new Exam();
				exam2.examID = 2;
				exam2.code = "SQL01";
				exam2.title = "Bài kiểm tra về SQL 01";
				exam2.category = cq3;
				exam2.duration = "60 phút";
				exam2.creator = account2;
				exam2.createDate = new Date();
				
				//ExamQuestion
				ExamQuestion eq1 = new ExamQuestion();
				eq1.exam = exam1;
				eq1.question = question1;
				
				ExamQuestion eq2 = new ExamQuestion();
				eq2.exam = exam1;
				eq2.question = question2;
				
				ExamQuestion eq3 = new ExamQuestion();
				eq3.exam = exam1;
				eq3.question = question3;
				
				ExamQuestion eq4 = new ExamQuestion();
				eq4.exam = exam2;
				eq4.question = question4;
				
//		Question 1:
//			In ra thông tin Exam thứ 1 và property create date sẽ được format theo định dạng vietnamese
		Question1(exam1);
		
//		Question 2:
//			In ra thông tin: Exam đã tạo ngày nào theo định dạng
//			Năm – tháng – ngày – giờ – phút – giây
		
//		Question2(exam1);
		
//		Question 3:
//			Chỉ in ra năm của create date property trong Question 2
//		
//		Question3(question2);
		
//		Question 4:
//			Chỉ in ra tháng và năm của create date property trong Question 2
		
//		Question4(question2);
		
//		Question 5:
//			Chỉ in ra "MM-DD" của create date trong Question 2
		
//		Question5(question2);
		
	}
	
//	các method
//	question1
	static void Question1(Exam e) {
		System.out.println("Question 1: ");
		Locale locale = new Locale("vi", "VN");
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
		String date = dateFormat.format(e.createDate);
		System.out.println("ID: " + e.examID + ", Create date: " + date);
		System.out.println();	
	}
	
//	question2
	static void Question2(Exam e) {
		System.out.println("Question 2: ");
		String pattern = "yyyy-MM-dd-HH-mm-ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(e.createDate);
		System.out.println(date);
		System.out.println();	
	}
	
//	question3
	static void Question3(Question q) {
		System.out.println("Question 3: ");
		String pattern = "yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(q.createDate);
		System.out.println(date);
		System.out.println();	
	}
	
//	question4
	static void Question4(Question q) {
		System.out.println("Question 4: ");
		String pattern = "yyyy-MM";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(q.createDate);
		System.out.println(date);
		System.out.println();	
	}
	
//	question5
	static void Question5(Question q) {
		System.out.println("Question 5: ");
		String pattern = "MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(q.createDate);
		System.out.println(date);
		System.out.println();	
	}
}
