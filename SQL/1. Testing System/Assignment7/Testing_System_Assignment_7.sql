USE testing_system;

-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo trước 1 năm trước
SELECT * FROM `group`;

DROP TRIGGER IF EXISTS khong_cho_phep_nhap_group_co_ngay_tao_mot_nam_truoc;
DELIMITER $$
CREATE TRIGGER khong_cho_phep_nhap_group_co_ngay_tao_mot_nam_truoc
	BEFORE INSERT ON `group`
		FOR EACH ROW
			BEGIN
				IF NEW.create_date < (DATE_SUB(NOW(), INTERVAL 1 YEAR))
					THEN 
                    SIGNAL SQLSTATE '12345'
                    SET MESSAGE_TEXT = 'ngày tạo không hợp lệ';
				END IF;
            END$$
DELIMITER ;    

INSERT INTO `group`(group_name, creator_id, create_date)
VALUES
	('group9', 2, '2021/10/18');
    
SELECT * FROM `group`;

-- Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào
-- department "Sale" nữa, khi thêm thì hiện ra thông báo "Department "Sale" cannot add more user"
SELECT * FROM department;
SELECT * FROM `account`;

DROP TRIGGER IF EXISTS khong_cho_phep_them_vao_phong_sales;
DELIMITER $$
CREATE TRIGGER khong_cho_phep_them_vao_phong_sales
	BEFORE INSERT ON `account`
		FOR EACH ROW
			BEGIN
				IF NEW.department_id = (SELECT department_id FROM department WHERE department_name = 'Sales')
					THEN 
                    SIGNAL SQLSTATE '12345'
                    SET MESSAGE_TEXT = 'Department "Sale" cannot add more user';
				END IF;
            END$$
DELIMITER ;

INSERT INTO `account`(email, username, full_name, department_id, position_id, create_date)
VALUES
	('a9@gmail.com', 'a9', 'Trần Văn A', 2, 1, '2021/09/18');
    
-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user

SELECT * FROM `group`;
SELECT * FROM group_account;

DROP TRIGGER IF EXISTS khong_cho_phep_group_nhieu_hon_5_nguoi;
DELIMITER $$
CREATE TRIGGER khong_cho_phep_group_nhieu_hon_5_nguoi
	AFTER INSERT ON group_account
		FOR EACH ROW
			BEGIN
				DECLARE account_count int;
                SELECT COUNT(account_id) INTO account_count
                FROM group_account
                WHERE group_id = NEW.group_id
                GROUP BY group_id;
                IF account_count > 5 
                THEN 
                    SIGNAL SQLSTATE '12345'
                    SET MESSAGE_TEXT = '1 group không thể có nhiều hơn 5 người';
				END IF;
            END$$
DELIMITER ;


show TRIGGERS;

INSERT INTO group_account(group_id, account_id, join_date)
VALUES
    (2, 7, '2021/10/15');
 
-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question

SELECT * FROM question;
SELECT * FROM exam;
SELECT * FROM exam_question;

DROP TRIGGER IF EXISTS khong_cho_phep_mot_bai_thi_co_hon_10_question;
DELIMITER $$
CREATE TRIGGER khong_cho_phep_mot_bai_thi_co_hon_10_question
	AFTER INSERT ON exam_question
		FOR EACH ROW
			BEGIN
				DECLARE question_count int;
                SELECT COUNT(question_id) INTO question_count
                FROM exam_question
                WHERE exam_id = NEW.exam_id
                GROUP BY exam_id;
                IF question_count > 10 
                THEN 
                    SIGNAL SQLSTATE '12345'
                    SET MESSAGE_TEXT = '1 bài thi không thể có nhiều hơn 10 question';
				END IF;
            END$$
DELIMITER ;

SELECT COUNT(question_id)
                FROM exam_question
                WHERE exam_id = 1
                GROUP BY exam_id;
INSERT INTO exam_question(exam_id, question_id)
VALUES
	(1, 12);
    
-- Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là
-- admin@gmail.com (đây là tài khoản admin, không cho phép user xóa),
-- còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông
-- tin liên quan tới user đó

show TRIGGERS;

