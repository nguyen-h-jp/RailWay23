-- Exercise 1
DROP DATABASE IF EXISTS fresher_training_management;
CREATE DATABASE fresher_training_management;
use fresher_training_management;
ALTER DATABASE testing_system CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE TABLE trainee (
    trainee_id 		INT NOT NULL AUTO_INCREMENT UNIQUE,
    full_name		VARCHAR(50) CHAR SET utf8mb4 NOT NULL,
    birth_date 		DATE NOT NULL,
    gender 			ENUM('male', 'female', 'unknown'),
    et_iq 			INT CHECK(0 <= ET_IQ AND ET_IQ <= 20),
    et_gmath 		INT CHECK(0 <= ET_Gmath AND ET_Gmath <= 20),
    et_english 		INT CHECK(0 <= ET_English AND ET_English <= 20),
    training_class 	VARCHAR(50) CHAR SET utf8mb4 NOT NULL,
    evalution_notes VARCHAR(500) CHAR SET utf8mb4 NOT NULL
);

ALTER TABLE trainee ADD vti_account VARCHAR(50) CHAR SET utf8mb4 NOT NULL UNIQUE;
