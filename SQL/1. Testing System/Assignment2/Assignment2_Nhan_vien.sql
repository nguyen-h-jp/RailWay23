DROP DATABASE IF EXISTS nhanvien;
CREATE DATABASE IF NOT EXISTS nhanvien;
USE nhanvien;

ALTER DATABASE nhanvien CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

DROP TABLE IF EXISTS department;
CREATE TABLE department (
    department_number TINYINT AUTO_INCREMENT PRIMARY KEY,
    department_name VARCHAR(30)CHAR SET UTF8MB4 NOT NULL
);

DROP TABLE IF EXISTS employee_table;
CREATE TABLE employee_table (
    employee_number SMALLINT AUTO_INCREMENT PRIMARY KEY,
    employee_name VARCHAR(30)CHAR SET UTF8MB4 NOT NULL,
    department_number TINYINT NOT NULL,
    FOREIGN KEY (department_number)
        REFERENCES department (department_number)
);
