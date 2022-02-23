-- create database
DROP DATABASE IF EXISTS testing_system_assignment_42;
CREATE DATABASE testing_system_assignment_42;
USE testing_system_assignment_42;

-- create table : address
DROP TABLE IF EXISTS address;
CREATE TABLE address(
	address_id 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    address_name 			NVARCHAR(100) NOT NULL UNIQUE KEY
);

-- create table: department
DROP TABLE IF EXISTS department;
CREATE TABLE department(
	department_id 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    department_name 			NVARCHAR(30) NOT NULL UNIQUE KEY
);

-- create table : detail department
DROP TABLE IF EXISTS detail_department;
CREATE TABLE detail_department(
	department_id 			TINYINT UNSIGNED PRIMARY KEY,
    address_id 				TINYINT UNSIGNED, -- UNIQUE KEY,  -- NOT NULL ,
    emulation_point 			TINYINT UNSIGNED,
    FOREIGN KEY(department_id) REFERENCES department(department_id) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY(address_id) REFERENCES address(address_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- create table: Posittion
DROP TABLE IF EXISTS position;
CREATE TABLE `position` (
	position_id				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    position_name			ENUM('Dev','Test','ScrumMaster','PM') NOT NULL UNIQUE KEY
);

-- create table: salary
DROP TABLE IF EXISTS salary;
CREATE TABLE `salary` (
	salary_id			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    salary_name			ENUM('600','700','1500','2000') NOT NULL UNIQUE KEY -- 600: Dev, Test: 700, Scrum Master: 1500, PM: 2000
);

-- create table: account
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`(
	account_id				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    email					VARCHAR(50) NOT NULL UNIQUE KEY, -- Cannot update this field
    username				VARCHAR(50) NOT NULL UNIQUE KEY, -- Cannot update this field
	first_name				NVARCHAR(50) NOT NULL,
    last_name				NVARCHAR(50) NOT NULL,	-- create field fullName in POJO
    department_id 			TINYINT UNSIGNED NOT NULL,	-- Set default waiting
    position_id				TINYINT UNSIGNED NOT NULL,	-- Set default Dev
    salary_id				TINYINT UNSIGNED NOT NULL, -- Set default 600
    create_date				DATETIME DEFAULT NOW(), -- Cannot update this field
    FOREIGN KEY(department_id) REFERENCES department(department_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(position_id) REFERENCES `position`(position_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(salary_id) REFERENCES `salary`(salary_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- create table: employee
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`(
	account_id				TINYINT UNSIGNED PRIMARY KEY,
	working_number_of_year		TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY(account_id) REFERENCES `account` (account_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- create table: manager
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager`(
	account_id					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    management_number_of_year 		TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY(account_id) REFERENCES `account` (account_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- create table: group
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group`(
	group_id				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    group_name				NVARCHAR(50) NOT NULL UNIQUE KEY,
    creator_id				TINYINT UNSIGNED NOT NULL, -- Cannot update this field
    create_date				DATETIME DEFAULT NOW(), -- Cannot update this field
	FOREIGN KEY(creator_id) REFERENCES `account` (account_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- create table: groupaccount
DROP TABLE IF EXISTS group_account;
CREATE TABLE group_account(
	group_id				TINYINT UNSIGNED NOT NULL,
    account_id				TINYINT UNSIGNED NOT NULL,
    join_date				DATETIME DEFAULT NOW(),
    PRIMARY KEY (group_id,account_id),
    FOREIGN KEY(account_id) REFERENCES `account` (account_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(group_id) REFERENCES `group` (group_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- create table: Typequestion
DROP TABLE IF EXISTS type_question;
CREATE TABLE type_question (
    type_id 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    type_name 		ENUM('0','1') NOT NULL UNIQUE KEY -- 0:  Esay, 1: Multiple-Choice
);

-- create table: categoryquestion
DROP TABLE IF EXISTS category_question;
CREATE TABLE category_question(
    category_id				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
    category_name			NVARCHAR(50) NOT NULL UNIQUE KEY
);

-- create table: question
DROP TABLE IF EXISTS question;
CREATE TABLE question(
    question_id				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    content					NVARCHAR(100) NOT NULL,
    category_id				TINYINT UNSIGNED NOT NULL,
    type_id					TINYINT UNSIGNED NOT NULL,
    creator_id				TINYINT UNSIGNED NOT NULL UNIQUE KEY, -- Cannot update this field
    create_date				DATETIME DEFAULT NOW(), -- Cannot update this field
    FOREIGN KEY(category_id) 	REFERENCES category_question(category_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(type_id) 		REFERENCES type_question(type_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(creator_id) 		REFERENCES `account`(account_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- create table: answer
DROP TABLE IF EXISTS answer;
CREATE TABLE answer(
    answer_id					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    content					NVARCHAR(100) NOT NULL,
    question_id				TINYINT UNSIGNED NOT NULL,
    is_correct				BIT DEFAULT 1,
    FOREIGN KEY(question_id) REFERENCES question(question_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- create table: exam
DROP TABLE IF EXISTS exam;
CREATE TABLE exam(
    exam_id					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `code`					CHAR(10) NOT NULL,	-- L-1: if duration >= 180p, M-1: if duration >= 90p, S-1: otherwise -- Cannot update this field
    title					NVARCHAR(50) NOT NULL,
    category_id				TINYINT UNSIGNED NOT NULL,
    duration				TINYINT UNSIGNED NOT NULL DEFAULT 45,
    creator_id				TINYINT UNSIGNED NOT NULL, -- Cannot update this field
    create_date				DATETIME DEFAULT NOW(), -- Cannot update this field
    FOREIGN KEY(category_id) REFERENCES category_question(category_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(creator_id) 	REFERENCES `account`(account_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- create table: examquestion
DROP TABLE IF EXISTS exam_question;
CREATE TABLE exam_question(
    exam_id				TINYINT UNSIGNED NOT NULL,
	question_id			TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY(question_id) REFERENCES question(question_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(exam_id) REFERENCES exam(exam_id) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (exam_id,question_id)
);