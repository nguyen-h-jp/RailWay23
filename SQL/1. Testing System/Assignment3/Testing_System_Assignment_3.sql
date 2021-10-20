-- 1. thêm ít nhất 10 record vào mỗi bảng(đã thêm ở bài 2)

-- 2. lấy ra tất cả phòng ban 

USE testing_system;
SELECT department_name
FROM department;

-- 3. lấy ra id của phòng ban 'Sales'

SELECT 
    department_id
FROM
    department
WHERE
    department_name = 'Sales'; 
    
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
        
-- 6. Lấy ra tên group đã tham gia trước ngày 20/12/2019 (đổi duration sang int)

SELECT `group_name`, create_date
FROM `group`
WHERE create_date < '2019/12/20';

-- 7. lấy ra id của question có >= 4 câu trả lời

SELECT 
    *
FROM
    answer;
SELECT 
    question_id,
    COUNT(question_id) AS 'số lượng câu trả lời',
    answer_id
FROM
    answer
GROUP BY question_id
HAVING COUNT(question_id) >= 4;

-- 8. lấy ra các mã đề thi có thời gian thi >= 60 phút và được tạo trước ngày 20/12/2019

SELECT * FROM exam;
SELECT
	`code`,
    create_date
FROM
	exam
WHERE duration >= 60 AND create_date < '2019/12/20';

-- 9. lấy ra 5 group được tạo gần nhất

SELECT 
    *
FROM
    `group`
ORDER BY create_date DESC
LIMIT 5;

-- 10. đếm số nhân viên thuộc department có id = 2

SELECT 
    *
FROM
    `account`;
SELECT 
    COUNT(department_id) AS 'số nhân viên thuộc department_id = 2'
FROM
    `account`
WHERE
    department_id = 2;
    
-- 11. lấy ra số nhân viên có tên bắt đầu bằng chữ "D" và kết thúc bằng chữ "o"

SELECT 
    *
FROM
    `account`
WHERE
    full_name LIKE 'D%o';
    
-- 12. xóa tất cả các exam được tạo trước ngày 20/12/2019

SELECT 
    *
FROM
    exam;
SET foreign_key_checks = 0;
DELETE FROM exam 
WHERE
    create_date < '2019/12/20';
SET foreign_key_checks = 1;

-- 13. xóa tất cả các question có nội dung bắt đầu bằng từ "câu hỏi"

SELECT 
    *
FROM
    question;
SET foreign_key_checks = 0;
delete
from question
where content LIKE 'câu hỏi%';
SET foreign_key_checks = 1;

-- 14. update thông tin của account_id = 5 thành tên "Nguyễn Bá Lộc" và email thành loc.nguyenba@vti.com.vn

SELECT 
    *
FROM
    `account`;

UPDATE `account` 
SET 
    full_name = 'Nguyễn Bá Lộc',
    email = 'loc.nguyenba@vti.com.vn'
WHERE
    account_id = 5;
    
-- 15. update account_id = 5 sẽ thuộc group_id = 4;

SELECT 
    *
FROM
    `group_account`;
UPDATE `group_account` 
SET 
    group_id = 4
WHERE
    account_id = 5;


