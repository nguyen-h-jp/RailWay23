-- Exercise 1
-- Question 1: tạo table với các ràng buộc và kiểu dữ liệu

DROP DATABASE IF EXISTS nhanvien;
CREATE DATABASE IF NOT EXISTS nhanvien;
USE nhanvien;

ALTER DATABASE nhanvien CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

DROP TABLE IF EXISTS department;
CREATE TABLE department(
    department_number 	INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    department_name 	VARCHAR(30)CHAR SET UTF8MB4 NOT NULL
);

DROP TABLE IF EXISTS employee_table;
CREATE TABLE employee_table(
    employee_number 	INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    employee_name		VARCHAR(30)CHAR SET UTF8MB4 NOT NULL,
    department_number 	INT NOT NULL, -- FK
    FOREIGN KEY (department_number) REFERENCES department (department_number) ON DELETE CASCADE
);

DROP TABLE IF EXISTS employee_skill_table;
CREATE TABLE employee_skill_table(
    employee_number INT NOT NULL,
    skill_code 		VARCHAR(50)CHAR SET UTF8MB4 NOT NULL,
    date_registered DATE,
    FOREIGN KEY (employee_number) REFERENCES employee_table (employee_number) ON DELETE CASCADE
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
	('Nguyễn Văn A'	, 1	),
	('Nguyễn Văn B'	, 1	),
	('Nguyễn Văn C'	, 1	),
	('Trần Thị A'	, 1	),
	('Trần Thị B'	, 1	),
	('Trần Thị C'	, 3	),
	('Đỗ Văn A'		, 4	),
	('Đỗ Văn B'		, 5	),
	('Đỗ Văn C'		, 10),
	('Bùi Thị A'	, 9	);    

INSERT INTO employee_skill_table(employee_number, skill_code, date_registered)
VALUES
	(1	, 'Java'		, '2017/11/11'),
	(1	, 'Javascript'	, '2018/12/11'),
	(1	, 'C#'			, '2020/11/11'),
	(4	, 'Python'		, '2019/11/11'),
	(5	, 'C++'			, '2019/11/11'),
	(6	, 'C'			, '2018/11/11'),
	(7	, 'Ruby'		, '2019/11/11'),
	(8	, '.Net'		, '2020/11/11'),
	(9	, 'C++'			, '2020/11/11'),
	(10	, 'Java'		, '2020/11/11');    

-- Question 3: Viết lệnh để lấy ra danh sách nhân viên (name) có skill Java

SHOW TABLES;
SELECT *
FROM employee_table;
SELECT *
FROM employee_skill_table;

SELECT *
FROM employee_table et JOIN employee_skill_table est ON et.employee_number = est.employee_number
GROUP BY et.employee_number
HAVING est.skill_code = 'Java';

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên

SELECT *
FROM department;

SELECT d.department_name, COUNT(et.employee_number)
FROM department d LEFT JOIN employee_table et ON d.department_number = et.department_number
GROUP BY d.department_number
HAVING COUNT(et.employee_number) > 3;

-- Question 5: Viết lệnh để lấy ra danh sách nhân viên của mỗi văn phòng ban. 

SELECT d.department_name, COUNT(et.employee_number)
FROM department d LEFT JOIN employee_table et ON d.department_number = et.department_number
GROUP BY d.department_number;

-- Question 6: Viết lệnh để lấy ra danh sách nhân viên có > 1 skills.

SELECT et.employee_name, COUNT(est.skill_code)
FROM employee_table et LEFT JOIN employee_skill_table est ON et.employee_number = est.employee_number
GROUP BY et.employee_number
HAVING COUNT(est.skill_code) > 1;

