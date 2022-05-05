-- MySQL dump 10.13  Distrib 8.0.28, for Linux (x86_64)
--
-- Host: localhost    Database: humandev
-- ------------------------------------------------------
-- Server version	8.0.28-0ubuntu0.20.04.3

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
-- Table structure for table `alternative`
--

DROP TABLE IF EXISTS `alternative`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alternative` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `answer` varchar(255) DEFAULT NULL,
  `answer_check` bit(1) NOT NULL,
  `answer_justification` varchar(255) DEFAULT NULL,
  `ordination` int NOT NULL,
  `question_explanation` varchar(255) DEFAULT NULL,
  `question_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoxl3ycb9i75i3ibkrqquy7h8s` (`question_id`),
  CONSTRAINT `FKoxl3ycb9i75i3ibkrqquy7h8s` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alternative`
--

LOCK TABLES `alternative` WRITE;
/*!40000 ALTER TABLE `alternative` DISABLE KEYS */;
/*!40000 ALTER TABLE `alternative` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `category_description` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `hexa_color` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `ordination` int DEFAULT NULL,
  `study_guide` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,_binary '','Programe nas principais linguagens e plataformas. Iniciantes são bem vindos nos cursos de lógica e JavaScript.','programacao','#00c86f','https://www.alura.com.br/assets/api/formacoes/categorias/512/inovacao-gestao-transparent.png','Programação',1,'study guide'),(2,_binary '','Aprenda Git. Entenda a entrega contínua. Estude Linux. Gerencie servidores na nuvem. Explore o mundo de Internet das coisas e da robótica.','devops','#f16165','https://www.alura.com.br/assets/api/formacoes/categorias/512/devops-transparent.png','DevOps',2,'study guide'),(3,_binary '','business','business','#ff8c2a','https://www.alura.com.br/assets/api/formacoes/categorias/512/inovacao-gestao-transparent.png','Business',5,''),(4,_binary '','science','science','#FFF','https://www.alura.com.br/assets/api/formacoes/categorias/128/data-science.png','Science',6,'muitos estudos'),(5,_binary '','muito html e css','front','#FFA','https://www.alura.com.br/assets/api/formacoes/categorias/128/front-end.png','FrontEnd',11,'estudos');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `course_description` varchar(255) DEFAULT NULL,
  `course_time_hours` int DEFAULT NULL,
  `developed_skills` varchar(255) DEFAULT NULL,
  `instructor` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `target_audience` varchar(255) DEFAULT NULL,
  `subcategory_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7nvhqkx7a103mlbo624cxm6t6` (`subcategory_id`),
  CONSTRAINT `FK7nvhqkx7a103mlbo624cxm6t6` FOREIGN KEY (`subcategory_id`) REFERENCES `subcategory` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (4,_binary '','git-e-github-para','muita informação',6,NULL,'tio Bill','Git e Github ','developers',1),(5,_binary '','java-jpa-consultas-avancadas-performance-modelos-complexos','muita informação',16,NULL,'tio Bill','Java e JPA: Consultas avançadas performance e modelos complexos','developers',1),(6,_binary '','java-introducao-orientacao-objetos','muita informação',8,NULL,'tio Bill','Java OO: Introdução à Orientação a Objetos','Desenvolvedores que estão começando com Java e querem aprender mais sobre OO.',1),(7,_binary '','java-primeiros-passos','muita informação',8,NULL,'tio Bill','Java JRE e JDK: Escreva o seu primeiro código com Eclipse','Desenvolvedores que estão começando com Java e querem aprender mais sobre OO.',1),(8,_binary '','angular','- Conheça todos os comando da CLI do Angular. <br> - Saiba como funcionam as Workspaces no angular.json. <br> - Saiba como o Schematics pode aumentar sua produtividade <br> - Garanta consistência e otimizações para produção com o Builder.',15,NULL,'tio Bill','Angular CLI','developers',2),(9,_binary '','gam','- Conheça todos os comando da CLI do Angular. <br> - Saiba como funcionam as Workspaces no angular.json. <br> - Saiba como o Schematics pode aumentar sua produtividade <br> - Garanta consistência e otimizações para produção com o Builder.',15,NULL,'Silveirinha','Projecting games','developers',6),(10,_binary '','softskils','muito soft',19,NULL,'Maria','SoftSkills','Pessoas',1),(11,_binary '','novo','muito soft',4,NULL,'Maria','novo curso','developers',6),(12,_binary '','test','muita informação',1,NULL,'tio Bill','testando123','1',1),(13,_binary '','sas','muita informação',7,NULL,'tio Bill','sas','developers',7),(14,_binary '','a','d',11,NULL,'d','pppppp','d',1);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `explanation`
--

DROP TABLE IF EXISTS `explanation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `explanation` (
  `id` bigint NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `ordination` int NOT NULL,
  `status` bit(1) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `section_id` bigint DEFAULT NULL,
  `activity_explanation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_g4yaf57vif4vt4gct70mnfqoi` (`section_id`),
  CONSTRAINT `FK_g4yaf57vif4vt4gct70mnfqoi` FOREIGN KEY (`section_id`) REFERENCES `section` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `explanation`
--

LOCK TABLES `explanation` WRITE;
/*!40000 ALTER TABLE `explanation` DISABLE KEYS */;
/*!40000 ALTER TABLE `explanation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profile`
--

DROP TABLE IF EXISTS `profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profile` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profile`
--

LOCK TABLES `profile` WRITE;
/*!40000 ALTER TABLE `profile` DISABLE KEYS */;
INSERT INTO `profile` VALUES (1,'ROLE_STUDENT'),(2,'ROLE_ADMIN');
/*!40000 ALTER TABLE `profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profile_users`
--

DROP TABLE IF EXISTS `profile_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profile_users` (
  `profiles_id` bigint NOT NULL,
  `users_id` bigint NOT NULL,
  KEY `FKjxqbwita6kl7k5d28px39bijl` (`users_id`),
  KEY `FKp1sa7m4q8sduu5cexeqyjry2b` (`profiles_id`),
  CONSTRAINT `FKjxqbwita6kl7k5d28px39bijl` FOREIGN KEY (`users_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKp1sa7m4q8sduu5cexeqyjry2b` FOREIGN KEY (`profiles_id`) REFERENCES `profile` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profile_users`
--

LOCK TABLES `profile_users` WRITE;
/*!40000 ALTER TABLE `profile_users` DISABLE KEYS */;
INSERT INTO `profile_users` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `profile_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `id` bigint NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `ordination` int NOT NULL,
  `status` bit(1) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `section_id` bigint DEFAULT NULL,
  `question_description` varchar(255) DEFAULT NULL,
  `question_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_dyisjpgv8bmnrhy8t72lloed3` (`section_id`),
  CONSTRAINT `FK_dyisjpgv8bmnrhy8t72lloed3` FOREIGN KEY (`section_id`) REFERENCES `section` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `section`
--

DROP TABLE IF EXISTS `section`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `section` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `ordination` int NOT NULL,
  `test_status` bit(1) NOT NULL,
  `course_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoy8uc0ftpivwopwf5ptwdtar0` (`course_id`),
  CONSTRAINT `FKoy8uc0ftpivwopwf5ptwdtar0` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `section`
--

LOCK TABLES `section` WRITE;
/*!40000 ALTER TABLE `section` DISABLE KEYS */;
/*!40000 ALTER TABLE `section` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subcategory`
--