DROP TRIGGER IF EXISTS khong_cho_phep_xoa_email_cua_admin;
DELIMITER $$
CREATE TRIGGER khong_cho_phep_xoa_email_cua_admin
	BEFORE DELETE ON `account`
		FOR EACH ROW
			BEGIN
                IF OLD.email = 'admin@gmail.com'
                THEN 
                    SIGNAL SQLSTATE '12345'
                    SET MESSAGE_TEXT = 'không thể xóa email của admin';
				END IF;
            END$$
DELIMITER ;

SELECT * FROM `account`;
-- TRY TO XÓA ADMIN
DELETE FROM `account`
WHERE email = 'admin@gmail.com';
-- XÓA TÀI KHOẢN KHÁC ADMIN
DELETE FROM `account`	
WHERE email = 'a@gmail.com';

-- Question 6: Không sử dụng cấu hình default cho field DepartmentID của table
-- Account, hãy tạo trigger cho phép người dùng khi tạo account không điền
-- vào departmentID thì sẽ được phân vào phòng ban "waiting Department"

SELECT * FROM department;
SELECT * FROM `account`;

DROP TRIGGER IF EXISTS set_default_for_account_which_not_input_department_id;
DELIMITER $$
CREATE TRIGGER set_default_for_account_which_not_input_department_id
	BEFORE INSERT ON `account`
		FOR EACH ROW
			BEGIN
                IF NEW.department_id IS NULL
                THEN 
                   SET NEW.department_id = (SELECT department_id FROM department WHERE department_name = 'Waiting Room');
				END IF;
            END$$
DELIMITER ;

INSERT INTO `account`(email, username, full_name, position_id, create_date)
VALUES
	('a99@gmail.com', 'a99', 'Trần Văn X', 1, '2021/09/18');

-- Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi
-- question, trong đó có tối đa 2 đáp án đúng.(chưa chạy đúng, lỗi : Error Code: 1172. Result consisted of more than one row)

SELECT * FROM exam_question;
SELECT * FROM question;
SELECT * FROM answer;

DROP TRIGGER IF EXISTS question_toi_da_4_answer_va_toi_da_2_cau_tra_loi_dung;
DELIMITER $$
CREATE TRIGGER question_toi_da_4_answer_va_toi_da_2_cau_tra_loi_dung
	BEFORE INSERT ON answer
		FOR EACH ROW
			BEGIN
				DECLARE count_answer INT;
				DECLARE count_answer_is_correct INT;
                
                SELECT COUNT(answer_id) INTO count_answer 
                FROM answer
                WHERE question_id = NEW.question_id;
                
                SELECT COUNT(answer_id) INTO count_answer_is_correct
                FROM answer
                WHERE question_id = NEW.question_id AND NEW.is_correct = 1;
                
                IF count_answer = 4
                THEN 
					SIGNAL SQLSTATE '12345'
                    SET MESSAGE_TEXT = '1 câu hỏi không thể có quá 4 câu trả lời';
				END IF;
                
                IF count_answer_is_correct = 2
                THEN 
					SIGNAL SQLSTATE '12345'
                    SET MESSAGE_TEXT = '1 câu hỏi không thể có quá 2 câu trả lời đúng';
				END IF;
            END$$
DELIMITER ;

SELECT * FROM answer;

INSERT INTO answer(content, question_id, is_correct)
VALUES
	('Java là ngôn ngữ lập trình 2', 1, true),
	('Java là ngôn ngữ lập trình 3', 1, true);

-- Question 8: Viết trigger sửa lại dữ liệu cho đúng:
-- Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định
-- Thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database(chưa có trường gender trong bảng account)

DROP TRIGGER IF EXISTS check_and_set_gioi_tinh; 
DELIMITER $$ 
CREATE TRIGGER check_and_set_gioi_tinh 
	BEFORE INSERT ON `account` 
	FOR EACH ROW 
		BEGIN 
			IF NEW.gender = 'Nam' 
			THEN 
			SET NEW.gender = 'M'; 
			ELSEIF NEW.gender = 'Nữ' 
			THEN 
			SET NEW.gender = 'F'; 
			ELSEIF NEW.gender = 'chưa xác định' 
			THEN SET NEW.gender = 'U'; 
		END IF ;
	END $$ 
