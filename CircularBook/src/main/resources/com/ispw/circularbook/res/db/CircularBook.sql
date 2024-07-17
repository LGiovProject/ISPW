-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: circularbook
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `book_available`
--

DROP TABLE IF EXISTS `book_available`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_available` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(25) NOT NULL,
  `type_of_disponibility` int NOT NULL COMMENT 'type 1 for lendable book\\ntype 2 for giftable book 3 for book lended 4 for book gifted',
  PRIMARY KEY (`id`),
  KEY `book_email_idx` (`email`),
  CONSTRAINT `book_available_email` FOREIGN KEY (`email`) REFERENCES `login` (`email`),
  CONSTRAINT `book_available_id` FOREIGN KEY (`id`) REFERENCES `book_data` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_available`
--

LOCK TABLES `book_available` WRITE;
/*!40000 ALTER TABLE `book_available` DISABLE KEYS */;
INSERT INTO `book_available` VALUES (1,'marco@gmail.com',1),(2,'marco@gmail.com',2),(3,'marco@gmail.com',1),(4,'carlo@gmail.com',1),(5,'carlo@gmail.com',2),(6,'carlo@gmail.com',1),(7,'carlo@gmail.com',1),(9,'lalibreria@libero.it',2),(11,'feltrinelli@virgilio.it',2),(12,'feltrinelli@virgilio.it',1),(13,'feltrinelli@virgilio.it',1);
/*!40000 ALTER TABLE `book_available` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `book_available_book_shop`
--

DROP TABLE IF EXISTS `book_available_book_shop`;
/*!50001 DROP VIEW IF EXISTS `book_available_book_shop`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `book_available_book_shop` AS SELECT 
 1 AS `id`,
 1 AS `email`,
 1 AS `username`,
 1 AS `type_of_disponibility`,
 1 AS `publisher`,
 1 AS `author`,
 1 AS `argument`,
 1 AS `title`,
 1 AS `npage`,
 1 AS `comment`,
 1 AS `account_type`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `book_available_info`
--

DROP TABLE IF EXISTS `book_available_info`;
/*!50001 DROP VIEW IF EXISTS `book_available_info`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `book_available_info` AS SELECT 
 1 AS `id`,
 1 AS `email`,
 1 AS `username`,
 1 AS `type_of_disponibility`,
 1 AS `publisher`,
 1 AS `author`,
 1 AS `argument`,
 1 AS `title`,
 1 AS `npage`,
 1 AS `comment`,
 1 AS `account_type`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `book_available_user`
--

DROP TABLE IF EXISTS `book_available_user`;
/*!50001 DROP VIEW IF EXISTS `book_available_user`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `book_available_user` AS SELECT 
 1 AS `id`,
 1 AS `email`,
 1 AS `username`,
 1 AS `type_of_disponibility`,
 1 AS `publisher`,
 1 AS `author`,
 1 AS `argument`,
 1 AS `title`,
 1 AS `npage`,
 1 AS `comment`,
 1 AS `account_type`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `book_data`
--

DROP TABLE IF EXISTS `book_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_data` (
  `id` int NOT NULL AUTO_INCREMENT,
  `author` varchar(25) DEFAULT NULL,
  `argument` varchar(25) DEFAULT NULL,
  `publisher` varchar(25) DEFAULT NULL,
  `title` varchar(50) NOT NULL,
  `npage` int DEFAULT NULL,
  `comment` varchar(450) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_data`
--

LOCK TABLES `book_data` WRITE;
/*!40000 ALTER TABLE `book_data` DISABLE KEYS */;
INSERT INTO `book_data` VALUES (1,'aldo cazzullo','Historical','mondadori','storia di unitalia che non si lamentava',137,'storia di un paese molto più semplice dell\'attuale'),(2,'corrado guzzanti','Comic','l\'unità','il libro de kipli',90,NULL),(3,'piero malvezzi','Auto Biography','l\'unità','lettere di condannati a morte',180,NULL),(4,'stefano benni','Romance','feltrinelli','bar sport',129,'no comment'),(5,'niccolo ammaniti','Romance','piccolo biblioteca','ti prendo e ti porto via',432,'no comment'),(6,'michele serra','Romance','feltrinelli','gli straiati',108,'no comment'),(7,'gigi proietti','Comic','la repubblica','mandrake a roma',135,'no comment'),(8,'licia troisi','Fantasy','marsilio lucciole','la luce delle stelle',187,'no comment'),(9,'cesare pavese','Romance','oscar mondadori','il compagno',196,'un libro molto impegnato ma da leggere'),(10,'ray bradbury','Science Fiction','edizioni dello scorpione','la città perduta di marte',155,'storia tra fantascienza e realtà'),(11,'oliver sacks','Romance','elcograf','l\'uomo che scambio sua moglie per un cappello',301,'no comment'),(12,'thomas mann','Thriller','la repubblica','la morte a venezia',96,'no comment'),(13,'michela murgia','Romance','feltrinelli','le assaggiatrici',287,'no comment');
/*!40000 ALTER TABLE `book_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_shop`
--

DROP TABLE IF EXISTS `book_shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_shop` (
  `email` varchar(25) NOT NULL,
  `book_shop_name` varchar(25) DEFAULT NULL,
  `city` char(25) DEFAULT NULL,
  `address` char(25) DEFAULT NULL,
  `phone_number` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`email`),
  CONSTRAINT `library_email` FOREIGN KEY (`email`) REFERENCES `login` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_shop`
--

LOCK TABLES `book_shop` WRITE;
/*!40000 ALTER TABLE `book_shop` DISABLE KEYS */;
INSERT INTO `book_shop` VALUES ('feltrinelli@virgilio.it','la feltrinelli','Roma','via roma 3','63027215'),('lalibreria@libero.it','la libreria','Roma','via tito 56','63027211');
/*!40000 ALTER TABLE `book_shop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `book_taked`
--

DROP TABLE IF EXISTS `book_taked`;
/*!50001 DROP VIEW IF EXISTS `book_taked`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `book_taked` AS SELECT 
 1 AS `id`,
 1 AS `email_take`,
 1 AS `username_take`,
 1 AS `email_putter`,
 1 AS `username_putter`,
 1 AS `publisher`,
 1 AS `author`,
 1 AS `argument`,
 1 AS `title`,
 1 AS `npage`,
 1 AS `comment`,
 1 AS `type`,
 1 AS `account_type_putter`,
 1 AS `date_taked`,
 1 AS `date_finish`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `gifted_book`
--

DROP TABLE IF EXISTS `gifted_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gifted_book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email_take` varchar(25) NOT NULL,
  `email_gifter` varchar(25) NOT NULL,
  `date_taked` date NOT NULL,
  KEY `gifted_book_email_idx` (`email_gifter`),
  KEY `gifted_book_id_idx` (`id`),
  KEY `gifted_book_email_taker_idx` (`email_take`),
  CONSTRAINT `gifted_book_email_gifter` FOREIGN KEY (`email_gifter`) REFERENCES `login` (`email`),
  CONSTRAINT `gifted_book_email_taker` FOREIGN KEY (`email_take`) REFERENCES `users` (`email`),
  CONSTRAINT `gifted_book_id` FOREIGN KEY (`id`) REFERENCES `book_data` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gifted_book`
--

LOCK TABLES `gifted_book` WRITE;
/*!40000 ALTER TABLE `gifted_book` DISABLE KEYS */;
INSERT INTO `gifted_book` VALUES (8,'marco@gmail.com','lalibreria@libero.it','2024-07-16');
/*!40000 ALTER TABLE `gifted_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `gifted_book_from_book_shop_info`
--

DROP TABLE IF EXISTS `gifted_book_from_book_shop_info`;
/*!50001 DROP VIEW IF EXISTS `gifted_book_from_book_shop_info`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `gifted_book_from_book_shop_info` AS SELECT 
 1 AS `id`,
 1 AS `email_take`,
 1 AS `username_take`,
 1 AS `email_gifter`,
 1 AS `username_gifter`,
 1 AS `publisher`,
 1 AS `author`,
 1 AS `argument`,
 1 AS `title`,
 1 AS `npage`,
 1 AS `comment`,
 1 AS `date_taked`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `gifted_book_from_user_info`
--

DROP TABLE IF EXISTS `gifted_book_from_user_info`;
/*!50001 DROP VIEW IF EXISTS `gifted_book_from_user_info`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `gifted_book_from_user_info` AS SELECT 
 1 AS `id`,
 1 AS `email_take`,
 1 AS `username_take`,
 1 AS `email_gifter`,
 1 AS `username_gifter`,
 1 AS `publisher`,
 1 AS `author`,
 1 AS `argument`,
 1 AS `title`,
 1 AS `npage`,
 1 AS `comment`,
 1 AS `date_taked`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `gifted_book_info`
--

DROP TABLE IF EXISTS `gifted_book_info`;
/*!50001 DROP VIEW IF EXISTS `gifted_book_info`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `gifted_book_info` AS SELECT 
 1 AS `id`,
 1 AS `email_take`,
 1 AS `username_take`,
 1 AS `email_gifter`,
 1 AS `username_gifter`,
 1 AS `publisher`,
 1 AS `author`,
 1 AS `argument`,
 1 AS `title`,
 1 AS `npage`,
 1 AS `comment`,
 1 AS `date_taked`,
 1 AS `account_type`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `lended_book`
--

DROP TABLE IF EXISTS `lended_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lended_book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email_lend` varchar(25) NOT NULL,
  `email_take` varchar(25) NOT NULL,
  `date_start` date NOT NULL,
  `date_finish` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `lended_book_email_idx` (`email_lend`),
  KEY `lended_book_email_take_idx` (`email_take`),
  CONSTRAINT `lended_book_email_lend` FOREIGN KEY (`email_lend`) REFERENCES `login` (`email`),
  CONSTRAINT `lended_book_email_take` FOREIGN KEY (`email_take`) REFERENCES `login` (`email`),
  CONSTRAINT `lended_book_id` FOREIGN KEY (`id`) REFERENCES `book_data` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lended_book`
--

LOCK TABLES `lended_book` WRITE;
/*!40000 ALTER TABLE `lended_book` DISABLE KEYS */;
INSERT INTO `lended_book` VALUES (10,'lalibreria@libero.it','carlo@gmail.com','2024-07-16','2024-09-16');
/*!40000 ALTER TABLE `lended_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `lended_book_by_book_shop_info`
--

DROP TABLE IF EXISTS `lended_book_by_book_shop_info`;
/*!50001 DROP VIEW IF EXISTS `lended_book_by_book_shop_info`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `lended_book_by_book_shop_info` AS SELECT 
 1 AS `id`,
 1 AS `email_take`,
 1 AS `username_take`,
 1 AS `email_lend`,
 1 AS `username_lend`,
 1 AS `publisher`,
 1 AS `author`,
 1 AS `argument`,
 1 AS `title`,
 1 AS `npage`,
 1 AS `comment`,
 1 AS `date_taked`,
 1 AS `date_finish`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `lended_book_by_user_info`
--

DROP TABLE IF EXISTS `lended_book_by_user_info`;
/*!50001 DROP VIEW IF EXISTS `lended_book_by_user_info`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `lended_book_by_user_info` AS SELECT 
 1 AS `id`,
 1 AS `email_take`,
 1 AS `username_take`,
 1 AS `email_lend`,
 1 AS `username_lend`,
 1 AS `publisher`,
 1 AS `author`,
 1 AS `argument`,
 1 AS `title`,
 1 AS `npage`,
 1 AS `comment`,
 1 AS `date_taked`,
 1 AS `date_finish`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `lended_book_info`
--

DROP TABLE IF EXISTS `lended_book_info`;
/*!50001 DROP VIEW IF EXISTS `lended_book_info`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `lended_book_info` AS SELECT 
 1 AS `id`,
 1 AS `email_take`,
 1 AS `username_take`,
 1 AS `email_lend`,
 1 AS `username_lend`,
 1 AS `publisher`,
 1 AS `author`,
 1 AS `argument`,
 1 AS `title`,
 1 AS `npage`,
 1 AS `comment`,
 1 AS `date_taked`,
 1 AS `date_finish`,
 1 AS `account_type`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `email` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('carlo@gmail.com','carlo1'),('feltrinelli@virgilio.it','feltri1'),('lalibreria@libero.it','libro1'),('luca@gmail.com','utente1'),('marco@gmail.com','marco1');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opportunity`
--

DROP TABLE IF EXISTS `opportunity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `opportunity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(25) NOT NULL,
  `type` int DEFAULT NULL,
  `title` varchar(45) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `date_start` date NOT NULL,
  `date_finish` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `sales_email_idx` (`email`),
  CONSTRAINT `sales_email` FOREIGN KEY (`email`) REFERENCES `book_shop` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opportunity`
--

LOCK TABLES `opportunity` WRITE;
/*!40000 ALTER TABLE `opportunity` DISABLE KEYS */;
INSERT INTO `opportunity` VALUES (1,'lalibreria@libero.it',1,'il portalettere','francesca giannone presentara  il suo nuovo libro ','2024-07-22','2024-07-24'),(2,'lalibreria@libero.it',2,'il giallo','grande promozione su tutti i libre gialli con il ter per due','2024-07-23','2024-07-31'),(3,'feltrinelli@virgilio.it',1,'maurizio de giovanni','tre giorni con l\'autore di il pianto dell\'alba dibattiti sul contenuto del libro','2024-07-24','2024-07-26'),(4,'feltrinelli@virgilio.it',2,'i romanzi oggi','raccolta di romanzi con la possibilità dello sconto del 20%','2024-07-25','2024-07-27');
/*!40000 ALTER TABLE `opportunity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `opportunity_info`
--

DROP TABLE IF EXISTS `opportunity_info`;
/*!50001 DROP VIEW IF EXISTS `opportunity_info`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `opportunity_info` AS SELECT 
 1 AS `id`,
 1 AS `email`,
 1 AS `book_shop_name`,
 1 AS `type_of_opportunity`,
 1 AS `title_of_opportunity`,
 1 AS `description`,
 1 AS `date_start`,
 1 AS `date_finish`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!50001 DROP VIEW IF EXISTS `user_info`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `user_info` AS SELECT 
 1 AS `email`,
 1 AS `username`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `email` varchar(25) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `name` char(25) DEFAULT NULL,
  `surname` char(25) DEFAULT NULL,
  `city` char(25) NOT NULL,
  PRIMARY KEY (`email`),
  KEY `username_index` (`username`),
  CONSTRAINT `users_email` FOREIGN KEY (`email`) REFERENCES `login` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('carlo@gmail.com','carlot','carla','melotti','Potenza'),('luca@gmail.com','null','null','null','Roma'),('marco@gmail.com','null','marco','lombo','Torino');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'circularbook'
--

--
-- Dumping routines for database 'circularbook'
--
/*!50003 DROP PROCEDURE IF EXISTS `insert_book` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_book`(in var_email varchar(25),in var_type_of_disponibility int,in var_publisher varchar(25),in var_author varchar(25), in var_argument varchar(25), in var_title varchar(50), in var_npage int, in var_comment varchar(450))
BEGIN

		start transaction;
			
            insert into book_data(author,argument,publisher,title,npage,comment)
            value(var_author,var_argument,var_publisher,var_title,var_npage,var_comment);
            
            insert into book_available(id,email,type_of_disponibility)
            value(last_insert_id(),var_email, var_type_of_disponibility);
            
            
            
            
        commit;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_book_shop` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_book_shop`(in var_email varchar(25), in var_password varchar(25),in var_book_shop_name varchar(25), in var_city varchar(25), in var_address varchar(25), in var_phone_number int)
BEGIN
		start transaction;
			insert into login(email, password)
			values(var_email,var_password);
			
			insert into book_shop(email,book_shop_name,city,address,phone_number)
			values(var_email,var_book_shop_name,var_city,var_address,var_phone_number);
        commit; 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_user` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_user`(in var_email varchar(25),in var_password varchar(25),in var_username varchar(20),in var_name char(20),in var_surname char(20), in var_city char(20))
BEGIN
		start transaction;
				insert into login(email,password)
				values(var_email,var_password);
				
				insert into users(email,username,name,surname,city) 
				values(var_email,var_username,var_name,var_surname,var_city);
        commit;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `remove_book` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `remove_book`(in var_id int)
BEGIN
		start transaction;
				
                delete from book_available where id=var_id;
                delete from book_data where id=var_id;
                
        commit;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `take_book_as_gift` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `take_book_as_gift`(in var_id int,in var_email_taker varchar(25),in var_email_gifter varchar(25),in var_date_taked date)
BEGIN
		declare check_id int;
        
		start transaction;
				
                
				select id
                from book_available 
                where var_id=id
                into check_id;
                
                if check_id is not null then
					
                    delete from book_available where id=var_id;
                
					insert into gifted_book(id,email_take,email_gifter,date_taked)
					values(var_id,var_email_taker,var_email_gifter,var_date_taked);
                
                else
					SIGNAL SQLSTATE '45012' SET MESSAGE_TEXT = 'Book no more available';
                end if;
                
        commit;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `take_book_on_lend` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `take_book_on_lend`(in var_id int,in var_email_getter varchar(25) ,in var_email_lender varchar(25),in var_date_start date, in var_date_finish date)
BEGIN
		declare check_id int;
        
		start transaction;
				
                
				select id
                from book_available 
                where var_id=id
                into check_id;
                
                if check_id is not null then
					
                    delete from book_available where id=var_id;
                
					insert into lended_book(id,email_lend,email_take,date_start,date_finish)
					values(var_id,var_email_lender,var_email_getter,var_date_start,var_date_finish);
                
                else
					SIGNAL SQLSTATE '45012' SET MESSAGE_TEXT = 'Libro non più disponibile';
                end if;
                
        commit;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_book` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_book`(in var_id int,in var_type_of_disponibility int,in var_publisher varchar(25), in var_author varchar(25), in var_argument varchar(25), in var_title varchar(50),in var_npage int, in var_comment varchar(450) )
BEGIN
	start transaction;
			update book_data
			SET	
				 publisher = var_publisher,
				 author = var_author,
				 argument = var_argument,
				 title= var_title,
				 npage = var_npage,
				 comment = var_comment
			WHERE
				id=var_id;
                
			update book_available
            SET
				type_of_disponibility = var_type_of_disponibility
            WHERE	
				id=var_id;
	commit;     
        
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `view_book_shop_circularbook_info` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `view_book_shop_circularbook_info`(in var_email varchar(25))
BEGIN


		DECLARE my_book_insert INT;
		DECLARE book_i_insert_take_as_lend INT;
		DECLARE book_i_insert_take_as_gift INT;
        DECLARE sales_i_insert INT;

	start transaction;

		-- Calcolo dei libri inseriti dalla libreria
		SELECT COUNT(*) INTO my_book_insert
		FROM book_available
		WHERE email = var_email;

		-- Calcolo dei libri prestati dalla libreria
		SELECT COUNT(*) INTO book_i_insert_take_as_lend
		FROM lended_book
		WHERE email_lend = var_email;

		-- Calcolo dei libri donati dalla libreria
		SELECT COUNT(*) INTO book_i_insert_take_as_gift
		FROM gifted_book
		WHERE email_gifter = var_email;
		
		SELECT COUNT(*) INTO  sales_i_insert
		FROM opportunity
		WHERE email= var_email;

		-- Restituzione dei risultati
		SELECT
			my_book_insert AS my_book_insert,
			sales_i_insert AS  sales_i_insert,
			book_i_insert_take_as_lend AS book_i_insert_take_as_lend,
			book_i_insert_take_as_gift AS book_i_insert_take_as_gift;
        
	commit;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `view_user_circularbook_info` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `view_user_circularbook_info`(in var_email varchar(25))
BEGIN
		DECLARE my_book_insert INT;
    DECLARE book_i_take_in_lend INT;
    DECLARE book_i_take_as_gift INT;
    DECLARE book_i_insert_take_as_lend INT;
    DECLARE book_i_insert_take_as_gift INT;

    -- Calcolo dei libri inseriti dall'utente
    SELECT COUNT(*) INTO my_book_insert
    FROM book_available
    WHERE email = var_email;

    -- Calcolo dei libri presi in prestito dall'utente
    SELECT COUNT(*) INTO book_i_take_in_lend
    FROM lended_book
    WHERE email_take = var_email;

    -- Calcolo dei libri ricevuti in dono dall'utente
    SELECT COUNT(*) INTO book_i_take_as_gift
    FROM gifted_book
    WHERE email_take = var_email;

    -- Calcolo dei libri prestati dall'utente
    SELECT COUNT(*) INTO book_i_insert_take_as_lend
    FROM lended_book
    WHERE email_lend = var_email;

    -- Calcolo dei libri donati dall'utente
    SELECT COUNT(*) INTO book_i_insert_take_as_gift
    FROM gifted_book
    WHERE email_gifter = var_email;

    -- Restituzione dei risultati
    SELECT
        my_book_insert AS my_book_insert,
        book_i_take_in_lend AS book_i_take_in_lend,
        book_i_take_as_gift AS book_i_take_as_gift,
        book_i_insert_take_as_lend AS book_i_insert_take_as_lend,
        book_i_insert_take_as_gift AS book_i_insert_take_as_gift;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `book_available_book_shop`
--

/*!50001 DROP VIEW IF EXISTS `book_available_book_shop`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `book_available_book_shop` AS select `book_data`.`id` AS `id`,`book_available`.`email` AS `email`,`book_shop`.`book_shop_name` AS `username`,`book_available`.`type_of_disponibility` AS `type_of_disponibility`,`book_data`.`publisher` AS `publisher`,`book_data`.`author` AS `author`,`book_data`.`argument` AS `argument`,`book_data`.`title` AS `title`,`book_data`.`npage` AS `npage`,`book_data`.`comment` AS `comment`,2 AS `account_type` from ((`book_data` join `book_available` on((`book_data`.`id` = `book_available`.`id`))) join `book_shop` on((`book_available`.`email` = `book_shop`.`email`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `book_available_info`
--

/*!50001 DROP VIEW IF EXISTS `book_available_info`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `book_available_info` AS select `book_available_book_shop`.`id` AS `id`,`book_available_book_shop`.`email` AS `email`,`book_available_book_shop`.`username` AS `username`,`book_available_book_shop`.`type_of_disponibility` AS `type_of_disponibility`,`book_available_book_shop`.`publisher` AS `publisher`,`book_available_book_shop`.`author` AS `author`,`book_available_book_shop`.`argument` AS `argument`,`book_available_book_shop`.`title` AS `title`,`book_available_book_shop`.`npage` AS `npage`,`book_available_book_shop`.`comment` AS `comment`,`book_available_book_shop`.`account_type` AS `account_type` from `book_available_book_shop` union select `book_available_user`.`id` AS `id`,`book_available_user`.`email` AS `email`,`book_available_user`.`username` AS `username`,`book_available_user`.`type_of_disponibility` AS `type_of_disponibility`,`book_available_user`.`publisher` AS `publisher`,`book_available_user`.`author` AS `author`,`book_available_user`.`argument` AS `argument`,`book_available_user`.`title` AS `title`,`book_available_user`.`npage` AS `npage`,`book_available_user`.`comment` AS `comment`,`book_available_user`.`account_type` AS `account_type` from `book_available_user` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `book_available_user`
--

/*!50001 DROP VIEW IF EXISTS `book_available_user`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `book_available_user` AS select `book_data`.`id` AS `id`,`book_available`.`email` AS `email`,`users`.`username` AS `username`,`book_available`.`type_of_disponibility` AS `type_of_disponibility`,`book_data`.`publisher` AS `publisher`,`book_data`.`author` AS `author`,`book_data`.`argument` AS `argument`,`book_data`.`title` AS `title`,`book_data`.`npage` AS `npage`,`book_data`.`comment` AS `comment`,1 AS `account_type` from ((`book_data` join `book_available` on((`book_data`.`id` = `book_available`.`id`))) join `users` on((`book_available`.`email` = `users`.`email`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `book_taked`
--

/*!50001 DROP VIEW IF EXISTS `book_taked`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `book_taked` AS select `lended_book_info`.`id` AS `id`,`lended_book_info`.`email_take` AS `email_take`,`lended_book_info`.`username_take` AS `username_take`,`lended_book_info`.`email_lend` AS `email_putter`,`lended_book_info`.`username_lend` AS `username_putter`,`lended_book_info`.`publisher` AS `publisher`,`lended_book_info`.`author` AS `author`,`lended_book_info`.`argument` AS `argument`,`lended_book_info`.`title` AS `title`,`lended_book_info`.`npage` AS `npage`,`lended_book_info`.`comment` AS `comment`,1 AS `type`,`lended_book_info`.`account_type` AS `account_type_putter`,`lended_book_info`.`date_taked` AS `date_taked`,`lended_book_info`.`date_finish` AS `date_finish` from `lended_book_info` union select `gifted_book_info`.`id` AS `id`,`gifted_book_info`.`email_take` AS `email_take`,`gifted_book_info`.`username_take` AS `username_take`,`gifted_book_info`.`email_gifter` AS `email_putter`,`gifted_book_info`.`username_gifter` AS `username_putter`,`gifted_book_info`.`publisher` AS `publisher`,`gifted_book_info`.`author` AS `author`,`gifted_book_info`.`argument` AS `argument`,`gifted_book_info`.`title` AS `title`,`gifted_book_info`.`npage` AS `npage`,`gifted_book_info`.`comment` AS `comment`,2 AS `type`,`gifted_book_info`.`account_type` AS `account_type_putter`,`gifted_book_info`.`date_taked` AS `date_taked`,NULL AS `date_finish` from `gifted_book_info` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `gifted_book_from_book_shop_info`
--

/*!50001 DROP VIEW IF EXISTS `gifted_book_from_book_shop_info`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `gifted_book_from_book_shop_info` AS select `book_data`.`id` AS `id`,`gifted_book`.`email_take` AS `email_take`,`user_take`.`username` AS `username_take`,`gifted_book`.`email_gifter` AS `email_gifter`,`book_shop_gift`.`book_shop_name` AS `username_gifter`,`book_data`.`publisher` AS `publisher`,`book_data`.`author` AS `author`,`book_data`.`argument` AS `argument`,`book_data`.`title` AS `title`,`book_data`.`npage` AS `npage`,`book_data`.`comment` AS `comment`,`gifted_book`.`date_taked` AS `date_taked` from (((`book_data` join `gifted_book` on((`book_data`.`id` = `gifted_book`.`id`))) join `users` `user_take` on((`gifted_book`.`email_take` = `user_take`.`email`))) join `book_shop` `book_shop_gift` on((`gifted_book`.`email_gifter` = `book_shop_gift`.`email`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `gifted_book_from_user_info`
--

/*!50001 DROP VIEW IF EXISTS `gifted_book_from_user_info`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `gifted_book_from_user_info` AS select `book_data`.`id` AS `id`,`gifted_book`.`email_take` AS `email_take`,`user_take`.`username` AS `username_take`,`gifted_book`.`email_gifter` AS `email_gifter`,`user_gift`.`username` AS `username_gifter`,`book_data`.`publisher` AS `publisher`,`book_data`.`author` AS `author`,`book_data`.`argument` AS `argument`,`book_data`.`title` AS `title`,`book_data`.`npage` AS `npage`,`book_data`.`comment` AS `comment`,`gifted_book`.`date_taked` AS `date_taked` from (((`book_data` join `gifted_book` on((`book_data`.`id` = `gifted_book`.`id`))) join `users` `user_take` on((`gifted_book`.`email_take` = `user_take`.`email`))) join `users` `user_gift` on((`gifted_book`.`email_gifter` = `user_gift`.`email`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `gifted_book_info`
--

/*!50001 DROP VIEW IF EXISTS `gifted_book_info`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `gifted_book_info` AS select `gifted_book_from_user_info`.`id` AS `id`,`gifted_book_from_user_info`.`email_take` AS `email_take`,`gifted_book_from_user_info`.`username_take` AS `username_take`,`gifted_book_from_user_info`.`email_gifter` AS `email_gifter`,`gifted_book_from_user_info`.`username_gifter` AS `username_gifter`,`gifted_book_from_user_info`.`publisher` AS `publisher`,`gifted_book_from_user_info`.`author` AS `author`,`gifted_book_from_user_info`.`argument` AS `argument`,`gifted_book_from_user_info`.`title` AS `title`,`gifted_book_from_user_info`.`npage` AS `npage`,`gifted_book_from_user_info`.`comment` AS `comment`,`gifted_book_from_user_info`.`date_taked` AS `date_taked`,1 AS `account_type` from `gifted_book_from_user_info` union select `gifted_book_from_book_shop_info`.`id` AS `id`,`gifted_book_from_book_shop_info`.`email_take` AS `email_take`,`gifted_book_from_book_shop_info`.`username_take` AS `username_take`,`gifted_book_from_book_shop_info`.`email_gifter` AS `email_gifter`,`gifted_book_from_book_shop_info`.`username_gifter` AS `username_gifter`,`gifted_book_from_book_shop_info`.`publisher` AS `publisher`,`gifted_book_from_book_shop_info`.`author` AS `author`,`gifted_book_from_book_shop_info`.`argument` AS `argument`,`gifted_book_from_book_shop_info`.`title` AS `title`,`gifted_book_from_book_shop_info`.`npage` AS `npage`,`gifted_book_from_book_shop_info`.`comment` AS `comment`,`gifted_book_from_book_shop_info`.`date_taked` AS `date_taked`,2 AS `account_type` from `gifted_book_from_book_shop_info` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `lended_book_by_book_shop_info`
--

/*!50001 DROP VIEW IF EXISTS `lended_book_by_book_shop_info`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `lended_book_by_book_shop_info` AS select `book_data`.`id` AS `id`,`lended_book`.`email_take` AS `email_take`,`user_take`.`username` AS `username_take`,`lended_book`.`email_lend` AS `email_lend`,`book_shop_lend`.`book_shop_name` AS `username_lend`,`book_data`.`publisher` AS `publisher`,`book_data`.`author` AS `author`,`book_data`.`argument` AS `argument`,`book_data`.`title` AS `title`,`book_data`.`npage` AS `npage`,`book_data`.`comment` AS `comment`,`lended_book`.`date_start` AS `date_taked`,`lended_book`.`date_finish` AS `date_finish` from (((`book_data` join `lended_book` on((`book_data`.`id` = `lended_book`.`id`))) join `users` `user_take` on((`lended_book`.`email_take` = `user_take`.`email`))) join `book_shop` `book_shop_lend` on((`lended_book`.`email_lend` = `book_shop_lend`.`email`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `lended_book_by_user_info`
--

/*!50001 DROP VIEW IF EXISTS `lended_book_by_user_info`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `lended_book_by_user_info` AS select `book_data`.`id` AS `id`,`lended_book`.`email_take` AS `email_take`,`user_take`.`username` AS `username_take`,`lended_book`.`email_lend` AS `email_lend`,`user_lend`.`username` AS `username_lend`,`book_data`.`publisher` AS `publisher`,`book_data`.`author` AS `author`,`book_data`.`argument` AS `argument`,`book_data`.`title` AS `title`,`book_data`.`npage` AS `npage`,`book_data`.`comment` AS `comment`,`lended_book`.`date_start` AS `date_taked`,`lended_book`.`date_finish` AS `date_finish` from (((`book_data` join `lended_book` on((`book_data`.`id` = `lended_book`.`id`))) join `users` `user_take` on((`lended_book`.`email_take` = `user_take`.`email`))) join `users` `user_lend` on((`lended_book`.`email_lend` = `user_lend`.`email`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `lended_book_info`
--

/*!50001 DROP VIEW IF EXISTS `lended_book_info`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `lended_book_info` AS select `lended_book_by_book_shop_info`.`id` AS `id`,`lended_book_by_book_shop_info`.`email_take` AS `email_take`,`lended_book_by_book_shop_info`.`username_take` AS `username_take`,`lended_book_by_book_shop_info`.`email_lend` AS `email_lend`,`lended_book_by_book_shop_info`.`username_lend` AS `username_lend`,`lended_book_by_book_shop_info`.`publisher` AS `publisher`,`lended_book_by_book_shop_info`.`author` AS `author`,`lended_book_by_book_shop_info`.`argument` AS `argument`,`lended_book_by_book_shop_info`.`title` AS `title`,`lended_book_by_book_shop_info`.`npage` AS `npage`,`lended_book_by_book_shop_info`.`comment` AS `comment`,`lended_book_by_book_shop_info`.`date_taked` AS `date_taked`,`lended_book_by_book_shop_info`.`date_finish` AS `date_finish`,2 AS `account_type` from `lended_book_by_book_shop_info` union select `lended_book_by_user_info`.`id` AS `id`,`lended_book_by_user_info`.`email_take` AS `email_take`,`lended_book_by_user_info`.`username_take` AS `username_take`,`lended_book_by_user_info`.`email_lend` AS `email_lend`,`lended_book_by_user_info`.`username_lend` AS `username_lend`,`lended_book_by_user_info`.`publisher` AS `publisher`,`lended_book_by_user_info`.`author` AS `author`,`lended_book_by_user_info`.`argument` AS `argument`,`lended_book_by_user_info`.`title` AS `title`,`lended_book_by_user_info`.`npage` AS `npage`,`lended_book_by_user_info`.`comment` AS `comment`,`lended_book_by_user_info`.`date_taked` AS `date_taked`,`lended_book_by_user_info`.`date_finish` AS `date_finish`,1 AS `account_type` from `lended_book_by_user_info` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `opportunity_info`
--

/*!50001 DROP VIEW IF EXISTS `opportunity_info`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `opportunity_info` AS select `opportunity`.`id` AS `id`,`opportunity`.`email` AS `email`,`book_shop`.`book_shop_name` AS `book_shop_name`,`opportunity`.`type` AS `type_of_opportunity`,`opportunity`.`title` AS `title_of_opportunity`,`opportunity`.`description` AS `description`,`opportunity`.`date_start` AS `date_start`,`opportunity`.`date_finish` AS `date_finish` from (`opportunity` join `book_shop` on((`opportunity`.`email` = `book_shop`.`email`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `user_info`
--

/*!50001 DROP VIEW IF EXISTS `user_info`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `user_info` AS select `users`.`email` AS `email`,`users`.`username` AS `username` from `users` union select `book_shop`.`email` AS `email`,`book_shop`.`book_shop_name` AS `username` from `book_shop` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-17  8:56:55
