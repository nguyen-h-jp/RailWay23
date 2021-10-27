USE testing_system;

-- Exercise 1: Tiếp tục với Database Testing System
-- (Sử dụng subquery hoặc CTE)
-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
-- Cách 1: dùng VIEW

DROP VIEW IF EXISTS v_sales_department;

CREATE VIEW v_sales_department AS (
	SELECT a.full_name, d.department_name
    FROM `account` a JOIN department d ON a.department_id = d.department_id
    WHERE d.department_name = 'Sales' 
);

SELECT * FROM v_sales_department;

-- Cách 2: dùng CTE

WITH dsnv_sale AS(
	SELECT a.full_name, d.department_name
    FROM `account` a JOIN department d ON a.department_id = d.department_id
    WHERE d.department_name = 'Sales'
)
SELECT * FROM dsnv_sale;

-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất

-- Cách 1: dùng subquery

SELECT * FROM `account`;
SELECT * FROM group_account;

DROP VIEW IF EXISTS max_in_group;
CREATE VIEW max_in_group AS (
SELECT a.full_name, COUNT(ga.group_id) AS 'Số group tham gia'
FROM `account` a JOIN group_account ga ON a.account_id = ga.account_id
GROUP BY a.account_id
HAVING COUNT(ga.group_id) = (
	SELECT MAX(group_id_count)
		FROM (SELECT count(group_id) AS group_id_count
			FROM group_account
				GROUP BY account_id) AS temp)
);

SELECT * FROM max_in_group;

-- Cách 2: dùng CTE

WITH count_group_by_account_id AS(
		SELECT a.full_name, COUNT(ga.group_id) AS dem_group
		FROM `account` a JOIN group_account ga ON a.account_id = ga.account_id
		GROUP BY a.account_id),
    select_max AS(
		SELECT MAX(dem_group) AS tim_max
		FROM count_group_by_account_id)

SELECT *
FROM count_group_by_account_id
WHERE dem_group = (SELECT tim_max FROM select_max);

-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ
-- được coi là quá dài) và xóa nó đi

SELECT content
FROM question;

DROP VIEW IF EXISTS v_over_300;
CREATE VIEW v_over_300 AS
	SELECT content,  (LENGTH(content) - LENGTH(REPLACE(content, ' ', '')) + 1) AS word_count
    FROM question
    WHERE LENGTH(content) - LENGTH(REPLACE(content, ' ', '')) + 1 > 300;

SELECT *
FROM v_over_300;

DELETE FROM v_over_300;

-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất

-- Cách 1: dùng subquery

DROP VIEW IF EXISTS max_of_department;

CREATE VIEW max_of_department AS (
SELECT d.department_name, count(a.account_id) AS 'Số nhân viên trong phòng'
FROM department d LEFT JOIN `account` a ON d.department_id = a.department_id
GROUP BY d.department_id
HAVING COUNT(a.account_id) = (
	SELECT MAX(dem_nhan_vien)
		FROM (SELECT count(a.account_id) AS dem_nhan_vien
			FROM department d LEFT JOIN `account` a ON d.department_id = a.department_id
				GROUP BY d.department_id) AS temp)); 

SELECT * FROM max_of_department;

-- Cách 2: dùng CTE

WITH number_of_employee_in_departments AS(
		SELECT d.department_name, COUNT(a.account_id) AS employee_count
		FROM `account` a JOIN department d ON a.department_id = d.department_id
		GROUP BY d.department_id),
    select_max AS(
		SELECT MAX(employee_count) AS tim_max
        FROM number_of_employee_in_departments)
	
SELECT *
FROM number_of_employee_in_departments
WHERE employee_count = (SELECT tim_max FROM select_max);

-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo

DROP VIEW IF EXISTS v_question_of_nguyen;

CREATE VIEW v_question_of_nguyen AS
SELECT q.question_id, q.content
FROM question q JOIN `account` a ON q.creator_id = a.account_id
WHERE a.full_name IN (
	SELECT full_name
	FROM `account`
	WHERE full_name LIKE 'Nguyễn%'	
);

SELECT * FROM v_question_of_nguyen;