DROP TABLE IF EXISTS `subcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subcategory` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `ordination` int DEFAULT NULL,
  `study_guide` varchar(255) DEFAULT NULL,
  `subcategory_description` varchar(255) DEFAULT NULL,
  `category_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKe4hdbsmrx9bs9gpj1fh4mg0ku` (`category_id`),
  CONSTRAINT `FKe4hdbsmrx9bs9gpj1fh4mg0ku` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subcategory`
--

LOCK TABLES `subcategory` WRITE;
/*!40000 ALTER TABLE `subcategory` DISABLE KEYS */;
INSERT INTO `subcategory` VALUES (1,_binary '','java','Java',1,'guia',NULL,1),(2,_binary '','java-e-persistencia','Java e Persistência',3,'guia',NULL,1),(3,_binary '','php','PHP',2,'guia',NULL,1),(4,_binary '','cobol','COBOL',4,'muitos estudos',NULL,1),(5,_binary '','builds','Builds e Controle de versão',5,'estudos',NULL,2),(6,_binary '','soft','SoftSkills',6,'aleatório',NULL,2),(7,_binary '','a','castegoriateste123',6,'olele',NULL,4),(8,_binary '','p','Program',2,'olar',NULL,4);
/*!40000 ALTER TABLE `subcategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'fabiano@alura','$2a$10$esVY9A3zjete7yeNyw0fNeq0iuwd9l5B2kVLNL9.6VHXMH9e3qqb2'),(2,'admin@alura.com','$2a$10$esVY9A3zjete7yeNyw0fNeq0iuwd9l5B2kVLNL9.6VHXMH9e3qqb2');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `video`
--

DROP TABLE IF EXISTS `video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `video` (
  `id` bigint NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `ordination` int NOT NULL,
  `status` bit(1) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `section_id` bigint DEFAULT NULL,
  `video_description` varchar(255) DEFAULT NULL,
  `video_time` int NOT NULL,
  `video_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_9plr1ju3p20cqby10jdvr0uh5` (`section_id`),
  CONSTRAINT `FK_9plr1ju3p20cqby10jdvr0uh5` FOREIGN KEY (`section_id`) REFERENCES `section` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `video`
--

LOCK TABLES `video` WRITE;
/*!40000 ALTER TABLE `video` DISABLE KEYS */;
/*!40000 ALTER TABLE `video` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-02 15:36:47
