-- create database
DROP DATABASE IF EXISTS testing_assignment_system_5;
CREATE DATABASE testing_assignment_system_5;
USE testing_assignment_system_5;

ALTER DATABASE testing_assignment_system_5 CHAR SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- create table: Department
DROP TABLE IF EXISTS department;
CREATE TABLE department(
	department_id			int UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    department_name			VARCHAR(30) NOT NULL UNIQUE KEY
);

-- create table: account
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`(
	id						int UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    email					VARCHAR(50) NOT NULL UNIQUE KEY, -- Cannot update this field
    full_name				VARCHAR(50) NOT NULL UNIQUE KEY, -- Cannot update this field
    `password`				VARCHAR(50) NOT NULL,
    `confirm_password`		VARCHAR(50) NOT NULL,
    phone					VARCHAR(50) NOT NULL UNIQUE,
    department_id 			int UNSIGNED NOT NULL,	-- Set default waiting
   
    FOREIGN KEY(department_id) REFERENCES department(department_id) ON DELETE CASCADE ON UPDATE CASCADE
    
);

INSERT INTO `account`( department_id	,email					, full_name	 		, `password`, confirm_password, phone)
VALUES 				(  '8'				,'nguyenvana@gmail.com' , 'nguyen van a' 	, 'nguyenA' , 'nguyenA'         , '08039062410'),
					(  '7'				,'nguyenvanb@gmail.com' , 'nguyen van b' 	, 'nguyenB' , 'nguyenB'         , '08039062411'),
                    (  '6'				,'nguyenvanc@gmail.com' , 'nguyen van c' 	, 'nguyenC' , 'nguyenC'         , '08039062412'),
                    (  '5'				,'nguyenvand@gmail.com' , 'nguyen van d' 	, 'nguyenD' , 'nguyenD'         , '08039062413'),
                    (  '4'				,'nguyenvane@gmail.com' , 'nguyen van e' 	, 'nguyenE' , 'nguyenE'         , '08039062414'),
                    (  '3'				,'nguyenvanf@gmail.com' , 'nguyen van f' 	, 'nguyenF' , 'nguyenF'         , '08039062415'),
                    (  '2'				,'nguyenvang@gmail.com' , 'nguyen van g' 	, 'nguyenG' , 'nguyenG'         , '08039062416'),
                    (  '1'				,'nguyenvanh@gmail.com' , 'nguyen van h' 	, 'nguyenH' , 'nguyenH'         , '08039062417');

/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- Add data Department
INSERT INTO department(department_name) 
VALUES
						('Marketing'	),
						('Sale'		),
						('Bảo vệ'		),
						('Nhân sự'		),
						('Kỹ thuật'	),
						('Tài chính'	),
						('Phó giám đốc'),
						('Giám đốc'	),
						('Thư kí'		),
						('Bán hàng'	);