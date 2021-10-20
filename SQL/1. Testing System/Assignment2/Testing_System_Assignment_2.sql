DROP DATABASE IF EXISTS testing_system;
CREATE DATABASE testing_system;
USE testing_system;
ALTER DATABASE testing_system CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
-- table 1
DROP TABLE IF EXISTS department; 
CREATE TABLE department(
    department_id 	INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    department_name VARCHAR(50) CHAR SET UTF8MB4 UNIQUE NOT NULL
);
-- thêm data vào bảng department
INSERT INTO department(department_name)
VALUES
	('Marketing'	),
	('Sales'		),
	('Bảo vệ'		),
	('Nhân sự'		),
	('Kỹ thuật'		),
	('Tài chính'	),
	('Phó giám đốc'	),
	('Giám đốc'		),
	('Thư kí'		),
	('Bán hàng'		);
SELECT * FROM department;
-- table 2 
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position`(
    position_id 	INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    position_name 	ENUM('Dev','Test','Scrum Master','PM') 
);
-- thêm data vào bảng position
INSERT INTO `position`(position_name)
VALUES 
	('Dev'),
    ('Test'),
    ('Scrum Master'),
    ('PM');
SELECT * FROM `position`;
-- table 3
SET foreign_key_checks = 0; -- ??
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`(
    account_id 		INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    email 			VARCHAR(50) UNIQUE  NOT NULL,
    username 		VARCHAR(50) CHAR SET UTF8MB4 UNIQUE  NOT NULL,
    full_name 		VARCHAR(50) CHAR SET UTF8MB4 NOT NULL,
    department_id 	INT NOT NULL, -- (FK)
    position_id 	INT NOT NULL, -- (FK)
    create_date 	DATE,
    FOREIGN KEY (department_id) REFERENCES department(department_id),
    FOREIGN KEY (position_id) REFERENCES `position`(position_id)
);
SET foreign_key_checks = 1;
-- thêm data vào bảng account
INSERT INTO `account`(email, username, full_name, department_id, position_id, create_date)
VALUES
	('nguyen_a@gmail.com', 'nguyen_a', 'Nguyễn A', 1, 1, '2021/09/18'),
    ('nguyen_b@gmail.com', 'nguyen_b', 'Nguyễn B', 1, 2, '2021/08/16'),
    ('tran_c@gmail.com', 'tran_c', 'Trần C', 2, 2, '2021/08/15'),
    ('le_d@gmail.com', 'le_d', 'Lê D', 2, 2, '2021/07/15'),
    ('nguyen_e@gmail.com', 'nguyen_e', 'Nguyễn E', 3, 1, '2021/06/16'),
    ('hao_dt@gmail.com', 'do_h', 'Đỗ Thị Hảo', 3, 1, '2021/06/16');
