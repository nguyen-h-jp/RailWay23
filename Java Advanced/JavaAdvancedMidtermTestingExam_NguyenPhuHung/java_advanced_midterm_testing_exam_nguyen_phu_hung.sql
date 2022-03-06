-- create database
DROP DATABASE IF EXISTS java_advanced_midterm_testing_exam_nguyen_phu_hung;
CREATE DATABASE java_advanced_midterm_testing_exam_nguyen_phu_hung;
USE java_advanced_midterm_testing_exam_nguyen_phu_hung;

ALTER DATABASE java_advanced_midterm_tesing_exam_nguyen_phu_hung CHAR SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- create table: device
DROP TABLE IF EXISTS device;
CREATE TABLE device(
	device_id			int UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    device_name			VARCHAR(50) NOT NULL UNIQUE KEY,
    quantity 			int UNSIGNED NOT NULL
);

-- create table: account
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
	user_id						int UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    email					VARCHAR(50) NOT NULL UNIQUE KEY, -- Cannot update this field
    full_name				VARCHAR(50) NOT NULL UNIQUE KEY, -- Cannot update this field
    `password`				VARCHAR(50) NOT NULL,
    phone					VARCHAR(50) NOT NULL UNIQUE
    
);

-- create table: account_device
DROP TABLE IF EXISTS user_device;
CREATE TABLE user_device(
	user_id				int UNSIGNED not null,
    device_id			int UNSIGNED not null,
    register_date 		DATETIME DEFAULT NOW(),
    foreign key (user_id) references `user` (user_id) on delete cascade on update cascade,
    foreign key (device_id) references device (device_id) on delete cascade on update cascade,
    primary key (user_id, device_id)
    
);


                        
						

INSERT INTO `user`( email					, full_name	 		, `password`, phone)
VALUES 				( 'nguyenvana@gmail.com' , 'nguyen van a' 	, 'nguyenA' ,  '08039062410'),
					(  'nguyenvanb@gmail.com' , 'nguyen van b' 	, 'nguyenB' ,  '08039062411'),
                    (  'nguyenvanc@gmail.com' , 'nguyen van c' 	, 'nguyenC' ,  '08039062412'),
                    (  'nguyenvand@gmail.com' , 'nguyen van d' 	, 'nguyenD' ,  '08039062413'),
                    (  'nguyenvane@gmail.com' , 'nguyen van e' 	, 'nguyenE' ,  '08039062414'),
                    (  'nguyenvanf@gmail.com' , 'nguyen van f' 	, 'nguyenF' ,  '08039062415'),
                    (  'nguyenvang@gmail.com' , 'nguyen van g' 	, 'nguyenG' ,  '08039062416'),
                    (  'nguyenvanh@gmail.com' , 'nguyen van h' 	, 'nguyenH' ,  '08039062417');

/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- Add data Department
INSERT INTO device(device_name, quantity) 
VALUES
						('iPhone 13 Pro', 10	),
						('Macbook PRO', 10		),
						('Macbook Air', 10		),
						('Samsung Galaxy Note 10+', 20		),
						('MSI GP66', 10	),
						('Ipad Air', 5	),
						('Ipad Pro', 20),
						('Oppo', 5	),
						('Samsung Galaxy S10+' ,2		),
						('Nokia E72', 10	);
                        
                        
INSERT INTO user_device(user_id, device_id) 
VALUES
						(1,1),
                        (1,2),
                        (1,3),
                        (2,1),
                        (2,2),
                        (2,3),
                        (3,3),
                        (4,3),
                        (5,3);