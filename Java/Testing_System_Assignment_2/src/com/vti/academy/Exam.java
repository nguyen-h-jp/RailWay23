package com.vti.academy;
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
	int examID;
	String code;
	String title;
	CategoryQuestion category;
	String duration;
	Account creator;
	Date createDate;	
}
