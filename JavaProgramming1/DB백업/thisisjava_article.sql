-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: thisisjava
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article` (
  `id` int NOT NULL AUTO_INCREMENT,
  `writer` varchar(20) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `content` text,
  `count` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (1,'이','연습글 제목1','이것은 연습글입니다.1',0),(2,'김','연습글 제목2','이것은 연습글입니다.2',0),(3,'김','연습글 제목3','이것은 연습글입니다.3',0),(4,'정0','제목0','내용0',0),(5,'정1','제목1','내용1',0),(6,'정2','제목2','내용2',0),(7,'정3','제목3','내용3',0),(8,'정4','제목4','내용4',0),(9,'정5','제목5','내용5',0),(10,'정6','제목6','내용6',0),(11,'정7','제목7','내용7',0),(12,'정8','제목8','내용8',0),(13,'정9','제목9','내용9',0),(14,'정0','제목0','내용0',0),(15,'정1','제목1','내용1',0),(16,'정2','제목2','내용2',0),(17,'정3','제목3','내용3',0),(18,'정4','제목4','내용4',0),(19,'정5','제목5','내용5',0),(20,'정6','제목6','내용6',0),(21,'정7','제목7','내용7',0),(22,'정8','제목8','내용8',0),(23,'정9','제목9','내용9',0),(24,'정0','제목0','내용0',0),(25,'정1','제목1','내용1',0),(26,'정2','제목2','내용2',0),(27,'정3','제목3','내용3',0),(28,'정4','제목4','내용4',0),(29,'정5','제목5','내용5',0),(30,'정6','제목6','내용6',0),(31,'정7','제목7','내용7',0),(32,'정8','제목8','내용8',0),(33,'정9','제목9','내용9',0),(34,'강1','제목1','내용1',0),(35,'강2','제목2','내용2',0),(36,'강3','제목3','내용3',0),(37,'강4','제목4','내용4',0),(38,'강5','제목5','내용5',0),(39,'강6','제목6','내용6',0),(40,'강7','제목7','내용7',0),(41,'강8','제목8','내용8',0),(42,'강9','제목9','내용9',0),(43,'강10','제목10','내용10',0);
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-26 12:24:14
