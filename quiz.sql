-- MySQL dump 10.13  Distrib 5.5.54, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: quiz
-- ------------------------------------------------------
-- Server version	5.5.54-0ubuntu0.14.04.1

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
-- Current Database: `quiz`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `quiz` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `quiz`;

--
-- Table structure for table `quiz`
--

DROP TABLE IF EXISTS `quiz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quiz` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL,
  `quizresults` double(8,2) NOT NULL,
  `quiztype` int(10) DEFAULT NULL,
  `quiz_taken` date NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`id`),
  KEY `quiz_user_id_index` (`user_id`),
  CONSTRAINT `quiz_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quiz`
--

LOCK TABLES `quiz` WRITE;
/*!40000 ALTER TABLE `quiz` DISABLE KEYS */;
INSERT INTO `quiz` VALUES (1,1,80.00,1,'2017-01-30'),(2,1,100.00,2,'2017-01-30'),(3,1,100.00,3,'2017-01-30'),(4,1,100.00,4,'2017-01-30'),(5,2,80.00,1,'2017-01-31'),(6,3,80.00,1,'2017-02-01'),(7,9,100.00,4,'2017-02-05');
/*!40000 ALTER TABLE `quiz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quiz_question`
--

DROP TABLE IF EXISTS `quiz_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quiz_question` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `question` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cor_answer` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `wrong_ans1` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `wrong_ans2` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `wrong_ans3` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `is_tf` bit(1) DEFAULT NULL,
  `tf_ans` bit(1) DEFAULT NULL,
  `quiztype` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quiz_question`
--

LOCK TABLES `quiz_question` WRITE;
/*!40000 ALTER TABLE `quiz_question` DISABLE KEYS */;
INSERT INTO `quiz_question` VALUES (1,'Which of the following characteristics should not be used to assess the quality of a WebApp?','Aesthetics','Maintainability','Usability','Reliability','\0','\0',1),(2,'Which of the following characteristics should not be used to assess the quality of a WebApp?','aesthetics','maintainability','usability','reliability','\0','\0',1),(3,'The Quality Requirement Tree for WebApps','Maintainability','Usability','Functionality','Reliability','\0','\0',1),(4,'Which quality from the Quality Requirements Tree involves; ease of correction, adaptability, and extensibility?','Maintainability','Usability','Functionality','Reliability','\0','\0',1),(5,'Which quality from the Quality Requirements Tree involves; Global site understandability, online feedback and help features, interface and aesthetic features and special features?','Usability','Functionality','Reliability','Efficiency','\0','\0',1),(6,'Which quality from the Quality Requirements Tree involves; Searching and retrieving capability, navigation and browsing features and application domain-related features?','Functionality','Usability','Reliability','Efficiency','\0','\0',1),(7,'Which of these is NOT one of the 4 attributes of quality for Web Apps?','Commodity','Security','Availability','Scalability','\0','\0',1),(8,'Which of the following are not a design goal for WebApps?','Time-to-market','Simplicity','Navigability','Compatibility','\0','\0',1),(9,'T/F  Screen layout design has several widely accepted standards based on human factors research?',NULL,NULL,NULL,NULL,'','\0',1),(10,'T/F  Graphic design considers every aspect of the look and feel of a WebApp.',NULL,NULL,NULL,NULL,'','',1),(11,'Content design is conducted  by;',' Copywriters, graphic designers and web engineers',' Web engineers',' Copywriters and graphic designer',' None of the above','\0','\0',2),(12,'T/F  Content objects are not normally chunked into Web pages until the implementation activities begin.',NULL,NULL,NULL,NULL,'','\0',2),(13,'T/F  Content objects have both information attributes defined during analysis and implementation specific attributes specified during design.',NULL,NULL,NULL,NULL,'','',2),(14,'T/F  Content architecture and WebApp architecture are pretty much the same thing for many WebApps.',NULL,NULL,NULL,NULL,'','\0',2),(15,'Which of the following is not one of the content architectural structures used by web engineers?','parallel','grid','linear','hierarchical','\0','\0',2),(16,'MVC is a 3 layer architecture that contains a ','model, view and controller','machine, view, content objects','model, view, and content objects','machine, view and controller','\0','\0',2),(17,'T/F  Web navigational design involves creating a semantic navigational unit for each goal associated with each defined user role.',NULL,NULL,NULL,NULL,'','',2),(18,'T/F  To allow the user to feel in control of a WebApp, it is a good idea to mix both horizontal and vertical navigation mechanisms on the same page.',NULL,NULL,NULL,NULL,'','\0',2),(19,'T/F  Component level design for WebApps is very similar to component level design for other software delivery systems.',NULL,NULL,NULL,NULL,'','',2),(20,'Which of these is not one of the design activities associated with object-oriented hypermedia design?','navigational design','conceptual design','abstract interface design','content design','\0','\0',2),(21,'T/F  UML does not have any representation schemas that are useful in building WebApp design models.',NULL,NULL,NULL,NULL,'','\0',3),(22,'T/F  Quality of conformance focuses on the degree to which the implementation of a design meets its requirements and performance goals.',NULL,NULL,NULL,NULL,'','',3),(23,'Which of the following is not one of the attributes of software quality?','Removes need to consider performance issues','Effective software process creates infrastructure','Adds value for developers and users','Useful products satisfy stakeholder requirements','\0','\0',3),(24,'T/F  Product quality can only be assessed by measuring hard quality factors.',NULL,NULL,NULL,NULL,'','\0',3),(25,'T/F  Many software metrics can only be measures indirectly.',NULL,NULL,NULL,NULL,'','',3),(26,'Which of the following are ISO 9126 software quality factors?','Functionality','a, b, and c','Portability','Visual appeal','\0','\0',3),(27,'T/F  Developers need to create a collection of targeted questions to asses each quality factor.',NULL,NULL,NULL,NULL,'','',3),(28,'T/F  Software metrics represent direct measures of some manifestation of quality.',NULL,NULL,NULL,NULL,'','\0',3),(29,'T/F  The quality dilemma might be summarized as choosing between building things quickly or building things correctly.',NULL,NULL,NULL,NULL,'','\0',3),(30,'T/F  Good enough software delivers high quality software functions along with specialized functions that contain known bugs.',NULL,NULL,NULL,NULL,'','',3),(31,'Which of the following is not one of the attributes of software quality?','Removes need to consider performance issues','Effective software process creates infrastructure','Adds value for developers and users','Removes need to consider performance issues','\0','\0',4),(32,'T/F  Product quality can only be assessed by measuring hard quality factors.',NULL,NULL,NULL,NULL,'','',4),(33,'T/F Many software metrics can only be measures indirectly.',NULL,NULL,NULL,NULL,'','',4),(34,'T/F Developers need to create a collection of targeted questions to asses each quality factor.',NULL,NULL,NULL,NULL,'','',4),(35,'T/F Software metrics represent direct measures of some manifestation of quality.',NULL,NULL,NULL,NULL,'','',4),(36,'T/F The quality dilemma might be summarized as choosing between building things quickly or building things correctly.',NULL,NULL,NULL,NULL,'','',4),(37,'T/F Good enough software delivers high quality software functions along with specialized functions that contain known bugs.',NULL,NULL,NULL,NULL,'','',4),(38,'T/F Poor quality leads to software risks that can become serious?',NULL,NULL,NULL,NULL,'','',4),(39,'T/F Quality control encompasses a set of software engineering actions that help to ensure that each work product meets its quality goals.',NULL,NULL,NULL,NULL,'','',4),(40,'T/F The goal of quality assurance is to insure that a software project is error free.',NULL,NULL,NULL,NULL,'','',4);
/*!40000 ALTER TABLE `quiz_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quiztype`
--

DROP TABLE IF EXISTS `quiztype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quiztype` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `quiztype` tinytext COLLATE utf8_unicode_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quiztype`
--

LOCK TABLES `quiztype` WRITE;
/*!40000 ALTER TABLE `quiztype` DISABLE KEYS */;
INSERT INTO `quiztype` VALUES (1,'Quiz 1'),(2,'Quiz 2'),(3,'Quiz 3'),(4,'Final Quiz');
/*!40000 ALTER TABLE `quiztype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lastname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `quizlevel` int(10) DEFAULT '1',
  `is_admin` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Admin','Administrator','admin@test.com','admin','adminpass',4,1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-05 16:59:13