SELECT * FROM `account`;
-- table 4
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group`(
    group_id 	INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    group_name 	VARCHAR(50) CHAR SET UTF8MB4 NOT NULL UNIQUE,
    creator_id 	INT NOT NULL, -- (FK)
    create_date DATE,
    FOREIGN KEY (creator_id) REFERENCES `account`(account_id)
);
-- thêm data vào bảng group
INSERT INTO `group`(group_name, creator_id, create_date)
VALUES
	('group1', 2, '2018/10/18'),
	('group2', 1, '2018/10/17'),
	('group3', 1, '2018/10/16'),
	('group4', 3, '2018/10/15'),
    ('group5', 3, '2018/12/19'),
    ('group6', 1, '2021/10/15'),
    ('group7', 5, '2021/10/16'),
    ('group8', 4, '2021/10/15');
SELECT * FROM `group`;
-- table 5
DROP TABLE IF EXISTS group_account;
CREATE TABLE group_account(
    group_id 	INT NOT NULL, -- QUAN HE NHIEU NHIEU 
	account_id 	INT NOT NULL, -- QUAN HE NHIEU NHIEU 
    join_date 	DATE,
    PRIMARY KEY (group_id, account_id),
    FOREIGN KEY (group_id) REFERENCES `group`(group_id),
    FOREIGN KEY (account_id) REFERENCES `account`(account_id)
);
-- thêm data vào bảng group_account
INSERT INTO group_account(group_id, account_id, join_date)
VALUES
	(1, 2, '2021/10/18'),
    (5, 1, '2021/10/16'),
    (4, 3, '2021/10/15'),
    (2, 4, '2021/10/16'),
    (3, 5, '2021/10/15');
SELECT * FROM group_account;
-- table 6
DROP TABLE IF EXISTS type_question;
CREATE TABLE type_question(
    type_id 	INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    type_name 	ENUM('essay','multiple_choice')
);
-- thêm data vào bảng type_question
INSERT INTO type_question(type_name)
VALUES
	('multiple_choice'),
	('essay'),
	('multiple_choice'),
	('essay'),
	('multiple_choice');
SELECT * FROM type_question;
-- table 7
DROP TABLE IF EXISTS category_question;
CREATE TABLE category_question(
    category_id 	INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    category_name 	VARCHAR(50) CHAR SET UTF8MB4 NOT NULL UNIQUE
);
-- thêm data vào bảng category_question
INSERT INTO category_question(category_name)
VALUES
	('Java'),
	('.Net'),
	('SQL'),
	('Postman'),
	('Ruby');
SELECT * FROM category_question;
-- table 8
DROP TABLE IF EXISTS question;
SET foreign_key_checks = 0;
CREATE TABLE question(
    question_id 	INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    content 		VARCHAR(500) CHAR SET UTF8MB4 NOT NULL,
    category_id 	INT NOT NULL,
    type_id 		INT NOT NULL,
    creator_id 		INT NOT NULL,
    create_date 	DATE,
    FOREIGN KEY (category_id) REFERENCES category_question(category_id),
    FOREIGN KEY (type_id) REFERENCES type_question(type_id),
    FOREIGN KEY (creator_id) REFERENCES `account`(account_id)
);
SET foreign_key_checks = 1;
-- thêm data vào bảng question
INSERT INTO question(content, category_id, type_id, creator_id, create_date)
VALUES
	('câu hỏi 1', 2, 2, 3, '2021/10/18'),
	('câu hỏi 2', 3, 5, 4, '2021/10/18'),
	('câu hỏi 3', 1, 1, 2, '2021/10/18'),
	('câu hỏi 4', 4, 4, 1, '2021/10/18'),
	('câu hỏi 5', 5, 3, 5, '2021/10/18'),
    ('question :)) 5', 5, 3, 5, '2021/10/18');
SELECT * FROM question;
-- table 9
DROP TABLE IF EXISTS answer;
CREATE TABLE answer(
    answer_id 		INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    content 		VARCHAR(1000) CHAR SET UTF8MB4 NOT NULL,
    question_id 	INT NOT NULL,
    is_correct 		BOOLEAN NOT NULL,
    FOREIGN KEY (question_id) REFERENCES question(question_id)
);
-- thêm data vào bảng answer
INSERT INTO answer(content, question_id, is_correct)
VALUES
	('câu trả lời 1', 2, true),
	('câu trả lời 2', 2, true),
	('câu trả lời 3', 2, true),
	('câu trả lời 4', 2, true),
	('câu trả lời 5', 3, false),
	('câu trả lời 6', 1, true),
	('câu trả lời 7', 4, false),
	('câu trả lời 8', 5, true);
SELECT * FROM answer;
-- table 10
DROP TABLE IF EXISTS exam;
SET foreign_key_checks = 0;
CREATE TABLE exam(
    exam_id 		INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `code` 			VARCHAR(50) CHAR SET UTF8MB4 NOT NULL,
    title 			VARCHAR(100) CHAR SET UTF8MB4 NOT NULL,
    category_id 	INT NOT NULL,
    duration 		INT NOT NULL, -- ENUM('15', '30', '45', '60', '75', '90'), 
    creator_id 		INT NOT NULL,
    create_date		DATE,
    FOREIGN KEY (category_id) REFERENCES category_question(category_id),
    FOREIGN KEY (creator_id) REFERENCES `account`(account_id)
);
SET foreign_key_checks = 1;
-- thêm data vào bảng exam
INSERT INTO exam(`code`, title, category_id, duration, creator_id, create_date)
VALUES
	('ABC1', 'title 1', 1, 15, 5, '2021/10/18'),
	('DEF2', 'title 2', 3, 30, 3, '2021/10/18'),
	('ACD3', 'title 3', 4, 90, 4, '2019/12/19'),
	('ACB4', 'title 4', 5, 60, 2, '2021/10/18'),
	('EFD5', 'title 5', 2, 75, 1, '2021/10/18');
SELECT * FROM exam;
-- table 11
DROP TABLE IF EXISTS exam_question;
CREATE TABLE exam_question(
    exam_id 		INT NOT NULL,
    question_id 	INT NOT NULL,
    FOREIGN KEY (exam_id) REFERENCES exam(exam_id),
    FOREIGN KEY (question_id) REFERENCES question(question_id)
);
-- thêm data vào bảng exam
INSERT INTO exam_question(exam_id, question_id)
VALUES
	(1, 1),
	(3, 2),
	(2, 3),
	(5, 4),
	(4, 5);
SELECT * FROM exam_question;
SELECT * FROM exam_question;
-- test trên lớp:
-- USE testing_system;
-- SELECT department.department_name FROM department; 
-- SELECT department_id FROM department
-- WHERE 
-- department_name = 'Sales';
