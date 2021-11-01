USE testing_system;

-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó
SELECT * FROM department;
DESCRIBE department;

DROP PROCEDURE IF EXISTS sp_lay_ten_theo_ten_phong;
DELIMITER $$
CREATE PROCEDURE sp_lay_ten_theo_ten_phong(IN departmentName VARCHAR(50) CHAR SET utf8mb4)
	BEGIN
		SELECT a.*
			FROM `account` a JOIN department d ON a.department_id = d.department_id
				WHERE d.department_name = departmentName;
	END $$
DELIMITER ;
CALL sp_lay_ten_theo_ten_phong('Sales');

-- Question 2: Tạo store để in ra số lượng account trong mỗi group

SELECT * FROM `account`;
SELECT * FROM group_account;
DESCRIBE group_account;

DROP PROCEDURE IF EXISTS dem_account_trong_group;
DELIMITER $$
CREATE PROCEDURE dem_account_trong_group()
	BEGIN
		SELECT g.group_name, count(ga.account_id) AS 'Số lượng người trong group'
			FROM group_account ga RIGHT JOIN `group` g ON ga.group_id = g.group_id
				GROUP BY g.group_id;
	END $$
DELIMITER ;

CALL dem_account_trong_group();

-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại

SELECT * FROM type_question;
SELECT * FROM question;
DESCRIBE group_account;

DROP PROCEDURE IF EXISTS dem_question_theo_type;
DELIMITER $$
CREATE PROCEDURE dem_question_theo_type()
	BEGIN
		SELECT tq.type_name, COUNT(q.question_id) AS 'Số câu hỏi được tạo trong tháng này'
			FROM type_question tq LEFT JOIN question q ON tq.type_id = q.type_id
				WHERE (SELECT MONTH(q.create_date)) = (SELECT MONTH(CURDATE()))
					GROUP BY tq.type_id;
	END $$
DELIMITER ;

CALL dem_question_theo_type();

-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất

SELECT * FROM type_question;
SELECT * FROM question;

DROP PROCEDURE IF EXISTS sp_max_count_of_type_question;

DELIMITER $$ 
CREATE PROCEDURE sp_max_count_of_type_question(OUT typeID INT)
	BEGIN
		SELECT tq.type_id INTO typeID
		FROM type_question tq LEFT JOIN question q ON tq.type_id = q.type_id 
		GROUP BY tq.type_id
			HAVING COUNT(q.question_id) = (
				SELECT MAX(question_count)
					FROM (SELECT COUNT(question_id) as question_count
						FROM question
							GROUP BY type_id) AS temp);
    END$$
DELIMITER ;

SET @typeID = '';
CALL sp_max_count_of_type_question(@typeID);
SELECT @typeID; 

-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question

DROP PROCEDURE IF EXISTS get_type_name_by_id;
DELIMITER $$ 
CREATE PROCEDURE get_type_name_by_id()
	BEGIN
		DECLARE typeID INT;
        SET typeID = 0;
        CALL sp_max_count_of_type_question(typeID); 
        SELECT type_name 
        FROM type_question 
        WHERE type_id = typeID;
    END$$
DELIMITER ;
CALL get_type_name_by_id();

-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên
-- chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa chuỗi của người dùng nhập vào

DROP PROCEDURE IF EXISTS sp_tim_group_hoac_user;
DELIMITER $$
CREATE PROCEDURE sp_tim_group_hoac_user(IN searchString VARCHAR(50))
	BEGIN
		SELECT group_name COLLATE utf8mb4_unicode_ci AS 'Search result'
        FROM `group`
        WHERE group_name COLLATE utf8mb4_unicode_ci LIKE CONCAT('%',searchString,'%')
			UNION ALL
        SELECT username COLLATE utf8mb4_unicode_ci AS 'Search result'
        FROM `account`
        WHERE username COLLATE utf8mb4_unicode_ci LIKE CONCAT('%',searchString,'%');
    END$$
DELIMITER ;
CALL sp_tim_group_hoac_user('g');

-- Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và trong store sẽ tự động gán:
-- username sẽ giống email nhưng bỏ phần @..mail đi
-- positionID: sẽ có default là developer
-- departmentID: sẽ được cho vào 1 phòng chờ
-- Sau đó in ra kết quả tạo thành công

DESCRIBE `account`;

