package com.vti.entity;
import java.util.Date;

/*Table 8: Question
 QuestionID: định danh của câu hỏi (auto increment)
 Content: nội dung của câu hỏi
 CategoryID: định danh của chủ đề câu hỏi
 TypeID: định danh của loại câu hỏi
 CreatorID: id của người tạo câu hỏi
 CreateDate: ngày tạo câu hỏi*/

public class Question {
	int questionID;
	String content;
	CategoryQuestion category;
	TypeQuestion type;
	Account creator;
	Date createDate;
}
