-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: testing_system_assignment_3
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `account_id` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `first_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `last_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `department_id` tinyint unsigned NOT NULL,
  `position_id` tinyint unsigned NOT NULL,
  `salary_id` tinyint unsigned NOT NULL,
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`account_id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `username` (`username`),
  KEY `department_id` (`department_id`),
  KEY `position_id` (`position_id`),
  KEY `salary_id` (`salary_id`),
  CONSTRAINT `account_ibfk_1` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`),
  CONSTRAINT `account_ibfk_2` FOREIGN KEY (`position_id`) REFERENCES `position` (`position_id`),
  CONSTRAINT `account_ibfk_3` FOREIGN KEY (`salary_id`) REFERENCES `salary` (`salary_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'haidang29productions@gmail.com','dangblack','Dang','Nguyen Hai',5,1,1,'2020-03-05 00:00:00'),(2,'account1@gmail.com','quanganh','Anh','Tong Quang',1,2,2,'2020-03-05 00:00:00'),(3,'account2@gmail.com','vanchien','Chien','Nguyen Van',2,3,3,'2020-03-07 00:00:00'),(4,'account3@gmail.com','cocoduongqua','Do','Duong',3,3,3,'2020-03-08 00:00:00'),(5,'account4@gmail.com','doccocaubai','Thang','Nguyen Chien',4,3,3,'2020-03-10 00:00:00'),(6,'dapphatchetngay@gmail.com','khabanh','Kha','Ngo Ba',6,3,3,'2022-02-19 21:50:25'),(7,'songcodaoly@gmail.com','huanhoahong','Huan','Bui Xuan',7,2,2,'2022-02-19 21:50:25'),(8,'sontungmtp@gmail.com','tungnui','Tung','Nguyen Thanh',8,1,1,'2020-04-07 00:00:00'),(9,'duongghuu@gmail.com','duongghuu','Huu','Duong Van',9,2,2,'2020-04-07 00:00:00'),(10,'vtiaccademy@gmail.com','vtiaccademy','Ai','Vi Ti',10,1,1,'2020-04-09 00:00:00'),(11,'test','sadas','dasd','dsad',5,1,1,'2022-02-21 20:25:13');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `address_id` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `address_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`address_id`),
  UNIQUE KEY `address_name` (`address_name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (6,'P401'),(7,'P402'),(8,'P403'),(9,'P404'),(10,'P405'),(1,'P501'),(2,'P502'),(3,'P503'),(4,'P504'),(5,'P505');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `answer` (
  `answer_id` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `content` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `question_id` tinyint unsigned NOT NULL,
  `is_correct` bit(1) DEFAULT b'1',
  PRIMARY KEY (`answer_id`),
  KEY `question_id` (`question_id`),
  CONSTRAINT `answer_ibfk_1` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` VALUES (1,'Trả lời 01',1,_binary '\0'),(2,'Trả lời 02',1,_binary ''),(3,'Trả lời 03',1,_binary '\0'),(4,'Trả lời 04',1,_binary ''),(5,'Trả lời 05',2,_binary ''),(6,'Trả lời 06',3,_binary ''),(7,'Trả lời 07',4,_binary '\0'),(8,'Trả lời 08',8,_binary '\0'),(9,'Trả lời 09',9,_binary ''),(10,'Trả lời 10',10,_binary '');
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_question`
--

DROP TABLE IF EXISTS `category_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category_question` (
  `category_id` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `category_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`category_id`),
  UNIQUE KEY `category_name` (`category_name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_question`
--

LOCK TABLES `category_question` WRITE;
/*!40000 ALTER TABLE `category_question` DISABLE KEYS */;
INSERT INTO `category_question` VALUES (3,'ADO.NET'),(2,'ASP.NET'),(9,'C Sharp'),(8,'C++'),(1,'Java'),(10,'PHP'),(5,'Postman'),(7,'Python'),(6,'Ruby'),(4,'SQL');
/*!40000 ALTER TABLE `category_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `department_id` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `department_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`department_id`),
  UNIQUE KEY `department_name` (`department_name`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (11,'ABC'),(10,'Bán hàng'),(3,'Bảo vệ'),(8,'Giám đốc'),(5,'Kỹ thuật'),(1,'Marketing'),(4,'Nhân sự'),(7,'Phó giám đốc'),(2,'Sale'),(6,'Tài chính'),(9,'Thư kí');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detail_department`
--

DROP TABLE IF EXISTS `detail_department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detail_department` (
  `department_id` tinyint unsigned NOT NULL,
  `address_id` tinyint unsigned DEFAULT NULL,
  `emulation_point` tinyint unsigned DEFAULT NULL,
  PRIMARY KEY (`department_id`),
  KEY `address_id` (`address_id`),
  CONSTRAINT `detail_department_ibfk_1` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`),
  CONSTRAINT `detail_department_ibfk_2` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detail_department`
--

LOCK TABLES `detail_department` WRITE;
/*!40000 ALTER TABLE `detail_department` DISABLE KEYS */;
INSERT INTO `detail_department` VALUES (1,1,1),(2,2,4),(3,3,6),(4,4,7),(5,5,2),(6,6,1),(7,7,5),(8,8,6),(9,9,8),(10,10,9);
/*!40000 ALTER TABLE `detail_department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `account_id` tinyint unsigned NOT NULL,
  `working_number_of_year` tinyint unsigned NOT NULL,
  PRIMARY KEY (`account_id`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,1),(2,2),(3,1),(4,3),(5,4),(6,2),(7,3),(8,1),(9,5),(10,6);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam`
--

DROP TABLE IF EXISTS `exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exam` (
  `exam_id` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `code` char(10) NOT NULL,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `category_id` tinyint unsigned NOT NULL,
  `duration` tinyint unsigned NOT NULL DEFAULT '45',
  `creator_id` tinyint unsigned NOT NULL,
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`exam_id`),
  KEY `category_id` (`category_id`),
  KEY `creator_id` (`creator_id`),
  CONSTRAINT `exam_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category_question` (`category_id`),
  CONSTRAINT `exam_ibfk_2` FOREIGN KEY (`creator_id`) REFERENCES `account` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam`
--

LOCK TABLES `exam` WRITE;
/*!40000 ALTER TABLE `exam` DISABLE KEYS */;
INSERT INTO `exam` VALUES (1,'S-1','Đề thi C#',1,60,5,'2019-04-05 00:00:00'),(2,'S-2','Đề thi PHP',10,60,1,'2019-04-05 00:00:00'),(3,'M-1','Đề thi C++',9,120,2,'2019-04-07 00:00:00'),(4,'S-3','Đề thi Java',6,60,3,'2020-04-08 00:00:00'),(5,'M-2','Đề thi Ruby',5,120,4,'2020-04-10 00:00:00'),(6,'S-4','Đề thi Postman',3,60,6,'2020-04-05 00:00:00'),(7,'S-5','Đề thi SQL',2,60,7,'2020-04-05 00:00:00'),(8,'S-6','Đề thi Python',8,60,8,'2020-04-07 00:00:00'),(9,'L-1','Đề thi ADO.NET',4,180,9,'2020-04-07 00:00:00'),(10,'L-2','Đề thi ASP.NET',7,180,10,'2020-04-08 00:00:00');
/*!40000 ALTER TABLE `exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam_question`
--

DROP TABLE IF EXISTS `exam_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exam_question` (
  `exam_id` tinyint unsigned NOT NULL,
  `question_id` tinyint unsigned NOT NULL,
  PRIMARY KEY (`exam_id`,`question_id`),
  KEY `question_id` (`question_id`),
  CONSTRAINT `exam_question_ibfk_1` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`),
  CONSTRAINT `exam_question_ibfk_2` FOREIGN KEY (`exam_id`) REFERENCES `exam` (`exam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam_question`
--

LOCK TABLES `exam_question` WRITE;
/*!40000 ALTER TABLE `exam_question` DISABLE KEYS */;
INSERT INTO `exam_question` VALUES (7,2),(4,3),(3,4),(1,5),(5,7),(10,8),(9,9),(2,10),(6,10),(8,10);
/*!40000 ALTER TABLE `exam_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group`
--

DROP TABLE IF EXISTS `group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `group` (
  `group_id` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `group_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `creator_id` tinyint unsigned NOT NULL,
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`group_id`),
  UNIQUE KEY `group_name` (`group_name`),
  KEY `creator_id` (`creator_id`),
  CONSTRAINT `group_ibfk_1` FOREIGN KEY (`creator_id`) REFERENCES `account` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group`
--

LOCK TABLES `group` WRITE;
/*!40000 ALTER TABLE `group` DISABLE KEYS */;
INSERT INTO `group` VALUES (1,'Testing System',5,'2019-03-05 00:00:00'),(2,'Developement',1,'2020-03-07 00:00:00'),(3,'VTI Sale 01',2,'2020-03-09 00:00:00'),(4,'VTI Sale 02',3,'2020-03-10 00:00:00'),(5,'VTI Sale 03',4,'2020-03-28 00:00:00'),(6,'VTI Creator',6,'2020-04-06 00:00:00'),(7,'VTI Marketing 01',7,'2020-04-07 00:00:00'),(8,'Management',8,'2020-04-08 00:00:00'),(9,'Chat with love',9,'2020-04-09 00:00:00'),(10,'Vi Ti Ai',10,'2020-04-10 00:00:00');
/*!40000 ALTER TABLE `group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_account`
--

DROP TABLE IF EXISTS `group_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `group_account` (
  `group_id` tinyint unsigned NOT NULL,
  `account_id` tinyint unsigned NOT NULL,
  `join_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`group_id`,`account_id`),
  KEY `account_id` (`account_id`),
  CONSTRAINT `group_account_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`),
  CONSTRAINT `group_account_ibfk_2` FOREIGN KEY (`group_id`) REFERENCES `group` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_account`
--

LOCK TABLES `group_account` WRITE;
/*!40000 ALTER TABLE `group_account` DISABLE KEYS */;
INSERT INTO `group_account` VALUES (1,1,'2019-03-05 00:00:00'),(1,2,'2020-03-07 00:00:00'),(1,3,'2020-04-06 00:00:00'),(1,7,'2020-04-07 00:00:00'),(1,9,'2020-04-09 00:00:00'),(3,3,'2020-03-09 00:00:00'),(3,4,'2020-03-10 00:00:00'),(5,5,'2020-03-28 00:00:00'),(8,3,'2020-04-08 00:00:00'),(10,10,'2020-04-10 00:00:00');
/*!40000 ALTER TABLE `group_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manager` (
  `account_id` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `management_number_of_year` tinyint unsigned NOT NULL,
  PRIMARY KEY (`account_id`),
  CONSTRAINT `manager_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES (1,1),(2,2),(3,1),(4,3),(5,4),(6,2),(7,3),(8,1),(9,5),(10,6);
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `position` (
  `position_id` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `position_name` enum('Dev','Test','ScrumMaster','PM') NOT NULL,
  PRIMARY KEY (`position_id`),
  UNIQUE KEY `position_name` (`position_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES (1,'Dev'),(2,'Test'),(3,'ScrumMaster');
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `question_id` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `content` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `category_id` tinyint unsigned NOT NULL,
  `type_id` tinyint unsigned NOT NULL,
  `creator_id` tinyint unsigned NOT NULL,
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`question_id`),
  UNIQUE KEY `creator_id` (`creator_id`),
  KEY `category_id` (`category_id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `question_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category_question` (`category_id`),
  CONSTRAINT `question_ibfk_2` FOREIGN KEY (`type_id`) REFERENCES `type_question` (`type_id`),
  CONSTRAINT `question_ibfk_3` FOREIGN KEY (`creator_id`) REFERENCES `account` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'Câu hỏi về Java',1,1,1,'2020-04-05 00:00:00'),(2,'Câu Hỏi về PHP',10,2,2,'2020-04-05 00:00:00'),(3,'Hỏi về C#',9,2,3,'2020-04-06 00:00:00'),(4,'Hỏi về Ruby',6,1,4,'2020-04-06 00:00:00'),(5,'Hỏi về Postman',5,1,5,'2020-04-06 00:00:00'),(6,'Hỏi về ADO.NET',3,2,6,'2020-04-06 00:00:00'),(7,'Hỏi về ASP.NET',2,1,7,'2020-04-06 00:00:00'),(8,'Hỏi về C++',8,1,8,'2020-04-07 00:00:00'),(9,'Hỏi về SQL',4,2,9,'2020-04-07 00:00:00'),(10,'Hỏi về Python',7,1,10,'2020-04-07 00:00:00');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary`
--

DROP TABLE IF EXISTS `salary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salary` (
  `salary_id` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `salary_name` enum('600','700','1500','2000') NOT NULL,
  PRIMARY KEY (`salary_id`),
  UNIQUE KEY `salary_name` (`salary_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary`
--

LOCK TABLES `salary` WRITE;
/*!40000 ALTER TABLE `salary` DISABLE KEYS */;
INSERT INTO `salary` VALUES (1,'600'),(2,'700'),(3,'1500');
/*!40000 ALTER TABLE `salary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type_question`
--

DROP TABLE IF EXISTS `type_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type_question` (
  `type_id` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `type_name` enum('0','1') NOT NULL,
  PRIMARY KEY (`type_id`),
  UNIQUE KEY `type_name` (`type_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_question`
--

LOCK TABLES `type_question` WRITE;
/*!40000 ALTER TABLE `type_question` DISABLE KEYS */;
INSERT INTO `type_question` VALUES (1,'0'),(2,'1');
/*!40000 ALTER TABLE `type_question` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-21 23:45:14