DROP PROCEDURE IF EXISTS sp_auto_insert_account;
DELIMITER $$
CREATE PROCEDURE sp_auto_insert_account(IN inFullName VARCHAR(50) CHAR SET utf8mb4, IN inEmail VARCHAR(50) CHAR SET utf8mb4)
	BEGIN
        DECLARE User_name VARCHAR(50) DEFAULT SUBSTRING_INDEX(inEmail, "@gmail.com", 1);
		DECLARE positionID INT DEFAULT 1;
		DECLARE departmentID INT DEFAULT 11;
        DECLARE createDate DATE DEFAULT '2021/10/29';
        INSERT INTO `account`(email, username, full_name, department_id, position_id, create_date)
			VALUES
				(inEmail, User_name, inFullName, departmentID, positionID, createDate);
        SELECT * FROM `account`
        WHERE username = User_name COLLATE utf8mb4_unicode_ci;
		-- ORDER BY account_id DESC limit 1;
	END$$
DELIMITER ;
CALL sp_auto_insert_account('Nguyễn Tiến Hùng', 'nguyenhung1@gmail.com');

-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
-- để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất

SELECT * FROM question;
SELECT * FROM type_question;

DROP PROCEDURE IF EXISTS sp_max_of_essay_or_multiple_choice;
DELIMITER $$
CREATE PROCEDURE sp_max_of_essay_or_multiple_choice(IN Choice VARCHAR(50))
	BEGIN
		SELECT tq.type_id, q.content, tq.type_name, LENGTH(q.content) AS length_of_content
		FROM type_question tq LEFT JOIN question q ON tq.type_id = q.type_id
		WHERE LENGTH(q.content) = 
			(SELECT MAX(length_of_content)
				FROM (SELECT lENGTH(q.content) AS length_of_content
					FROM question q RIGHT JOIN type_question tq ON q.type_id = tq.type_id
						WHERE tq.type_name = Choice
							GROUP BY tq.type_id) AS temp)
			AND tq.type_name = Choice;
	END$$
DELIMITER ;

CALL sp_max_of_essay_or_multiple_choice('multiple_choice');
CALL sp_max_of_essay_or_multiple_choice('essay');

-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
SELECT * FROM exam;
SELECT * FROM exam_question;
DESCRIBE exam;

DROP PROCEDURE IF EXISTS sp_delete_exam_by_exam_id;
DELIMITER $$
CREATE PROCEDURE sp_delete_exam_by_exam_id(IN examID INT)
	BEGIN
		DELETE
        FROM exam
        WHERE exam_id = examID;
	END$$
DELIMITER ;

CALL sp_delete_exam_by_exam_id(2);

-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử dụng store ở câu 9 để xóa)
-- Sau đó in số lượng record đã remove từ các table liên quan trong khi removing

SELECT * FROM exam;
SELECT * FROM exam_2;
SELECT * FROM exam_question;
DESCRIBE exam;

DROP PROCEDURE IF EXISTS xoa_exam_3_nam_truoc;
DELIMITER $$
CREATE PROCEDURE xoa_exam_3_nam_truoc()
	BEGIN
		-- thêm giữ liệu trước khi xóa vào 1 bảng tạm là exam_2 có cấu trúc giống bảng exam
        DROP TABLE IF EXISTS exam_2;
        CREATE TABLE exam_2 LIKE exam; 
		INSERT INTO exam_2
        SELECT * FROM exam
        WHERE create_date <= DATE_SUB(CURDATE(),INTERVAL 3 YEAR);
		-- xóa dữ liệu
        -- CURSOR
        DELETE
        FROM exam
        WHERE create_date <= DATE_SUB(CURDATE(),INTERVAL 3 YEAR);
        -- select ra những dữ liệu đã xóa
        SELECT * FROM exam_2;
	END$$
DELIMITER ;

SELECT DATE_SUB(CURDATE(),INTERVAL 3 YEAR);

CALL xoa_exam_3_nam_truoc();
SELECT * FROM exam;
SELECT * FROM exam_2;

-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử dụng store ở câu 9 để xóa)
-- Sau đó in số lượng record đã remove từ các table liên quan trong khi removing
-- SELECT ROW_COUNT();
INSERT INTO exam(`code`, title, category_id, duration, creator_id, create_date) 
VALUES 
	('RB1'	, 'title ruby1'		, 5		, 50	, 1		, '2018-05-05'),
	('VB1'	, 'title vb 11'		, 6		, 120	, 3		, '2017-06-15'),
	('VB61'	, 'title vb6 11'	, 6		, 120	, 3		, '2016-06-15');