DELIMITER ;

-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày

SELECT * FROM exam;

DROP TRIGGER IF EXISTS khong_cho_phep_xoa_bai_thi_moi_tao_duoc_2_ngay;
DELIMITER $$
CREATE TRIGGER khong_cho_phep_xoa_bai_thi_moi_tao_duoc_2_ngay
	BEFORE DELETE ON exam
		FOR EACH ROW
			BEGIN
                IF OLD.create_date > DATE_SUB(CURDATE(),INTERVAL 2 DAY)
                THEN 
					SIGNAL SQLSTATE '12345'
                    SET MESSAGE_TEXT = 'không thể xóa exam được tạo 2 ngày trước';
				END IF;
            END$$
DELIMITER ;

DELETE FROM exam WHERE create_date = '2021/10/18';

-- Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các
-- question khi question đó chưa nằm trong exam nào

SELECT * FROM question;
SELECT * FROM exam_question;
SELECT * FROM exam;
-- phần update
DROP TRIGGER IF EXISTS khong_cho_phep_update;
DELIMITER $$
CREATE TRIGGER khong_cho_phep_update
	BEFORE UPDATE ON question
		FOR EACH ROW
			BEGIN
                DECLARE count_question INT;
                SET count_question = 0;
                SELECT COUNT(exam_id) INTO count_question
                FROM exam_question
                WHERE question_id = NEW.question_id
                GROUP BY question_id;
				IF count_question != 0
                THEN 
					SIGNAL SQLSTATE '12345'
                    SET MESSAGE_TEXT = 'không thể cập nhật question này';
				END IF;
            END$$
DELIMITER ;

SELECT * FROM question;

UPDATE question
SET content = 'test'
WHERE question_id = 1;

-- phần delete
DROP TRIGGER IF EXISTS khong_cho_phep_delete;
DELIMITER $$
CREATE TRIGGER khong_cho_phep_delete
	BEFORE DELETE ON question
		FOR EACH ROW
			BEGIN
                DECLARE count_question INT;
                SET count_question = 0;
                SELECT COUNT(exam_id) INTO count_question
                FROM exam_question
                WHERE question_id = OLD.question_id
                GROUP BY question_id;
				IF count_question != 0
                THEN 
					SIGNAL SQLSTATE '12345'
                    SET MESSAGE_TEXT = 'không thể xóa question này';
				END IF;
            END$$
DELIMITER ;

DELETE FROM question WHERE question_id = 1;

-- Question 12: Lấy ra thông tin exam trong đó:
-- Duration <= 30 thì sẽ đổi thành giá trị "Short time"
-- 30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time"
-- Duration > 60 thì sẽ đổi thành giá trị "Long time

SELECT * FROM exam;

SELECT exam_id, `code`, title, category_id, CASE WHEN duration <= 30 THEN 'Short time' WHEN duration <= 60 THEN 'Medium time' ELSE 'Long time' END AS duration , duration, creator_id, create_date
FROM exam;

-- Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa 
-- có tên là the_number_user_amount và mang giá trị được quy định như sau: 
-- Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few 
-- Nếu số lượng user trong group <= 20 và > 5 thì sẽ có giá trị là normal 
-- Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher

SELECT * FROM group_account;

SELECT group_id, COUNT(account_id), CASE WHEN COUNT(account_id) <=  5 THEN 'few' WHEN  COUNT(account_id) <= 20 THEN 'normal' ELSE 'higher' END AS the_number_user_amount 
FROM group_account
GROUP BY group_id;

-- Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào
-- không có user thì sẽ thay đổi giá trị 0 thành "Không có User"

SELECT * FROM department;
SELECT * FROM `account`;

SELECT d.department_id, d.department_name, CASE WHEN COUNT(a.account_id) > 0 THEN COUNT(a.account_id) ELSE 'Không có user' END AS 'Số lượng user'
FROM `account` a RIGHT JOIN department d ON a.department_id = d.department_id
GROUP BY d.department_id;
-- hung 7