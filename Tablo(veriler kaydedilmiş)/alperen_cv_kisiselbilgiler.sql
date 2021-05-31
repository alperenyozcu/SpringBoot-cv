-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: alperen_cv
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
-- Table structure for table `kisiselbilgiler`
--

DROP TABLE IF EXISTS `kisiselbilgiler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kisiselbilgiler` (
  `id` int NOT NULL AUTO_INCREMENT,
  `aciklama` varchar(255) DEFAULT NULL,
  `adres` varchar(255) DEFAULT NULL,
  `dogtarih` date DEFAULT NULL,
  `meslek` varchar(255) DEFAULT NULL,
  `telefon` varchar(255) DEFAULT NULL,
  `kullaniciid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8jyl4nva9tgpv60ygy3p5kx97` (`kullaniciid`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kisiselbilgiler`
--

LOCK TABLES `kisiselbilgiler` WRITE;
/*!40000 ALTER TABLE `kisiselbilgiler` DISABLE KEYS */;
INSERT INTO `kisiselbilgiler` VALUES (6,'Orta seviyede İngilizce bilmekteyim.  Takım çalışmasına yatkınım. Analitik  düşünce yapısına sahibim. İş  Devamlılığı, İş Disiplini ve Zaman  Yönetimi konularında yetenekli  olduğumu düşünüyorum.',' Saklıkent Villaları No 29 ','2000-11-18','Bilgisayar Mühendisi','05338850324',6);
/*!40000 ALTER TABLE `kisiselbilgiler` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-31 21:10:21
