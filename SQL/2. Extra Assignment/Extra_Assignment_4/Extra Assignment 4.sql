-- Exercise 1

-- Question 1: tạo table với các ràng buộc và kiểu dữ liệu

DROP DATABASE IF EXISTS nhanvien;
CREATE DATABASE IF NOT EXISTS nhanvien;
USE nhanvien;

ALTER DATABASE nhanvien CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

DROP TABLE IF EXISTS department;
CREATE TABLE department (
    department_number 	INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    department_name 	VARCHAR(30)CHAR SET UTF8MB4 NOT NULL
);

DROP TABLE IF EXISTS employee_table;
CREATE TABLE employee_table (
    employee_number 	INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    employee_name		VARCHAR(30)CHAR SET UTF8MB4 NOT NULL,
    department_number 	INT NOT NULL,
    FOREIGN KEY (department_number)
        REFERENCES department (department_number)
);

DROP TABLE IF EXISTS employee_skill_table;
CREATE TABLE employee_skill_table (
    employee_number INT NOT NULL,
    skill_code 		VARCHAR(50)CHAR SET UTF8MB4 NOT NULL,
    date_registered DATE
);

CREATE TABLE employee_table (
    employee_number 	SMALLINT AUTO_INCREMENT PRIMARY KEY,
    employee_name		VARCHAR(30)CHAR SET UTF8MB4 NOT NULL,
    department_number 	TINYINT NOT NULL,
    FOREIGN KEY (department_number)
        REFERENCES department (department_number)
);

-- Question 2: thêm ít nhất 10 bản ghi vào table department và employee

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

INSERT INTO employee_table(employee_name, department_number)
VALUES
	('leesin', 1	),
	('yasuo', 2		),
	('xinzhao', 3	),
	('zed', 2		),
	('raze', 5		),
	('viper', 3		),
	('sova', 4		),
	('brimstone', 5	),
	('skye', 10		),
	('jett', 9		);    
select
*
from department;
select
*
from employee_table;




