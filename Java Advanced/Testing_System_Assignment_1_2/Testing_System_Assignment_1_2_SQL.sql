-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: testing_system_assignment_1
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
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`account_id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'haidang29productions@gmail.com','dangblack','Dang','Nguyen Hai','2020-03-05 00:00:00'),(2,'account1@gmail.com','quanganh','Anh','Tong Quang','2020-03-05 00:00:00'),(3,'account2@gmail.com','vanchien','Chien','Nguyen Van','2020-03-07 00:00:00'),(4,'account3@gmail.com','cocoduongqua','Do','Duong','2020-03-08 00:00:00'),(5,'account4@gmail.com','doccocaubai','Thang','Nguyen Chien','2020-03-10 00:00:00'),(6,'dapphatchetngay@gmail.com','khabanh','Kha','Ngo Ba','2022-02-15 20:16:35'),(7,'songcodaoly@gmail.com','huanhoahong','Huan','Bui Xuan','2022-02-15 20:16:35'),(8,'sontungmtp@gmail.com','tungnui','Tung','Nguyen Thanh','2020-04-07 00:00:00'),(9,'duongghuu@gmail.com','duongghuu','Huu','Duong Van','2020-04-07 00:00:00'),(10,'vtiaccademy@gmail.com','vtiaccademy','Ai','Vi Ti','2020-04-09 00:00:00');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
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
  `is_correct` bit(1) DEFAULT b'1',
  PRIMARY KEY (`answer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` VALUES (1,'Trả lời 01',_binary '\0'),(2,'Trả lời 02',_binary ''),(3,'Trả lời 03',_binary '\0'),(4,'Trả lời 04',_binary ''),(5,'Trả lời 05',_binary ''),(6,'Trả lời 06',_binary ''),(7,'Trả lời 07',_binary '\0'),(8,'Trả lời 08',_binary '\0'),(9,'Trả lời 09',_binary ''),(10,'Trả lời 10',_binary ''),(12,'Trả lời x',_binary '\0'),(13,'Trả lời x3',_binary '');
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_question`
--

LOCK TABLES `category_question` WRITE;
/*!40000 ALTER TABLE `category_question` DISABLE KEYS */;
INSERT INTO `category_question` VALUES (3,'ADO.NET'),(2,'ASP.NET'),(9,'C Sharp'),(8,'C++'),(11,'Janpanese'),(1,'Java'),(10,'PHP'),(5,'Postman'),(7,'Python'),(6,'Ruby'),(4,'SQL');
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
INSERT INTO `department` VALUES (10,'Bán hàng'),(3,'Bảo vệ'),(8,'Giám đốc'),(5,'Kỹ thuật'),(1,'Marketing'),(4,'Nhân sự'),(7,'Phó giám đốc'),(11,'Phong chờ'),(2,'Sale'),(6,'Tài chính'),(9,'Thư kí');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam`
--

DROP TABLE IF EXISTS `exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exam` (
  `exam_id` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `code1` char(10) NOT NULL,
  `code2` char(10) DEFAULT NULL,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `duration` tinyint unsigned NOT NULL DEFAULT '45',
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`exam_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam`
--

LOCK TABLES `exam` WRITE;
/*!40000 ALTER TABLE `exam` DISABLE KEYS */;
INSERT INTO `exam` VALUES (1,'S-1',NULL,'Đề thi C#',60,'2019-04-05 00:00:00'),(2,'S-2',NULL,'Đề thi PHP',60,'2019-04-05 00:00:00'),(3,'M-1',NULL,'Đề thi C++',120,'2019-04-07 00:00:00'),(4,'S-3',NULL,'Đề thi Java',60,'2020-04-08 00:00:00'),(5,'M-2',NULL,'Đề thi Ruby',120,'2020-04-10 00:00:00'),(6,'S-4',NULL,'Đề thi Postman',60,'2020-04-05 00:00:00'),(7,'S-5',NULL,'Đề thi SQL',60,'2020-04-05 00:00:00'),(8,'S-6',NULL,'Đề thi Python',60,'2020-04-07 00:00:00'),(9,'L-1',NULL,'Đề thi ADO.NET',180,'2020-04-07 00:00:00'),(10,'L-2',NULL,'Đề thi ASP.NET',180,'2020-04-08 00:00:00'),(11,'MI-6',NULL,'MI6',120,'2022-02-19 20:37:30');
/*!40000 ALTER TABLE `exam` ENABLE KEYS */;
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
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`group_id`),
  UNIQUE KEY `group_name` (`group_name`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group`
--

LOCK TABLES `group` WRITE;
/*!40000 ALTER TABLE `group` DISABLE KEYS */;
INSERT INTO `group` VALUES (1,'Fixed Group','2019-03-05 00:00:00'),(2,'Developement','2020-03-07 00:00:00'),(4,'VTI Sale 02','2020-03-10 00:00:00'),(5,'VTI Sale 03','2020-03-28 00:00:00'),(6,'VTI Creator','2020-04-06 00:00:00'),(7,'VTI Marketing 01','2020-04-07 00:00:00'),(8,'Management','2020-04-08 00:00:00'),(9,'Chat with love','2020-04-09 00:00:00'),(10,'Test5','2020-04-10 00:00:00'),(11,'test',NULL),(12,'test2','2022-02-15 23:20:50'),(13,'test3','2022-02-16 20:32:04');
/*!40000 ALTER TABLE `group` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES (1,'Dev'),(2,'Test'),(3,'ScrumMaster'),(4,'PM');
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
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'Câu hỏi về Java','2020-04-05 00:00:00'),(2,'Câu Hỏi về PHP','2020-04-05 00:00:00'),(3,'Hỏi về C#','2020-04-06 00:00:00'),(4,'Hỏi về Ruby','2020-04-06 00:00:00'),(5,'Hỏi về Postman','2020-04-06 00:00:00'),(6,'Hỏi về ADO.NET','2020-04-06 00:00:00'),(7,'Hỏi về ASP.NET','2020-04-06 00:00:00'),(8,'Hỏi về C++','2020-04-07 00:00:00'),(9,'Hỏi về SQL','2020-04-07 00:00:00'),(10,'Hỏi về Python','2020-04-07 00:00:00'),(11,'Hỏi về vũ trụ','2022-02-19 20:47:51');
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary`
--

LOCK TABLES `salary` WRITE;
/*!40000 ALTER TABLE `salary` DISABLE KEYS */;
INSERT INTO `salary` VALUES (1,'600'),(2,'700'),(3,'1500'),(6,'2000');
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

-- Dump completed on 2022-02-19 21:17:12
