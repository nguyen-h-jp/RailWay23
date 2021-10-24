-- Tiếp tục với Database Testing System
USE testing_system;
-- Exercise 1: Join
-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ

SELECT ac.full_name, dp.*
FROM `account` ac
JOIN department dp ON ac.department_id = dp.department_id;

-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010

SELECT *
FROM `account`
WHERE create_date > '2010/12/20';

-- Question 3: Viết lệnh để lấy ra tất cả các developer

SELECT full_name
FROM `account` ac JOIN position ps ON ac.position_id = ps.position_id
WHERE ps.position_name = 'Dev';

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên

SELECT dp.department_name as 'danh sách các phòng ban có số nhân viên lớn hơn 3'
FROM `account` ac
JOIN department dp ON ac.department_id = dp.department_id
GROUP BY ac.department_id
HAVING COUNT(ac.account_id) > 3;

-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất

SELECT *
FROM exam_question;
SELECT *
FROM question;

SELECT q.*, COUNT(exq.exam_id) AS 'Số lần được sử dụng trong đề thi'
FROM question q JOIN exam_question exq ON q.question_id = exq.question_id
GROUP BY q.question_id
HAVING COUNT(exq.exam_id) = (
	SELECT MAX(exam_count)
		FROM (SELECT COUNT(exam_id) as exam_count
			FROM exam_question
			GROUP BY question_id) as test);
            
-- Question 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question

select *
from category_question;
SELECT cq.category_name, COUNT(q.question_id) AS ' Số lần được sử dụng trong các câu hỏi'
FROM question q RIGHT JOIN category_question cq ON q.category_id = cq.category_id
GROUP BY cq.category_id;

-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam

SELECT *
FROM question;
SELECT *
FROM exam_question;
SELECT q.question_id, q.content, COUNT(eq.exam_id) AS 'Số lần xuất hiện trong các Exam' -- 
FROM question q LEFT JOIN exam_question eq ON q.question_id = eq.question_id
GROUP BY q.question_id;

-- Question 8: Lấy ra Question có nhiều câu trả lời nhất

SELECT *
FROM question;
SELECT *
FROM answer;
SELECT q.question_id, q.content, COUNT(a.answer_id) AS 'Số lần câu trả lời xuất hiện' 
FROM question q LEFT JOIN answer a ON q.question_id = a.question_id
GROUP BY q.question_id
HAVING COUNT(a.answer_id) = 
	(SELECT MAX(answer_count) 
		FROM (SELECT COUNT(a.answer_id) AS answer_count
			FROM answer a RIGHT JOIN question q ON a.question_id = q.question_id
				GROUP BY q.question_id) AS temp);  
                                     
-- đoạn dưới này để tìm số lượng câu trả lời nhiều nhất hoặc ít nhất của 1 câu hỏi
SELECT MIN(answer_count)
	FROM(SELECT COUNT(a.answer_id) AS answer_count
		FROM answer a RIGHT JOIN question q ON a.question_id = q.question_id
		GROUP BY q.question_id) AS temp;

-- Question 9: Thống kê số lượng account trong mỗi group

SELECT * 
FROM `group`;
SELECT * 
FROM group_account;
SELECT g.group_id, g.group_name, COUNT(ga.account_id) AS 'Số lượng người trong group' 
FROM `group` g LEFT JOIN group_account ga ON g.group_id = ga.group_id
GROUP BY g.group_id;

-- Question 10: Tìm chức vụ có ít người nhất

SELECT *
FROM position;
SELECT *
FROM `account`;

SELECT p.position_name, COUNT(a.account_id) AS 'Số lượng người trong phòng ban này'
FROM `position` p LEFT JOIN `account` a ON p.position_id = a.position_id
GROUP BY p.position_id
HAVING COUNT(a.account_id) = 
	(SELECT MIN(account_count)
		FROM (SELECT COUNT(a.account_id) AS account_count
			FROM `account` a RIGHT JOIN `position` p ON a.position_id = p.position_id  
				GROUP BY p.position_id) AS temp);
                
-- Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM

