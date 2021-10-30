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
CREATE PROCEDURE sp_max_count_of_type_question()
	BEGIN
		SELECT tq.type_id AS 'type_id của type_question có nhiều câu hỏi nhất'
			FROM type_question tq LEFT JOIN question q ON tq.type_id = q.type_id 
				GROUP BY tq.type_id
					HAVING COUNT(q.question_id) = (
						SELECT MAX(question_count)
							FROM (SELECT COUNT(question_id) as question_count
								FROM question
									GROUP BY type_id) AS temp);
    END$$
DELIMITER ;

CALL sp_max_count_of_type_question(); 

-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question

DROP PROCEDURE IF EXISTS sp_max_count_of_type_question;

DELIMITER $$ 
CREATE PROCEDURE sp_max_count_of_type_question()
	BEGIN
		SELECT tq.type_name AS 'type_name của type_question có nhiều câu hỏi nhất'
			FROM type_question tq LEFT JOIN question q ON tq.type_id = q.type_id 
				GROUP BY tq.type_id
					HAVING COUNT(q.question_id) = (
						SELECT MAX(question_count)
							FROM (SELECT COUNT(question_id) as question_count
								FROM question
									GROUP BY type_id) AS temp);
    END$$
DELIMITER ;

CALL sp_max_count_of_type_question(); 

-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên
-- chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa chuỗi của người dùng nhập vào

SELECT * FROM `group`;
SELECT * FROM `account`;
SELECT * FROM group_account;

DROP PROCEDURE IF EXISTS sp_ten_thanh_vien_hoac_nhom;
DELIMITER $$
CREATE PROCEDURE sp_ten_thanh_vien_hoac_nhom(IN nhap_ky_tu VARCHAR(20) CHAR SET utf8mb4)
	BEGIN 
		SELECT g.group_name, a.username 
			FROM `group` g JOIN group_account ga ON g.group_id = ga.group_id
				JOIN `account` a ON ga.account_id = a.account_id
					WHERE g.group_name LIKE CONCAT('%',nhap_ky_tu,'%')
						OR a.username LIKE CONCAT('%',nhap_ky_tu,'%');
	END$$
DELIMITER ;

CALL sp_ten_thanh_vien_hoac_nhom('group3');

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
		DECLARE Username VARCHAR(50) DEFAULT SUBSTRING_INDEX(inEmail, "@gmail.com", 1);
		DECLARE positionID INT DEFAULT 1;
		DECLARE departmentID INT DEFAULT 11;
        DECLARE createDate DATE DEFAULT '2021/10/29';
        INSERT INTO `account`(email, username, full_name, department_id, position_id, create_date)
			VALUES
				(inEmail, Username, inFullName, departmentID, positionID, createDate);
	END$$
DELIMITER ;
CALL sp_auto_insert_account('Nguyễn Tiến Hùng', 'nguyenhung@gmail.com');

SELECT * FROM `account`
WHERE username = 'nguyenhung';

-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
-- để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất

SELECT * FROM question;
SELECT * FROM type_question;

DROP PROCEDURE IF EXISTS sp_max_of_essay_or_multiple_choice;
DELIMITER $$
CREATE PROCEDURE sp_max_of_essay_or_multiple_choice(IN Choice VARCHAR(50))
	BEGIN
		IF Choice = 'essay'
        THEN
		SELECT tq.type_id, tq.type_name, LENGTH(q.content) AS length_of_content
			FROM type_question tq LEFT JOIN question q ON tq.type_id = q.type_id
				WHERE tq.type_name = 'essay'
					GROUP BY tq.type_id
						HAVING length_of_content = 
							(SELECT MAX(length_of_content)
								FROM (SELECT lENGTH(q.content) AS length_of_content
									FROM question q RIGHT JOIN type_question tq ON q.type_id = tq.type_id
										WHERE tq.type_name = 'essay'
											GROUP BY tq.type_id) AS temp);
		ELSEIF Choice = 'multiple_choice'
		THEN
        SELECT tq.type_id, tq.type_name, LENGTH(q.content) AS length_of_content
			FROM type_question tq LEFT JOIN question q ON tq.type_id = q.type_id
				WHERE tq.type_name = 'multiple_choice'
					GROUP BY tq.type_id
						HAVING length_of_content = 
							(SELECT MAX(length_of_content)
								FROM (SELECT lENGTH(q.content) AS length_of_content
									FROM question q RIGHT JOIN type_question tq ON q.type_id = tq.type_id
										WHERE tq.type_name = 'multiple_choice'
											GROUP BY tq.type_id) AS temp);
		END IF;
	END$$
DELIMITER ;

CALL sp_max_of_essay_or_multiple_choice('multiple_choice');
CALL sp_max_of_essay_or_multiple_choice('essay');

-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
SELECT * FROM exam;
SELECT * FROM exam_question;
DESCRIBE exam;

DROP PROCEDURE IF EXISTS delete_exam_by_exam_id;
DELIMITER $$
CREATE PROCEDURE delete_exam_by_exam_id(IN examID INT)
	BEGIN
		DELETE
        FROM exam
        WHERE exam_id = examID;
	END$$
DELIMITER ;

CALL delete_exam_by_exam_id(2);

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
        WHERE create_date < DATE_SUB(NOW(),INTERVAL 3 YEAR);
		-- xóa dữ liệu
        DELETE
        FROM exam
        WHERE create_date < DATE_SUB(NOW(),INTERVAL 3 YEAR);
        -- select ra những dữ liệu đã xóa
        SELECT * FROM exam_2;
	END$$
DELIMITER ;

CALL xoa_exam_3_nam_truoc();
SELECT * FROM exam;
SELECT * FROM exam_2;

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
        SET department_id = 11
        WHERE department_id = (SELECT department_id FROM department WHERE department_name = departmentName);
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