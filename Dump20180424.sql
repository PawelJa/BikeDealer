CREATE DATABASE  IF NOT EXISTS `bikedealer` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bikedealer`;
-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: localhost    Database: bikedealer
-- ------------------------------------------------------
-- Server version	5.7.21-0ubuntu0.16.04.1

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
-- Table structure for table `bike_dealers`
--

DROP TABLE IF EXISTS `bike_dealers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bike_dealers` (
  `bike_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `postcode` varchar(255) NOT NULL,
  PRIMARY KEY (`bike_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bike_dealers`
--

LOCK TABLES `bike_dealers` WRITE;
/*!40000 ALTER TABLE `bike_dealers` DISABLE KEYS */;
INSERT INTO `bike_dealers` VALUES (1,'Gorna 5','Szklarska Poreba','Wypozyczalnia1','11-204'),(2,'Szeroka 12','Swieradow','Rider','77-204'),(3,'Wysoka 1','Karpacz','Rental','37-911'),(4,'Dolna 1','Zakopane','Wypozyczalnia4','10-100');
/*!40000 ALTER TABLE `bike_dealers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bike_dealers_bike_list`
--

DROP TABLE IF EXISTS `bike_dealers_bike_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bike_dealers_bike_list` (
  `bike_dealer_bike_id` bigint(20) NOT NULL,
  `bike_list_bike_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_t3l6owe8aa5b767gpdyvnsuuo` (`bike_list_bike_id`),
  KEY `FKg8md0cmll5oxqtb7mruux8t5d` (`bike_dealer_bike_id`),
  CONSTRAINT `FKbcoxto0p6qmmjfngsakcfok73` FOREIGN KEY (`bike_list_bike_id`) REFERENCES `bikes` (`bike_id`),
  CONSTRAINT `FKg8md0cmll5oxqtb7mruux8t5d` FOREIGN KEY (`bike_dealer_bike_id`) REFERENCES `bike_dealers` (`bike_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bike_dealers_bike_list`
--

LOCK TABLES `bike_dealers_bike_list` WRITE;
/*!40000 ALTER TABLE `bike_dealers_bike_list` DISABLE KEYS */;
INSERT INTO `bike_dealers_bike_list` VALUES (1,5),(1,7),(1,8),(2,1),(2,10),(2,11),(2,12),(2,14),(2,17),(4,3);
/*!40000 ALTER TABLE `bike_dealers_bike_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bikes`
--

DROP TABLE IF EXISTS `bikes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bikes` (
  `bike_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `brand` varchar(255) NOT NULL,
  `breaks` varchar(255) NOT NULL,
  `gears` varchar(255) NOT NULL,
  `model` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `status` varchar(255) NOT NULL,
  `sus_front` varchar(255) NOT NULL,
  `sus_rear` varchar(255) NOT NULL,
  `sus_type` varchar(255) NOT NULL,
  `wheel_size` double NOT NULL,
  PRIMARY KEY (`bike_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bikes`
--

LOCK TABLES `bikes` WRITE;
/*!40000 ALTER TABLE `bikes` DISABLE KEYS */;
INSERT INTO `bikes` VALUES (1,'Steppenwolf','Shimano SLX','Shimano XT','Tyler Race',6699,'available','RockShox Reba RL 120mm, black','RockShox Monarch RT3 120mm','Full',29),(2,'Specialized','Przedni hamulec Shimano BR-M315, hydraulic disc, resin pads, 180/160mm rotor / Tylny hamulec Shimano BR-M315, hydraulic disc, resin pads, 160mm rotor','Tylna przerzutka Shimano Acera 8-speed','Rockhopper Sport',2399,'available','SR Suntour XCT w/ MCD 29, coil spring, custom Multi-Circuit damping, QR, 80/90/100mm travel (size-specific), 51mm offset','brak','Hardtail',29),(3,'Kross','AVID DB1 (HYDRAULICZNY, TARCZA 160MM-S, M, 180/160MM-L)','SHIMANO SLX RD-M7000 SGS','Level R9 2016',5399,'available','ROCK SHOX XC30 TK COIL (SKOK 100MM, BLOKADA SKOKU)','brak','Hardtail',27.5),(4,'Kross','Przedni hamulec Shimano BR-M315, hydraulic disc, resin pads, 180/160mm rotor / Tylny hamulec Shimano BR-M315, hydraulic disc, resin pads, 160mm rotor','Shimano SLX RD-M7000','Dust 2.0',5999,'available','Rock Shox Recon RL (skok 120mm, blokada na koronie, 15x110mm, Boost, Tapered)','brak','Hardtail',27.5),(5,'Kross','SRAM Level TL (tarczowy, hydrauliczny)','SRAM GX','Dust 3.0',7999,'available','Rock Shox Reba RL (skok 140mm, blokada na koronie,15x100mm, Tapered)','brak','Hardtail',27.5),(6,'Kross','SRAM Level TL (tarczowy, hydrauliczny)','SRAM GX','Dust 3.0',7299,'reserved','Rock Shox Reba RL (skok 140mm, blokada na koronie,15x100mm, Tapered)','brak','Hardtail',26),(7,'Trek','Hydrauliczne hamulce tarczowe Shimano M315','Shimano Acera M3000, Shadow','X-Caliber 7',3199,'available','RockShox 30 Silver ze spr??yn?, wst?pne napr??enie, blokada TurnKey, geometria G','brak','Hardtail',26),(8,'Specialized','Przedni hamulec SRAM Level TL disc lever/caliper, organic pads, 200/180mm rotors / Tylny hamulec SRAM Level TL disc lever/caliper, organic pads, 180/160mm rotors','Tylna przerzutka SRAM GX, long cage','Camber Comp Carbon 29 – 1X',17099,'available','RockShox Reba RL 29, tapered alloy steerer, 51mm offset, external rebound adjust, low speed comp to lockout, custom 15mm Maxle® Stealth thru-axle, 120mm of travel','FOX FLOAT Performance, Rx Trail Tune, AUTOSAG, DPS damper, rebound and 3-position compression adjust, 205x53mm','Full',29),(9,'Trek','Przedni hamulec SRAM Level TL disc lever/caliper, organic pads, 200/180mm rotors / Tylny hamulec SRAM Level TL disc lever/caliper, organic pads, 180/160mm rotors','Shimano Deore M6000, Shadow Plus','Fuel EX 5 27.5 Plus',8299,'available','RockShox Recon Silver, spr??yna Solo Air, t?umienie Motion Control, zw??ana rura','FOX FLOAT Performance, Rx Trail Tune, AUTOSAG, DPS damper, rebound and 3-position compression adjust, 205x53mm','Full',27.5),(10,'Trek','Przedni hamulec SRAM Level TL disc lever/caliper, organic pads, 200/180mm rotors / Tylny hamulec SRAM Level TL disc lever/caliper, organic pads, 180/160mm rotors','Shimano Deore M6000, Shadow Plus','Fuel EX 5 27.5 Plus',8999,'available','RockShox Recon Silver, spr??yna Solo Air, t?umienie Motion Control, zw??ana rura','FOX FLOAT Performance, Rx Trail Tune, AUTOSAG, DPS damper, rebound and 3-position compression adjust, 205x53mm','Full',29),(11,'Kross','Shimano Disc BR-M395 (tarczowy, hydrauliczny)','Shimano Deore FD-M6020','Soil 1.0',7899,'available','Rock Shox Recon RL Solo Air (skok 130mm, blokada na koronie, 15x110mm Boost, Tapered)','FOX FLOAT Performance, Rx Trail Tune','Full',26),(12,'Specialized','Przedni hamulec SRAM Level Ultimate disc lever/caliper, organic pads, 200/180mm rotors / Tylny hamulec SRAM Level Ultimate disc lever/caliper, organic pads, 200/180mm rotors','Tylna przerzutka SRAM XX1 Eagle™','S-Works Camber',32469,'available','FOX 34 Factory 29, Kashima coating, 3-position adjust, compression and rebound adjust, 51mm offset, 15x100mm thru-axle, 120mm travel','FOX FLOAT Factory, Rx Trail Tune, AUTOSAG, DPS damper, Kashima coating, rebound and 3-position compression adjust, 205x53mm','Full',26),(13,'Kross','SRAM Level T (tarczowy, hydrauliczny)','SRAM NX','Soil 2.0',10669,'reserved','Rock Shox Reba RL Solo Air (skok 130mm, blokada na koronie, 15x110mm Boost, Tapered)','FOX FLOAT Factory, Rx Trail Tune','Full',26),(14,'NS Bikes','Sram Guide RS, 200mm','Sram X01 EAGLE Type 3 12spd','Snabb 160 C1',10669,'reserved','Fox Factory 36 Float FIT RC2, 170mm travel, KASHIMA, HSC, LSC, 1.5” T steerer, 15QRx110, 44 offset','Fox Factory Float DPX2 3pos-Adj, Trunnion Evol LV 205x65, tuned by Fox x NS Suspension Lab','Full',27.5),(15,'NS Bikes','Sram Level, 180mm','Sram X01 EAGLE Type 3 12spd','Snabb 130 Plus 2',11899,'available','Fox Performance 34 Rhythm Grip, 140mm skoku, Sweep Adj, 1.5” T” steerer, 15QRx110, 51 offset','Fox Performance Float 3pos-Adj, Trunnion Evol LV 185x55, tuned by Fox x NS Suspension Lab','Full',27.5),(16,'Ghost','Shimano BR-M315 2/2 Piston 160 mm Disc','Shimano XT RD-M772 9-S','Kato 5.9 AL 2018',3419,'available','ROCK SHOX 30 SILVER TK 29 100 mm','brak','Hardtail',29),(17,'NS Bikes','Shimano BR-M315 2/2 Piston 160 mm Disc','Shimano XT RD-M772','Clash 2018',2999,'available','Rock Shox Recon RL (skok 140mm, blokada na koronie, 15x100mm, Tapered)','brak','Hardtail',26),(18,'Ghost','Shimano XT BR-M8000 2/2 Piston 180/160 mm Disc','Shimano XT RD-M8000 Shadow Plus 11-S','Kato 9.9 AL 2018',5549,'available','Rock Shox 30 Silver Poploc 100 mm','brak','Hardtail',29);
/*!40000 ALTER TABLE `bikes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `books` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'test3Cat2','Test3');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `full_name` varchar(100) NOT NULL,
  `role` varchar(50) NOT NULL,
  `country` varchar(100) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('mod','$2a$10$N0eqNiuikWCy9ETQ1rdau.XEELcyEO7kukkfoiNISk/9F7gw6eB0W','Mod Erator','ROLE_MOD','Poland',1),('admin','$2a$10$N0eqNiuikWCy9ETQ1rdau.XEELcyEO7kukkfoiNISk/9F7gw6eB0W','Add Ministrator','ROLE_ADMIN','USA',1),('user','$2a$10$QifQnP.XqXDW0Lc4hSqEg.GhTqZHoN2Y52/hoWr4I5ePxK7D2Pi8q','U Ser','ROLE_USER','UK',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-24 17:01:23
