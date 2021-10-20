-- Assignment 1

DROP DATABASE IF EXISTS fresher_training_management;
CREATE DATABASE fresher_training_management;
use fresher_training_management;
ALTER DATABASE fresher_training_management CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
DROP TABLE IF EXISTS trainee;
CREATE TABLE trainee (
    trainee_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(50)CHAR SET UTF8MB4 NOT NULL,
    birth_date DATE NOT NULL,
    gender ENUM('male', 'female', 'unknown'),
    et_iq INT CHECK (0 <= ET_IQ AND ET_IQ <= 20),
    et_gmath INT CHECK (0 <= ET_Gmath AND ET_Gmath <= 20),
    et_english INT CHECK (0 <= ET_English AND ET_English <= 20),
    training_class VARCHAR(50)CHAR SET UTF8MB4 NOT NULL,
    evalution_notes VARCHAR(500)CHAR SET UTF8MB4 NOT NULL
);

-- Assignment 2

ALTER TABLE trainee ADD vti_account VARCHAR(50) CHAR SET utf8mb4 NOT NULL UNIQUE;
SELECT 
    *
FROM
    trainee;

-- Assignment 3

-- Question 1: thêm 10 bản ghi vào bảng đã tạo

USE fresher_training_management;
SELECT 
    *
FROM
    trainee;
 
INSERT INTO trainee(full_name, birth_date, gender, et_iq, et_gmath, et_english, training_class, evalution_notes, vti_account)
VALUES
	('zed', '1990/01/01', 'male', 20, 20, 20, 'LOL1', '特になし', 'zed_vti'),
	('leesin', '1991/01/01', 'male', 1, 11, 19, 'LOL1', '特になし', 'leesin_vti'),
	('yasuo', '1992/01/01', 'male', 18, 7, 18, 'LOL1', '特になし', 'yasuo_vti'),
	('xinzhao', '1993/01/01', 'male', 8, 8, 8, 'LOL1', '特になし', 'xinzhao_vti'),
	('raze', '1994/01/01', 'female', 7, 7, 19, 'VAL1', '特になし', 'raze_vti'),
	('viper', '1995/01/01', 'female', 18, 18, 18, 'VAL1', '特になし', 'viper_vti'),
	('jett', '1996/01/01', 'female', 18, 18, 18, 'VAL1', '特になし', 'jett_vti'),
	('brimstone', '1997/01/01', 'male', 18, 18, 18, 'VAL1', '特になし', 'brimstone_vti'),
	('sova', '1998/01/01', 'male', 18, 18, 18, 'VAL1', '特になし', 'sova_vti'),
	('breach', '1999/01/01', 'male', 18, 18, 18, 'VAL1', '特になし', 'breach_vti');
    
-- Question 2: viết lệnh để lấy ra tất cả các thực tập sinh đã vượt qua bài test đầu vào, nhóm chúng thành các tháng sinh khác nhau

SELECT 
    *
FROM
    trainee;

SELECT 
    *
FROM
    trainee
WHERE
    (et_iq + et_gmath >= 20)
        AND (et_iq >= 8)
        AND (et_gmath >= 8)
        AND (et_english >= 18)
GROUP BY birth_date;

-- Question 3: viết lệnh để lấy ra thực tập sinh có tên dài nhất, lấy ra các thông tin sau: tên, tuổi, các thông tin cơ bản (như đã định nghĩa trong các table)

SELECT 
    *
FROM
    trainee;

SELECT 
    *
FROM
    trainee
WHERE
    LENGTH(full_name) = (SELECT 
            MAX(LENGTH(full_name))
        FROM
            trainee);
            
-- Question 4: (giống Question 2 ???)

-- Question 5: xóa thông tin của thực tập sinh có trainee_id = 3

SELECT 
    *
FROM
    trainee;

DELETE FROM trainee 
WHERE
    trainee_id = 3;
    
-- Question 6: thực tập sinh có trainee_id được chuyển sang lớp 2

SELECT 
    *
FROM
    trainee;
    
UPDATE trainee 
SET 
    training_class = 2
WHERE
    trainee_id = 5; 

