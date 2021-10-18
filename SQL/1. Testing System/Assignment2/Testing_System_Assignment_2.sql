DROP DATABASE IF EXISTS testing_system;
CREATE DATABASE testing_system;
USE testing_system;
ALTER DATABASE testing_system CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
-- table 1
DROP TABLE IF EXISTS department; 
CREATE TABLE department(
    department_id 	INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    department_name VARCHAR(50) CHAR SET UTF8MB4 NOT NULL
);
INSERT INTO department(department_id, department_name)
VALUES
	(1, 	'Marketing'		),
	(2, 	'Sales'			),
	(3, 	'Bảo vệ'		),
	(4, 	'Nhân sự'		),
	(5, 	'Kỹ thuật'		),
	(6, 	'Tài chính'		),
	(7, 	'Phó giám đốc'	),
	(8, 	'Giám đốc'		),
	(9, 	'Thư kí'		),
	(10, 	'Bán hàng'		);
SELECT * FROM department;
-- table 2 
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position`(
    position_id 	INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    position_name 	ENUM('Dev','Test','Scrum Master','PM') 
);
-- table 3
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`(
    account_id 		INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    account_name	VARCHAR(50) CHAR SET UTF8MB4 UNIQUE  NOT NULL,
    username 		VARCHAR(50) CHAR SET UTF8MB4 UNIQUE  NOT NULL,
    full_name 		VARCHAR(50) CHAR SET UTF8MB4 NOT NULL,
    department_id 	INT NOT NULL, -- (FK)
    position_id 	INT NOT NULL, -- (FK)
    create_date 	DATE,
    FOREIGN KEY (department_id) REFERENCES department(department_id),
    FOREIGN KEY (position_id) REFERENCES `position`(position_id)
);
-- table 4
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group`(
    group_id 	INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    group_name 	VARCHAR(50) CHAR SET UTF8MB4,
    creator_id 	INT NOT NULL, -- (FK)
    create_date DATE,
    FOREIGN KEY (creator_id) REFERENCES `account`(account_id)
);
-- table 5
DROP TABLE IF EXISTS group_account;
CREATE TABLE group_account(
    group_id 	INT NOT NULL PRIMARY KEY,
	account_id 	INT NOT NULL UNIQUE,
    join_date 	DATE,
    FOREIGN KEY (account_id) REFERENCES `account`(account_id)
);
-- table 6
DROP TABLE IF EXISTS type_question;
CREATE TABLE type_question(
    type_id 	INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    type_name 	ENUM('essay','multiple_choice')
);
-- table 7
DROP TABLE IF EXISTS category_question;
CREATE TABLE category_question(
    category_id 	INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    category_name 	VARCHAR(50) CHAR SET UTF8MB4 NOT NULL
);
-- table 8
DROP TABLE IF EXISTS question;
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
-- table 9
DROP TABLE IF EXISTS answer;
CREATE TABLE answer(
    answer_id 		INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    content 		VARCHAR(1000) CHAR SET UTF8MB4 NOT NULL,
    question_id 	INT NOT NULL,
    is_correct 		BOOLEAN NOT NULL,
    FOREIGN KEY (question_id) REFERENCES question(question_id)
);
-- table 10
DROP TABLE IF EXISTS exam;
CREATE TABLE exam(
    exam_id 		INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `code` 			VARCHAR(50) CHAR SET UTF8MB4 NOT NULL,
    title 			VARCHAR(100) CHAR SET UTF8MB4 NOT NULL,
    category_id 	INT NOT NULL,
    duration 		INT NOT NULL, 
    creator_id 		INT NOT NULL,
    create_date		DATE,
    FOREIGN KEY (category_id) REFERENCES category_question(category_id),
    FOREIGN KEY (creator_id) REFERENCES `account`(account_id)
);
-- table 11
DROP TABLE IF EXISTS exam_question;
CREATE TABLE exam_question(
    exam_id 		INT NOT NULL,
    question_id 	INT NOT NULL,
    FOREIGN KEY (exam_id) REFERENCES exam(exam_id),
    FOREIGN KEY (question_id) REFERENCES question(question_id)
);
-- test trên lớp:
-- USE testing_system;
-- SELECT department.department_name FROM department; 
-- SELECT department_id FROM department
-- WHERE 
-- department_name = 'Sales';