drop procedure if exists sp_delete_exam_and_select_count_record;
DELIMITER $$
create procedure sp_delete_exam_and_select_count_record()
begin
	declare examId tinyint;
    declare delRowCntExam tinyint;
    declare delRowCntExamQuestion tinyint;

    -- biến để xem cursor đã đến dòng cuối chưa
	declare done boolean default false;
    -- tạo cursor các exam được tạo từ 3 năm trước
	declare myCursor cursor for
    select exam_id from exam where year(create_date) <= year(date_add(curdate(), interval -3 year));
    
    -- điều khiển hoạt động của cursor khi đến dòng cuối(set là true)
	declare continue handler for not found set done = true;  
    
    -- đếm số dòng sẽ xóa của bảng exam, exam_question
    select count(e.exam_id) cnt_ex into delRowCntExam
	from exam e
	where year(create_date) <= year(date_add(curdate(), interval -3 year));
    
    select count(eq.exam_id) cnt_ex_ques into delRowCntExamQuestion
	from exam e
	left join exam_question eq on e.exam_id = eq.exam_id
	where year(create_date) <= year(date_add(curdate(), interval -3 year));
    
    -- sử dụng store ở câu 9 để xóa
	-- mở cursor
	open myCursor;
		-- lặp từng dòng
		read_loop: loop
			-- đọc từng dòng của cursor
			fetch myCursor into examId;
			
			-- xóa dlieu
			call sp_delete_exam_by_exam_id(examId);

			-- đến dòng cuối thì thoát đọc loop
			if done then
			  leave read_loop;
			end if;
		end loop;
	  
	-- đóng cursor
	close myCursor;	
    select concat('exam table ', delRowCntExam, ' record', ', exam_question table ', delRowCntExamQuestion, ' record') as 'số lượng record đã remove';
end$$
DELIMITER ;
-- gọi thủ tục
call sp_delete_exam_and_select_count_record();

-- Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng
-- nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được
-- chuyển về phòng ban default là phòng ban chờ việc

SELECT * FROM department;
DESCRIBE department;

DROP PROCEDURE IF EXISTS sp_xoa_phong_ban;
DELIMITER $$
CREATE PROCEDURE sp_xoa_phong_ban(IN departmentName VARCHAR(50) CHAR SET utf8mb4)
	BEGIN
		-- chuyển các nhân viên trong phòng ban sẽ xóa vào phòng Waiting Room có department_id là 11
        UPDATE `account`
        SET department_id = (
			SELECT department_id 
            FROM department
            WHERE department_name = 'Waiting Room'
        )
        WHERE department_id = (
			SELECT department_id 
            FROM department 
            WHERE department_name = departmentName);
        -- xóa phòng ban
        DELETE
        FROM department
        WHERE department_name = departmentName;
	END$$
DELIMITER ;

CALL sp_xoa_phong_ban('Bảo vệ');
SELECT * FROM `account`;
SELECT * FROM department;

-- Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm nay

SELECT * FROM question;

DROP PROCEDURE IF EXISTS sp_question_created_this_year;

DELIMITER $$
CREATE PROCEDURE sp_question_created_this_year()
	BEGIN
		SELECT MONTH(create_date) AS 'Tháng', COUNT(question_id) AS 'Số câu hỏi được tạo trong tháng này'
        FROM question
        WHERE YEAR(create_date) = YEAR(NOW())
        GROUP BY MONTH(create_date);
    END$$
DELIMITER ;

CALL sp_question_created_this_year();

-- Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6 tháng gần đây nhất
-- (Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong tháng")
SELECT * FROM question;
DROP PROCEDURE IF EXISTS sp_question_created_6_month_before;

DELIMITER $$
CREATE PROCEDURE sp_question_created_6_month_before()
	BEGIN
		WITH table_6_month_before AS (
			SELECT MONTH(DATE_SUB(NOW(), INTERVAL 5 MONTH)) AS mon 
				UNION
			SELECT MONTH(DATE_SUB(NOW(), INTERVAL 4 MONTH)) AS mon 
				UNION
			SELECT MONTH(DATE_SUB(NOW(), INTERVAL 3 MONTH)) AS mon
				UNION
			SELECT MONTH(DATE_SUB(NOW(), INTERVAL 2 MONTH)) AS mon
				UNION
			SELECT MONTH(DATE_SUB(NOW(), INTERVAL 1 MONTH)) AS mon
				UNION
			SELECT MONTH(NOW()) AS mon),
		table_2 AS(
			SELECT MONTH(create_date) AS mcd, question.* 
            FROM question 
            WHERE create_date > DATE_SUB(NOW(),INTERVAL 6 MONTH) 
            GROUP BY mcd)
		
        SELECT tb.mon, CASE WHEN COUNT(tb2.question_id) = 0 THEN 'Không có câu hỏi nào trong tháng này' ELSE COUNT(tb2.question_id) END AS 'Số lượng câu hỏi'
        FROM table_6_month_before tb LEFT JOIN table_2 tb2 ON tb.mon = tb2.mcd
        GROUP BY tb.mon;
    END$$
DELIMITER ;

CALL sp_question_created_6_month_before();

-- hung 6