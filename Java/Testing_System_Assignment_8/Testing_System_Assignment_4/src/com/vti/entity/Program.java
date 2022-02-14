//package com.vti.entity;
//
//import java.util.Date;
//
//import com.vti.entity.enums.PositionName;
//import com.vti.entity.enums.TypeName;
//
//
///*Question 2:
//Tạo file Program.java có chứa main() method và 
//khởi tạo ít nhất 3 đối tượng đối với mỗi table trong java*/
//
//public class Program {
//
//	public static void main(String[] args) {
//		// Department
//		Department department1 = new Department();
//		department1.setDepartmentID(1);
//		department1.setDepartmentName("Sales");
//		Department department2 = new Department();
//		department2.setDepartmentID(2);
//		department2.setDepartmentName("Marketing");
//		Department department3 = new Department();
//		department3.setDepartmentID(3);
//		department3.setDepartmentName("Bảo vệ");
//
//		// Position
//		Position position1 = new Position();
//		position1.setPositionID(1);
//		position1.setPositionName(PositionName.DEV.getPositionName());
//		
//		Position position2 = new Position();
//		position2.setPositionID(2);
//		position2.setPositionName(PositionName.TEST.getPositionName());
//		
//		Position position3 = new Position();
//		position3.setPositionID(3);
//		position3.setPositionName(PositionName.SCRUM_MASTER.getPositionName());
//		
//		Position position4 = new Position();
//		position4.setPositionID(4);
//		position4.setPositionName(PositionName.PM.getPositionName());
//		
//		//Tao truoc group
//		Group group1 = new Group();
//		group1.setGroupID(1);
//		group1.setGroupName("Nhóm 1");
//		
//		
//		Group group2 = new Group();
//		group2.setGroupID(2);
//		group2.setGroupName("Nhóm 2");
//		
//		Group group3 = new Group();
//		group3.setGroupID(3);
//		group3.setGroupName("Nhóm 3");
//		
//		//Account
//		Account account1 = new Account();
//		account1.setAccountID(1);
//		account1.setEmail("nguyenvana@gmail.com");
//		account1.setUserName("a_nguyenvan");
//		account1.setFullName("Nguyễn Văn A");
//		account1.setDepartment(department1);
//		account1.setPosition(position1);
//		account1.setCreateDate(new Date());
//		account1.setGroups(new  Group[] {group1, group2});
//		
//		Account account2 = new Account();
//		account2.setAccountID(2);
//		account2.setEmail("nguyenvanb@gmail.com");
//		account2.setUserName("b_nguyenvan");
//		account2.setFullName("Nguyễn Văn B");
//		account2.setDepartment(department2);
//		account2.setPosition(position2);
//		account2.setCreateDate(new Date());
//		account2.setGroups(new  Group[] {group1});
//		
//		Account account3 = new Account();
//		account3.setAccountID(3);
//		account3.setEmail("nguyenvanc@gmail.com");
//		account3.setUserName("c_nguyenvan");
//		account3.setFullName("Nguyễn Văn C");
//		account3.setDepartment(department3);
//		account3.setPosition(position3);
//		account3.setCreateDate(new Date());
//		account2.setGroups(new  Group[] {group1});
//	
//		
//		//Group creator
//	
//		group1.setCreator(account1);
//		group2.setCreator(account1);
//		group3.setCreator(account1);
//		
//		//GroupAccount
//		GroupAccount gr_account1 = new GroupAccount();
//		gr_account1.setGroup(group1);
//		gr_account1.setAccount(account1);
//		gr_account1.setJoinDate(new Date());
//		
//		gr_account1.setGroup(group1);
//		gr_account1.setAccount(account2);
//		gr_account1.setJoinDate(new Date());
//		
//		gr_account1.setGroup(group1);
//		gr_account1.setAccount(account3);
//		gr_account1.setJoinDate(new Date());
//		
//		gr_account1.setGroup(group2);
//		gr_account1.setAccount(account1);
//		gr_account1.setJoinDate(new Date());
//		
//		//TypeQuestion
//		TypeQuestion tq1= new TypeQuestion();
//		tq1.typeID = 1;
//		tq1.typeName = TypeName.ESSAY.getTypeName();
//		
//		TypeQuestion tq2= new TypeQuestion();
//		tq2.typeID = 2;
//		tq2.typeName = TypeName.MULTIPLE_CHOICE.getTypeName();
//		
//		//CategoryQuestion
//		
//		CategoryQuestion cq1 = new CategoryQuestion();
//		cq1.setCategoryID(1);
//		cq1.setCategoryName("Java");
//		
//		CategoryQuestion cq2 = new CategoryQuestion();
//		cq2.setCategoryID(2);
//		cq2.setCategoryName(".NET");
//
//		CategoryQuestion cq3 = new CategoryQuestion();
//		cq3.setCategoryID(3);
//		cq3.setCategoryName("SQL");
//				
//		CategoryQuestion cq4 = new CategoryQuestion();
//		cq4.setCategoryID(4);
//		cq4.setCategoryName("Postman");
//		
//		CategoryQuestion cq5 = new CategoryQuestion();
//		cq5.setCategoryID(5);
//		cq5.setCategoryName("Ruby");
//		
//		
//		//Question
//		Question question1 = new Question();
//		question1.questionID = 1;
//		question1.content = "Java là gì";
//		question1.category = cq1;
//		question1.type = tq1;
//		question1.creator = account1;
//		question1.createDate = new Date();
//		
//		Question question2 = new Question();
//		question2.questionID = 2;
//		question2.content = "Java được phát hành lần đầu tiên vào năm nào";
//		question2.category = cq1;
//		question2.type = tq2;
//		question2.creator = account1;
//		question2.createDate = new Date();
//		
//		Question question3 = new Question();
//		question3.questionID = 3;
//		question3.content = "Java do ai tạo ra";
//		question3.category = cq1;
//		question3.type = tq2;
//		question3.creator = account1;
//		question3.createDate = new Date();
//		
//		Question question4 = new Question();
//		question4.questionID = 4;
//		question4.content = "SQL là gì";
//		question4.category = cq3;
//		question4.type = tq1;
//		question4.creator = account2;
//		question4.createDate = new Date();
//		
//		//Answer
//		
//		Answer answer1 = new Answer();
//		answer1.setAnswerID(1);
//		answer1.setContent("Java là ngôn ngữ lập trình bậc cao");
//		answer1.setQuestion(question1);
//		answer1.setCorrect(true);
//		
//		Answer answer2 = new Answer();
//		answer2.setAnswerID(2);
//		answer2.setContent("Java là tên một hòn đảo");
//		answer2.setQuestion(question1);
//		answer2.setCorrect(true);
//		
//		Answer answer3 = new Answer();
//		answer3.setAnswerID(3);
//		answer3.setContent("SQL là ngôn ngữ truy vấn có cấu trúc");
//		answer3.setQuestion(question4);
//		answer3.setCorrect(true);
//		
//		Answer answer4 = new Answer();
//		answer4.setAnswerID(4);
//		answer4.setContent("SQL là một phần mềm");
//		answer4.setQuestion(question4);
//		answer4.setCorrect(false);
//		
//		//Exam
//		Exam exam1 = new Exam();
//		exam1.setExamID(1);
//		exam1.setCode("Java01");
//		exam1.setTitle("Bài kiểm tra về Java 01");
//		exam1.setCategory(cq1);
//		exam1.setDuration("90 phút");
//		exam1.setCreator(account1);
//		
//		Exam exam2 = new Exam();
//		exam2.setExamID(2);
//		exam2.setCode("SQL01");
//		exam2.setTitle("Bài kiểm tra về SQL 01");
//		exam2.setCategory(cq3);
//		exam2.setDuration("60 phút");
//		exam2.setCreator(account2);
//		exam2.setCreateDate(new Date());
//		
//		//ExamQuestion
//		ExamQuestion eq1 = new ExamQuestion();
//		eq1.setExam(exam1);
//		eq1.setQuestion(question1);
//		
//		ExamQuestion eq2 = new ExamQuestion();
//		eq2.setExam(exam1);
//		eq2.setQuestion(question2);
//		
//		ExamQuestion eq3 = new ExamQuestion();
//		eq3.setExam(exam1);
//		eq3.setQuestion(question3);
//		
//		ExamQuestion eq4 = new ExamQuestion();
//		eq4.setExam(exam2);
//		eq4.setQuestion(question4);
//		
//		//Question 3:
//		//Trong file Program.java, hãy in ít nhất 1 giá trị của mỗi đối tượng ra
//		System.out.println("Thông tin của các tài khoản trong hệ thống");
//		System.out.println("Tài khoản 1: ID "+ account1.getAccountID() +
//							", Email: " + account1.getEmail() +
//							", UserName: " + account1.getUserName() +
//							", FullName: " + account1.getFullName() +
//							", Department: " + account1.getDepartment().getDepartmentName() +
//							", Position: " + account1.getPosition().getPositionName() +
//							", Groups: " + account1.getGroups()[0].getGroupName() +", " + account1.getGroups()[1].getGroupName() +
//							", JoinDate: " + gr_account1.getJoinDate());
//		
//		// làm bài tâp assignment 2
//		
//		
//	}
//}
