-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 10.113.234.112    Database: translationbot
-- ------------------------------------------------------
-- Server version	5.7.14

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `dic_tb`
--

DROP TABLE IF EXISTS `dic_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dic_tb` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `lang1` varchar(20) NOT NULL,
  `lang2` varchar(20) NOT NULL,
  `bottype` int(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=234 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dic_tb`
--

LOCK TABLES `dic_tb` WRITE;
/*!40000 ALTER TABLE `dic_tb` DISABLE KEYS */;
INSERT INTO `dic_tb` VALUES (162,'키보드','keyboard',0),(163,'치약','toothpaste',0),(164,'한국어','韓国語',1),(165,'파리','fly',0),(166,'비행','fly',0),(171,'운동','exercise',0),(179,'감기','cold',0),(180,'버섯','mushroom',0),(181,'충전','charging',0),(182,'이어폰','earphones',0),(183,'칫솔','toothbrush',0),(184,'꽃','flower',0),(185,'눈','eye',0),(186,'컴퓨터','computer',0),(187,'exercus','exercus',0),(188,'exercise','運動',3),(189,'dog','犬',3),(190,'morning','朝',3),(191,'cat','猫',3),(192,'citizen','市民',3),(193,'book','本',3),(194,'mouse','マウス',3),(195,'기분','気分',1),(196,'책','本',1),(197,'운동','運動',1),(198,'사진','写真',1),(199,'고양이','cat',0),(200,'강아지','puppy',0),(201,'학습','learning',0),(202,'안경','glasses',0),(203,'기념일','anniversary',0),(204,'치아','teeth',0),(205,'인간','human',0),(206,'시민','citizen',0),(207,'식사','食事',1),(208,'안심','安心',1),(209,'국민','国民',1),(210,'인간','人間',1),(211,'시민','市民',1),(212,'rain','雨',3),(213,'math','数学',3),(214,'공기','空気',1),(215,'학습','学习',2),(216,'강아지','小狗',2),(217,'고양이','猫',2),(218,'안구','眼睛',2),(219,'운동','锻炼',2),(221,'인간','人类',2),(222,'유물','工件',2),(223,'시민','公民',2),(226,'가방','bag',0),(227,'시계','watch',0),(228,'안목','run',0),(229,'연필','pencil',0),(230,'인구','population',0),(231,'구성','configuration',0),(232,'인격','personality',0),(233,'기분','mood',0);
/*!40000 ALTER TABLE `dic_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test_hsy_tb`
--

DROP TABLE IF EXISTS `test_hsy_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test_hsy_tb` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `usr_tb_id` bigint(20) NOT NULL,
  `rw` int(1) DEFAULT NULL,
  `bottype` int(1) NOT NULL,
  `question` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=269 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test_hsy_tb`
--

LOCK TABLES `test_hsy_tb` WRITE;
/*!40000 ALTER TABLE `test_hsy_tb` DISABLE KEYS */;
INSERT INTO `test_hsy_tb` VALUES (245,'2016-08-29 15:23:07',100000043251001,0,0,'exercise'),(250,'2016-08-30 09:59:52',100000043251001,0,0,'keyboard'),(251,'2016-08-30 10:08:09',100000043251001,0,0,'toothpaste'),(253,'2016-08-30 10:08:23',100000043251001,0,0,'toothbrush'),(254,'2016-08-30 10:08:30',100000043251001,0,0,'toothpaste'),(255,'2016-08-30 10:18:36',100000043251001,0,0,'glasses'),(256,'2016-08-30 10:18:41',100000043251001,1,0,'learning'),(257,'2016-08-30 10:18:54',100000043251001,0,0,'exercise'),(258,'2016-08-30 10:19:05',100000043251001,0,0,'puppy'),(259,'2016-08-30 10:19:11',100000043251001,0,0,'cat'),(260,'2016-08-30 10:23:54',100000043251001,0,0,'puppy'),(261,'2016-08-30 10:24:00',100000043251001,0,0,'cat'),(263,'2016-08-30 10:24:12',100000043251001,0,0,'exercise'),(265,'2016-08-30 10:24:43',100000043251001,1,0,'비행'),(267,'2016-08-30 17:38:22',100000043251001,0,2,'公民'),(268,'2016-08-30 17:38:32',100000043251001,0,2,'工件');
/*!40000 ALTER TABLE `test_hsy_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `translate_hsy_tb`
--

DROP TABLE IF EXISTS `translate_hsy_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `translate_hsy_tb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `flag` int(1) NOT NULL,
  `date` datetime NOT NULL,
  `usr_tb_id` bigint(20) NOT NULL,
  `dic_tb_id` int(10) NOT NULL,
  `usr_tb_bottype` int(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=316 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `translate_hsy_tb`
--

LOCK TABLES `translate_hsy_tb` WRITE;
/*!40000 ALTER TABLE `translate_hsy_tb` DISABLE KEYS */;
INSERT INTO `translate_hsy_tb` VALUES (310,1,'2016-08-28 13:14:24',100000043251001,183,0),(311,1,'2016-08-29 13:14:29',100000043251001,230,0),(313,1,'2016-08-31 13:15:14',100000043251001,231,0),(314,1,'2016-08-31 13:15:40',100000043251001,232,0),(315,1,'2016-08-31 13:15:43',100000043251001,233,0);
/*!40000 ALTER TABLE `translate_hsy_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usr_tb`
--

DROP TABLE IF EXISTS `usr_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usr_tb` (
  `id` bigint(20) NOT NULL,
  `bottype` int(1) NOT NULL,
  `flag` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`,`bottype`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usr_tb`
--

LOCK TABLES `usr_tb` WRITE;
/*!40000 ALTER TABLE `usr_tb` DISABLE KEYS */;
INSERT INTO `usr_tb` VALUES (100000043251001,0,0),(100000043251001,1,0),(100000043251001,2,0),(100000043251001,3,0);
/*!40000 ALTER TABLE `usr_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'translationbot'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-02 13:32:23
