--
-- Table structure for table `coronavirus`
--

DROP TABLE IF EXISTS `coronavirus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coronavirus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  `diagnosis` int(11) DEFAULT NULL,
  `overseas_import` int(11) DEFAULT NULL,
  `cure` int(11) DEFAULT NULL,
  `death` int(11) DEFAULT NULL,
  `therapy` int(11) DEFAULT NULL,
  `observation` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coronavirus`
--