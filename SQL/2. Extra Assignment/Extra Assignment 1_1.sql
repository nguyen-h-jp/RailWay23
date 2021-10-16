-- Exercise 1
CREATE DATABASE fresher_training_management;
use fresher_training_management;
CREATE TABLE trainee (
    TraineeID 		INT NOT NULL AUTO_INCREMENT,
    Full_Name 		VARCHAR(50),
    Birth_Date 		DATE,
    Gender 			ENUM('male', 'female', 'unknown'),
    ET_IQ 			INT CHECK(0 <= ET_IQ AND ET_IQ <= 20),
    ET_Gmath 		INT CHECK(0 <= ET_Gmath AND ET_Gmath <= 20),
    ET_English 		INT CHECK(0 <= ET_English AND ET_English <= 20),
    Training_Class 	VARCHAR(50),
    Evalution_Notes VARCHAR(500),
    UNIQUE KEY(TraineeID)
);

ALTER TABLE trainee ADD VTI_Acount VARCHAR(50) NOT NULL UNIQUE;
