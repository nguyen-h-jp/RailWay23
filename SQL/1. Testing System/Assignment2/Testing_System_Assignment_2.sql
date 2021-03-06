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
	('Bán hàng'		),
	('Waiting Room'	);
    
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
    
-- table 3

DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`(
    account_id 		INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    email 			VARCHAR(50) UNIQUE  NOT NULL,
    username 		VARCHAR(50) CHAR SET UTF8MB4 UNIQUE  NOT NULL,
    full_name 		VARCHAR(50) CHAR SET UTF8MB4 NOT NULL,
    department_id 	INT, -- (FK)
    position_id 	INT NOT NULL, -- (FK)
    create_date 	DATE,
    FOREIGN KEY (department_id) REFERENCES department(department_id) ON DELETE CASCADE,
    FOREIGN KEY (position_id) REFERENCES `position`(position_id) ON DELETE CASCADE
);

-- thêm data vào bảng account

INSERT INTO `account`(email, username, full_name, department_id, position_id, create_date)
VALUES
	('a@gmail.com', 'a1', 'Trần Văn A', 1, 1, '2021/09/18'),
	('a2@gmail.com', 'a2', 'Trần Văn A2', 1, 2, '2021/09/18'),
    ('b@gmail.com', 'b1', 'Nguyễn Văn B', 1, 1, '2021/08/16'),
    ('c@gmail.com', 'c1', 'Nguyễn Văn C', 1, 1, '2021/08/15'),
    ('d@gmail.com', 'd1', 'Nguyễn Văn D', 2, 2, '2021/07/15'),
    ('e@gmail.com', 'e1', 'Nguyễn Văn E', 2, 2, '2021/06/16'),
    ('f@gmail.com', 'f1', 'Nguyễn Văn F', 2, 2, '2021/06/16'),
    ('g@gmail.com', 'g1', 'Nguyễn Văn G', 3, 3, '2021/06/16'),
    ('h@gmail.com', 'h1', 'Nguyễn Văn H', 3, 3, '2021/06/16'),
    ('i@gmail.com', 'i1', 'Nguyễn Văn I', 3, 3, '2021/06/16'),
    ('k@gmail.com', 'k1', 'Nguyễn Văn K', 3, 3, '2021/06/16'),
    ('admin@gmail.com', 'admin', 'Nguyễn Văn K', 3, 3, '2021/06/16');
    
-- table 4

DROP TABLE IF EXISTS `group`;
CREATE TABLE `group`(
    group_id 	INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    group_name 	VARCHAR(50) CHAR SET UTF8MB4 NOT NULL UNIQUE,
    creator_id 	INT NOT NULL, -- (FK)
    create_date DATE,
    FOREIGN KEY (creator_id) REFERENCES `account`(account_id) ON DELETE CASCADE
);

-- thêm data vào bảng group

INSERT INTO `group`(group_name, creator_id, create_date)
VALUES
	('group1', 2, '2017/10/18'),
	('group2', 1, '2018/10/17'),
	('group3', 1, '2018/10/16'),
	('group4', 3, '2018/10/15'),
    ('group5', 3, '2018/12/19'),
    ('group6', 1, '2021/10/15'),
    ('group7', 5, '2021/10/16'),
    ('group8', 4, '2021/10/15');
    
-- table 5

DROP TABLE IF EXISTS group_account;
CREATE TABLE group_account(
    group_id 	INT NOT NULL, -- QUAN HE NHIEU NHIEU 
	account_id 	INT NOT NULL, -- QUAN HE NHIEU NHIEU 
    join_date 	DATE,
    PRIMARY KEY (group_id, account_id),
    FOREIGN KEY (group_id) REFERENCES `group`(group_id) ON DELETE CASCADE,
    FOREIGN KEY (account_id) REFERENCES `account`(account_id) ON DELETE CASCADE
);

-- thêm data vào bảng group_account

INSERT INTO group_account(group_id, account_id, join_date)
VALUES
	(1, 1, '2021/10/18'),
	(1, 2, '2021/10/18'),
	(1, 3, '2021/10/18'),
	(1, 4, '2021/10/18'),
	(1, 5, '2021/10/18'),
	(1, 6, '2021/10/18'),
    (2, 1, '2021/10/16'),
    (2, 2, '2021/10/16'),
    (2, 3, '2021/10/16'),
    (2, 4, '2021/10/16'),
    (3, 1, '2021/10/15'),
    (3, 3, '2021/10/15'),
    (5, 4, '2021/10/16'),
    (5, 5, '2021/10/16'),
    (6, 1, '2021/10/15'),
    (6, 2, '2021/10/15');
    
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
	('essay');
    
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
	('Ruby'),
	('Javascript'),
	('category free');
    
-- table 8

DROP TABLE IF EXISTS question;
CREATE TABLE question(
    question_id 	INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    content 		VARCHAR(10000) CHAR SET UTF8MB4 NOT NULL,
    category_id 	INT NOT NULL,
    type_id 		INT NOT NULL,
    creator_id 		INT NOT NULL,
    create_date 	DATE,
    FOREIGN KEY (category_id) REFERENCES category_question(category_id) ON DELETE CASCADE,
    FOREIGN KEY (type_id) REFERENCES type_question(type_id) ON DELETE CASCADE,
    FOREIGN KEY (creator_id) REFERENCES `account`(account_id) ON DELETE CASCADE
);

-- thêm data vào bảng question

INSERT INTO question(content, category_id, type_id, creator_id, create_date)
VALUES
	('a a â a a  a a a a a â a a a a a a â a a a a a a a â
    dasdd á á á a s adasdsad asd á adas a s a a a a  a a a a a a a a   a a
    a â a a  a a a a a â a a a a a a â a a a a a a a â
    dasdd á á á a s adasdsad asd á adas a s a a a a  a a a a a a a a   a a 
    a â a a  a a a a a â a a a a a a â a a a a a a a â
    dasdd á á á a s adasdsad asd á adas a s a a a a  a a a a a a a a   a a 
    a â a a  a a a a a â a a a a a a â a a a a a a a â
    dasdd á á á a s adasdsad asd á adas a s a a a a  a a a a a a a a   a a 
    a â a a  a a a a a â a a a a a a â a a a a a a a â
    dasdd á á á a s adasdsad asd á adas a s a a a a  a a a a a a a a   a a a â a a  a a a a a â a a a a a a â a a a a a a a â
    dasdd á á á a s adasdsad asd á adas a s a a a a  a a a a a a a a   a a a â a a  a a a a a â a a a a a a â a a a a a a a â
    dasdd á á á a s adasdsad asd á adas a s a a a a  a a a a a a a a   a a 
    a â a a  a a a a a â a a a a a a â a a a a a a a â
    dasdd á á á a s adasdsad asd á adas a s a a a a  a a a a a a a a   a a 
    a â a a  a a a a a â a a a a a a â a a a a a a a â
    dasdd á á á a s adasdsad asd á adas a s a a a a  a a a a a a a a   a a '			, 1, 1, 1, '2020/10/18'),
	('Java dễ học không'	, 1, 1, 2, '2020/10/18'),
	('.Net là gì a a a a a a a a a a a a a a a a a a a'			, 2, 1, 3, '2020/10/18'),
	('SQL là gì'			, 3, 1, 4, '2021/4/18'),
	('Postman là gì a a a a a a a a a a a a a a a a a a'		, 4, 2, 5, '2021/7/18'),
	('Postman là gì a a a a a a a a a a a a a a a a a a'		, 4, 1, 5, '2021/7/18'),
    ('Ruby là gì'			, 5, 2, 6, '2021/9/18'),
    ('question 1'			, 7, 2, 6, '2021/9/18'),
    ('question 2'			, 7, 2, 6, '2021/9/18'),
    ('question 3'			, 7, 2, 6, '2021/9/18'),
    ('question 4'			, 7, 2, 6, '2021/9/18'),
    ('Ruby có phải là tên mội món ăn không'			, 5, 2, 6, '2021/7/14');
-- table 9

DROP TABLE IF EXISTS answer;
CREATE TABLE answer(
    answer_id 		INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    content 		VARCHAR(1000) CHAR SET UTF8MB4 NOT NULL,
    question_id 	INT NOT NULL,
    is_correct 		BOOLEAN NOT NULL,
    FOREIGN KEY (question_id) REFERENCES question(question_id) ON DELETE CASCADE
);

-- thêm data vào bảng answer

INSERT INTO answer(content, question_id, is_correct)
VALUES
	('Java là ngôn ngữ lập trình', 1, true),
	('Java là một một ngôn ngữ lập trình hiện đại, bậc cao', 1, true),
	('Java không phải là ngôn ngữ lập trình', 1, false),
	('Java là ngôn ngữ khó học', 2, true),
	('Java là ngôn ngữ dễ học', 2, false),
	('Java là ngôn ngữ khó để bắt đầu học', 2, true),
	('.Net là framework do Microsoft phát triển', 3, true),
	('.Net là framework do Facebook phát triển', 3, false),
	('SQL là ngôn ngữ truy vấn dữ liệu', 4, true),
	('SQL là ngôn ngữ giống C++', 4, false),
	('Postman là một công cụ cho phép chúng ta thao tác với API', 5, true),
	('Postman là tên một món ăn', 5, false);
	-- ('Ruby là ngôn ngữ lập trình kịch bản', 6, true),
	-- ('Ruby là một trò trơi', 6, false);
    
-- table 10

DROP TABLE IF EXISTS exam;
CREATE TABLE exam(
    exam_id 		INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `code` 			VARCHAR(50) CHAR SET UTF8MB4 NOT NULL,
    title 			VARCHAR(100) CHAR SET UTF8MB4 NOT NULL,
    category_id 	INT NOT NULL,
    duration 		INT NOT NULL, -- ENUM('15', '30', '45', '60', '75', '90'), 
    creator_id 		INT NOT NULL,
    create_date		DATE,
    FOREIGN KEY (category_id) REFERENCES category_question(category_id) ON DELETE CASCADE,
    FOREIGN KEY (creator_id) REFERENCES `account`(account_id) ON DELETE CASCADE
);

-- thêm data vào bảng exam

INSERT INTO exam(`code`, title, category_id, duration, creator_id, create_date)
VALUES
	('ABC1', 'title 1', 1, 15, 5, '2021/10/18'),
	('DEF2', 'title 2', 1, 15, 5, '2021/10/18'),
	('DEF2', 'title 2', 3, 30, 3, '2021/10/18'),
	('ACD3', 'title 3', 4, 90, 4, '2019/12/19'),
	('ACB4', 'title 4', 5, 60, 2, '2016/10/18'),
	('EFD5', 'title 5', 2, 75, 1, '2017/01/01'),
	('EFD6', 'title 6', 2, 75, 1, '2018/10/30'),
	('EFD7', 'title 7', 2, 75, 1, '2021/11/01');

-- table 11

DROP TABLE IF EXISTS exam_question;
CREATE TABLE exam_question(
    exam_id 		INT NOT NULL,
    question_id 	INT NOT NULL,
    PRIMARY KEY (exam_id, question_id),
    FOREIGN KEY (exam_id) REFERENCES exam(exam_id) ON DELETE CASCADE,
    FOREIGN KEY (question_id) REFERENCES question(question_id) ON DELETE CASCADE
);

INSERT INTO exam_question(exam_id, question_id)
VALUES
	(1, 1),
	(1, 2),
	(1, 3),
	(1, 4),
	(1, 5),
	(1, 6),
	(1, 7),
	(1, 8),
	(1, 9),
	(2, 1),
	(2, 2),
	(2, 4),
	(3, 3),
	(4, 3),
	(5, 1),
	(5, 4),
    (5, 5);
-- hung