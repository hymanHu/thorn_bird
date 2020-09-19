--
-- Table structure for table `university`
--

DROP TABLE IF EXISTS `university`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `university` (
  `id` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `school_name` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `type` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `level` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `nature` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `belong` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `central` int(11) DEFAULT NULL,
  `department` int(11) DEFAULT NULL,
  `doublehigh` int(1) DEFAULT NULL,
  `f211` int(1) DEFAULT NULL,
  `f985` int(1) DEFAULT NULL,
  `is_recruitment` int(1) DEFAULT NULL,
  `dual_class` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `province_name` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `single_province` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `city_name` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `county_name` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `view_total_number` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `university`
--