SELECT *
FROM department;
SELECT *
FROM `position`;
SELECT *
FROM `account`;

SELECT a.department_id, p.position_name, COUNT(a.position_id)
FROM department d JOIN `account` a ON d.department_id = a.department_id
	JOIN `position` p ON a.position_id = p.position_id
		WHERE p.position_name IN('Dev', 'Test', 'Scrum Master', 'PM')
        GROUP BY d.department_id, p.position_id;
        
-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, …

SELECT *
FROM question;
SELECT *
FROM answer;
SELECT q.question_id, q.content, tq.type_name, ac.username, a.content
FROM question q LEFT JOIN answer a ON q.question_id = a.question_id
LEFT JOIN `account` ac ON ac.account_id = q.creator_id
LEFT JOIN type_question tq ON tq.type_id = q.type_id
GROUP BY q.question_id;

-- Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT *
FROM question;
SELECT *
FROM type_question;

SELECT tq.type_name, COUNT(q.type_id) AS 'Số lượng câu hỏi'
FROM question q JOIN type_question tq ON q.type_id = tq.type_id
GROUP BY tq.type_id;

-- Question 14: Lấy ra group không có account nào 

SELECT *
FROM `group`;
SELECT *
FROM group_account;

SELECT g.group_id, g.group_name, COUNT(ga.group_id) AS 'Số lượng người trong Group'
FROM group_account ga RIGHT JOIN `group` g ON ga.group_id = g.group_id
GROUP BY g.group_id
HAVING COUNT(ga.group_id) = 0;

-- Question 15: Lấy ra group không có account nào(giống câu 14)
-- Question 16: Lấy ra question không có answer nào

SELECT q.question_id, q.content, COUNT(a.answer_id) AS 'Số lượng câu trả lời cho câu hỏi'
FROM question q LEFT JOIN answer a ON q.question_id = a.question_id
GROUP BY q.question_id
HAVING COUNT(a.answer_id) = 0;

-- Exercise 2: Union
-- Question 17:
-- 		a) Lấy các account thuộc nhóm thứ 1

SELECT *
FROM group_account;
SELECT *
FROM `account`;

SELECT a.username, ga.group_id
FROM group_account ga LEFT JOIN `account` a ON ga.account_id = a.account_id
WHERE group_id = 1;

-- 		b) Lấy các account thuộc nhóm thứ 2

SELECT a.username, ga.group_id
FROM group_account ga LEFT JOIN `account` a ON ga.account_id = a.account_id
WHERE group_id = 2;

-- 		c) Ghép 2 kết quả từ câu a) và câu b) sao cho không có record nào trùng nhau

SELECT a.username, ga.group_id
FROM group_account ga LEFT JOIN `account` a ON ga.account_id = a.account_id
WHERE group_id = 1
UNION
SELECT a.username, ga.group_id
FROM group_account ga LEFT JOIN `account` a ON ga.account_id = a.account_id
WHERE group_id = 2;
-- Question 18:
-- 		a) Lấy các group có lớn hơn 5 thành viên

SELECT ga.group_id, COUNT(a.account_id)
FROM group_account ga LEFT JOIN `account` a ON ga.account_id = a.account_id
GROUP BY ga.group_id
HAVING COUNT(a.account_id) > 5;

-- 		b) Lấy các group có nhỏ hơn 7 thành viên

SELECT ga.group_id, COUNT(a.account_id)
FROM group_account ga LEFT JOIN `account` a ON ga.account_id = a.account_id
GROUP BY ga.group_id
HAVING COUNT(a.account_id) < 7;

-- 		c) Ghép 2 kết quả từ câu a) và câu b)

SELECT ga.group_id, COUNT(a.account_id)
FROM group_account ga LEFT JOIN `account` a ON ga.account_id = a.account_id
GROUP BY ga.group_id
HAVING COUNT(a.account_id) > 5
UNION ALL
SELECT ga.group_id, COUNT(a.account_id)
FROM group_account ga LEFT JOIN `account` a ON ga.account_id = a.account_id
GROUP BY ga.group_id
HAVING COUNT(a.account_id) < 7;