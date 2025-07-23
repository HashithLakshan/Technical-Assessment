-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: toDoAplication
-- ------------------------------------------------------
-- Server version	8.0.42

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
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task` (
  `task_id` bigint NOT NULL,
  `common_status` enum('ACTIVE','INACTIVE') NOT NULL,
  `task_discription` varchar(100) NOT NULL,
  `task_status` enum('ASSIGNED','COMPLETED') NOT NULL,
  `task_title` varchar(25) NOT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (483405,'ACTIVE','Plan the soft ball cricket match on the next Sunday.','ASSIGNED','Play Cricket','2025-07-23 14:22:38.636433','2025-07-23 14:22:38.636433'),(550871,'ACTIVE','Finish the mid-term assignments.','ASSIGNED','Take Home Assignment','2025-07-23 14:23:29.196771','2025-07-23 14:23:29.196771'),(625888,'ACTIVE','Need to clean the bed room.','ASSIGNED','Clean Home','2025-07-23 14:24:16.003126','2025-07-23 14:24:16.003126'),(640831,'ACTIVE',' go to meet his girlfriend at her home.','ASSIGNED','Help Naveen','2025-07-23 14:29:33.350541','2025-07-23 14:29:33.350541'),(677397,'ACTIVE','Buy books for the next school year.','ASSIGNED','Buy Books','2025-07-23 14:25:02.132783','2025-07-23 14:25:02.132783'),(820310,'ACTIVE','Go to his mother’s home.','COMPLETED','Help Kasun','2025-07-23 14:28:13.741571','2025-07-23 14:29:40.802393'),(945782,'ACTIVE','Buy books for the next school year.','ASSIGNED','Help Saman','2025-07-23 14:12:10.088147','2025-07-23 14:12:10.088147');
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-23 20:02:47
