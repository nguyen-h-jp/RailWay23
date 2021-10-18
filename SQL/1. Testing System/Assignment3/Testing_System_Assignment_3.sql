-- 1. thêm ít nhất 10 record vào mỗi bảng(đã thêm ở bài 2)
-- 2. lấy ra tất cả phòng ban 
USE testing_system;
SELECT department_name
FROM department;
-- 3. lấy ra id của phòng ban 'Sales'
SELECT department_id
FROM department
WHERE department_name = 'Sales'; 
-- 4. lấy ra thông tin account có full_name dài nhất
SELECT 
    `account`.*
FROM
    `account`
WHERE
    LENGTH(full_name) = (SELECT 
            MAX(LENGTH(full_name))
        FROM
            `account`);
-- 5. lấy ra thông tin account có full_name dài nhất và có id phòng ban là 3
SELECT 
    `account`.*
FROM
    `account`
WHERE
    LENGTH(full_name) = (SELECT 
            MAX(LENGTH(full_name))
        FROM
            `account`)
		AND department_id = 3;