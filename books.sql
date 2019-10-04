-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: books
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `items` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(50) NOT NULL,
  `AUTHOR` varchar(35) NOT NULL,
  `ISBN` varchar(13) DEFAULT NULL,
  `SALEPRICE` decimal(8,2) NOT NULL,
  `AVGDAYSTOSELL` int(11) NOT NULL,
  `PERCENTPAID` decimal(4,2) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES (14,'THE INHERITANCE TRILOGY','N. K. JEMISIN','9780316334006',10.00,7,0.40),(15,'THE INHERITANCE TRILOGY','N. K. JEMISIN','9780316334006',10.00,7,0.40),(16,'THE WAY OF KINGS','BRANDON SANDERSON','9780765326355',15.00,10,0.40),(17,'THE INHERITANCE TRILOGY','N. K. JEMISIN','9780316334006',10.00,7,0.40),(18,'JAVA WITH KELLI','KELLI KLEINDORFER','123456789',75.00,90,0.20);
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `items_on_list`
--

DROP TABLE IF EXISTS `items_on_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `items_on_list` (
  `ITEM_ID` int(11) NOT NULL,
  `LIST_ID` int(11) NOT NULL,
  KEY `LIST_ID` (`LIST_ID`),
  KEY `ITEM_ID` (`ITEM_ID`),
  CONSTRAINT `items_on_list_ibfk_1` FOREIGN KEY (`LIST_ID`) REFERENCES `list_details` (`LIST_ID`),
  CONSTRAINT `items_on_list_ibfk_2` FOREIGN KEY (`ITEM_ID`) REFERENCES `items` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items_on_list`
--

LOCK TABLES `items_on_list` WRITE;
/*!40000 ALTER TABLE `items_on_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `items_on_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list_details`
--

DROP TABLE IF EXISTS `list_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `list_details` (
  `LIST_ID` int(11) NOT NULL AUTO_INCREMENT,
  `LIST_NAME` varchar(30) DEFAULT NULL,
  `SELL_DATE` date DEFAULT NULL,
  `SELLER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`LIST_ID`),
  KEY `SELLER_ID` (`SELLER_ID`),
  CONSTRAINT `list_details_ibfk_1` FOREIGN KEY (`SELLER_ID`) REFERENCES `seller` (`SELLER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list_details`
--

LOCK TABLES `list_details` WRITE;
/*!40000 ALTER TABLE `list_details` DISABLE KEYS */;
INSERT INTO `list_details` VALUES (1,'Bill\'s List','2019-10-03',9);
/*!40000 ALTER TABLE `list_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seller`
--

DROP TABLE IF EXISTS `seller`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seller` (
  `SELLER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `SELLER_NAME` varchar(30) NOT NULL,
  `SELLER_DRIVER_LICENSE` varchar(30) NOT NULL,
  PRIMARY KEY (`SELLER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seller`
--

LOCK TABLES `seller` WRITE;
/*!40000 ALTER TABLE `seller` DISABLE KEYS */;
INSERT INTO `seller` VALUES (1,'Bill','978xx1234'),(2,'Bill','978xx1234'),(3,'Bill','978xx1234'),(4,'Bill','978xx1234'),(5,'Daniel Meeker','123xx4567'),(6,'Daniel Meeker','123xx4567'),(7,'Andy Lister',''),(8,'Bill','978xx1234'),(9,'Bill','978xx1234');
/*!40000 ALTER TABLE `seller` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'books'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-03 19:38:37
