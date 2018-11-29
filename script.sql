-- MySQL dump 10.13  Distrib 8.0.13, for Linux (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `APADRINAR`
--

DROP TABLE IF EXISTS `APADRINAR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `APADRINAR` (
  `NINO_idNen` int(10) NOT NULL,
  `USUARIO_idUsuario` int(10) NOT NULL,
  PRIMARY KEY (`NINO_idNen`,`USUARIO_idUsuario`),
  KEY `fk_NIÑO_has_USUARIO_USUARIO1` (`USUARIO_idUsuario`),
  CONSTRAINT `fk_NIÑO_has_USUARIO_NIÑO1` FOREIGN KEY (`NINO_idNen`) REFERENCES `NINO` (`idnen`),
  CONSTRAINT `fk_NIÑO_has_USUARIO_USUARIO1` FOREIGN KEY (`USUARIO_idUsuario`) REFERENCES `USUARIO` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `APADRINAR`
--

LOCK TABLES `APADRINAR` WRITE;
/*!40000 ALTER TABLE `APADRINAR` DISABLE KEYS */;
INSERT INTO `APADRINAR` VALUES (473829,1000);
/*!40000 ALTER TABLE `APADRINAR` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ASOCIACION`
--

DROP TABLE IF EXISTS `ASOCIACION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ASOCIACION` (
  `Nombre` varchar(500) NOT NULL,
  `Localizacion` varchar(450) DEFAULT NULL,
  PRIMARY KEY (`Nombre`),
  UNIQUE KEY `idAs_UNIQUE` (`Nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ASOCIACION`
--

LOCK TABLES `ASOCIACION` WRITE;
/*!40000 ALTER TABLE `ASOCIACION` DISABLE KEYS */;
INSERT INTO `ASOCIACION` VALUES ('Benito Bashet','Durengo'),('Jose Juan','Fritch');
/*!40000 ALTER TABLE `ASOCIACION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CONTENEDOR`
--

DROP TABLE IF EXISTS `CONTENEDOR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `CONTENEDOR` (
  `idCont` int(10) NOT NULL,
  `paisActual` enum('Espana','Honduras') DEFAULT 'Espana',
  `Enviado` tinyint(4) DEFAULT '0',
  `USUARIO_idUsuario` int(10) NOT NULL,
  PRIMARY KEY (`idCont`,`USUARIO_idUsuario`),
  UNIQUE KEY `idCont_UNIQUE` (`idCont`),
  KEY `fk_CONTENEDOR_USUARIO2` (`USUARIO_idUsuario`),
  CONSTRAINT `fk_CONTENEDOR_USUARIO2` FOREIGN KEY (`USUARIO_idUsuario`) REFERENCES `USUARIO` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CONTENEDOR`
--

LOCK TABLES `CONTENEDOR` WRITE;
/*!40000 ALTER TABLE `CONTENEDOR` DISABLE KEYS */;
INSERT INTO `CONTENEDOR` VALUES (5423,'Honduras',1,1000),(12345,'Espana',0,1001);
/*!40000 ALTER TABLE `CONTENEDOR` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DONACION`
--

DROP TABLE IF EXISTS `DONACION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `DONACION` (
  `idDon` int(10) NOT NULL,
  `Descripcion` varchar(500) DEFAULT NULL,
  `Cantidad` int(8) NOT NULL,
  `Moneda` enum('Lempira','Euro') NOT NULL,
  `GESTION ECONOMICA_idBalance` int(10) NOT NULL,
  `USUARIO_idUsuario` int(10) NOT NULL,
  PRIMARY KEY (`idDon`,`GESTION ECONOMICA_idBalance`),
  UNIQUE KEY `idDon_UNIQUE` (`idDon`),
  UNIQUE KEY `USUARIO_idUsuario_UNIQUE` (`USUARIO_idUsuario`),
  KEY `fk_DONACIÓN_GESTIÓN ECONÓMICA1` (`GESTION ECONOMICA_idBalance`),
  CONSTRAINT `fk_DONACIÓN_GESTIÓN ECONÓMICA1` FOREIGN KEY (`GESTION ECONOMICA_idBalance`) REFERENCES `GestionEconomica` (`idbalance`),
  CONSTRAINT `fk_DONACIÓN_USUARIO1` FOREIGN KEY (`USUARIO_idUsuario`) REFERENCES `USUARIO` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DONACION`
--

LOCK TABLES `DONACION` WRITE;
/*!40000 ALTER TABLE `DONACION` DISABLE KEYS */;
INSERT INTO `DONACION` VALUES (3214,'Donante2',1500,'Lempira',3232435,1000),(3333,'Donante habitual',300,'Euro',114445,1001);
/*!40000 ALTER TABLE `DONACION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GASTO`
--

DROP TABLE IF EXISTS `GASTO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `GASTO` (
  `idGasto` int(10) NOT NULL,
  `Cantidad` int(9) NOT NULL,
  `Moneda` enum('Lempira','Euro') NOT NULL DEFAULT 'Euro',
  `Descripcion` varchar(500) DEFAULT NULL,
  `GESTION ECONOMICA_idBalance` int(10) NOT NULL,
  `USUARIO_idUsuario` int(10) NOT NULL,
  PRIMARY KEY (`idGasto`,`GESTION ECONOMICA_idBalance`,`USUARIO_idUsuario`),
  UNIQUE KEY `idGasto_UNIQUE` (`idGasto`),
  KEY `fk_GASTO_GESTIÓN ECONÓMICA1` (`GESTION ECONOMICA_idBalance`),
  KEY `fk_GASTO_USUARIO2` (`USUARIO_idUsuario`),
  CONSTRAINT `fk_GASTO_GESTIÓN ECONÓMICA1` FOREIGN KEY (`GESTION ECONOMICA_idBalance`) REFERENCES `GestionEconomica` (`idbalance`),
  CONSTRAINT `fk_GASTO_USUARIO2` FOREIGN KEY (`USUARIO_idUsuario`) REFERENCES `USUARIO` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GASTO`
--

LOCK TABLES `GASTO` WRITE;
/*!40000 ALTER TABLE `GASTO` DISABLE KEYS */;
INSERT INTO `GASTO` VALUES (7859,2300,'Euro','Evento1',114445,1001),(36274,1100,'Lempira','MaterialesDiego',3232435,1000);
/*!40000 ALTER TABLE `GASTO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GestionEconomica`
--

DROP TABLE IF EXISTS `GestionEconomica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `GestionEconomica` (
  `idBalance` int(10) NOT NULL,
  `balanceTotal` int(9) NOT NULL,
  PRIMARY KEY (`idBalance`),
  UNIQUE KEY `idBalance_UNIQUE` (`idBalance`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GestionEconomica`
--

LOCK TABLES `GestionEconomica` WRITE;
/*!40000 ALTER TABLE `GestionEconomica` DISABLE KEYS */;
INSERT INTO `GestionEconomica` VALUES (114445,-3500),(3232435,2400);
/*!40000 ALTER TABLE `GestionEconomica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `NINO`
--

DROP TABLE IF EXISTS `NINO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `NINO` (
  `idNen` int(10) NOT NULL,
  `Edad` int(2) NOT NULL,
  `Notas` enum('0','1','2','3','4','5','6','7','8','9','10') DEFAULT NULL,
  `PROYECTO_idProy` int(10) NOT NULL,
  PRIMARY KEY (`idNen`),
  UNIQUE KEY `idNen_UNIQUE` (`idNen`),
  KEY `fk_NINO_PROYECTO1` (`PROYECTO_idProy`),
  CONSTRAINT `fk_NINO_PROYECTO1` FOREIGN KEY (`PROYECTO_idProy`) REFERENCES `PROYECTO` (`idproy`),
  CONSTRAINT `idPersNen` FOREIGN KEY (`idNen`) REFERENCES `PERSONA` (`idpersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `NINO`
--

LOCK TABLES `NINO` WRITE;
/*!40000 ALTER TABLE `NINO` DISABLE KEYS */;
INSERT INTO `NINO` VALUES (473829,9,'8',101),(43644984,10,'3',101);
/*!40000 ALTER TABLE `NINO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `OBJETO`
--

DROP TABLE IF EXISTS `OBJETO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `OBJETO` (
  `idObjeto` int(10) NOT NULL,
  `Descripcion` varchar(500) NOT NULL DEFAULT 'Objetos',
  `Pais` enum('Espana','Honduras') NOT NULL DEFAULT 'Espana',
  `Localizacion` varchar(500) NOT NULL DEFAULT 'Espana',
  `CONTENEDOR_idCont` int(10) NOT NULL,
  `USUARIO_idUsuario` int(10) NOT NULL,
  PRIMARY KEY (`idObjeto`,`CONTENEDOR_idCont`),
  UNIQUE KEY `idObjeto_UNIQUE` (`idObjeto`),
  KEY `fk_OBJETO_CONTENEDOR1` (`CONTENEDOR_idCont`),
  KEY `fk_OBJETO_USUARIO2` (`USUARIO_idUsuario`),
  CONSTRAINT `fk_OBJETO_CONTENEDOR1` FOREIGN KEY (`CONTENEDOR_idCont`) REFERENCES `CONTENEDOR` (`idcont`),
  CONSTRAINT `fk_OBJETO_USUARIO2` FOREIGN KEY (`USUARIO_idUsuario`) REFERENCES `USUARIO` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `OBJETO`
--

LOCK TABLES `OBJETO` WRITE;
/*!40000 ALTER TABLE `OBJETO` DISABLE KEYS */;
INSERT INTO `OBJETO` VALUES (26332,'Objeto1','Espana','Antequera',12345,1001),(26484,'Objeto2','Honduras','Jret',5423,1000);
/*!40000 ALTER TABLE `OBJETO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PERMISO`
--

DROP TABLE IF EXISTS `PERMISO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `PERMISO` (
  `ID` int(10) NOT NULL,
  `Descripcion` varchar(500) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PERMISO`
--

LOCK TABLES `PERMISO` WRITE;
/*!40000 ALTER TABLE `PERMISO` DISABLE KEYS */;
INSERT INTO `PERMISO` VALUES (1,'ADMIN'),(2,'USUARIO');
/*!40000 ALTER TABLE `PERMISO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PERSONA`
--

DROP TABLE IF EXISTS `PERSONA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `PERSONA` (
  `idPersona` int(10) NOT NULL,
  `Nombre` varchar(25) NOT NULL,
  `Apellidos` varchar(45) NOT NULL,
  `Direccion` varchar(45) NOT NULL,
  `Pueblo` varchar(45) NOT NULL,
  PRIMARY KEY (`idPersona`),
  UNIQUE KEY `idPersona_UNIQUE` (`idPersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PERSONA`
--

LOCK TABLES `PERSONA` WRITE;
/*!40000 ALTER TABLE `PERSONA` DISABLE KEYS */;
INSERT INTO `PERSONA` VALUES (1000,'Dimitri','Vetrov','Colegio Vicente Shrot','Fritch'),(1001,'Francisco','Jonasio','Calle Cersh N3','Calatchka');
/*!40000 ALTER TABLE `PERSONA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PROYECTO`
--

DROP TABLE IF EXISTS `PROYECTO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `PROYECTO` (
  `idProy` int(10) NOT NULL,
  `tipoProy` enum('CCJ','CasaPopulorum') NOT NULL DEFAULT 'CasaPopulorum',
  `refPais` enum('Espana','Honduras') NOT NULL,
  `Descripcion` varchar(500) NOT NULL,
  `Localizacion` varchar(500) NOT NULL,
  `Acabado` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idProy`),
  UNIQUE KEY `idProy_UNIQUE` (`idProy`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PROYECTO`
--

LOCK TABLES `PROYECTO` WRITE;
/*!40000 ALTER TABLE `PROYECTO` DISABLE KEYS */;
INSERT INTO `PROYECTO` VALUES (100,'CCJ','Honduras','CCJ Alberto Shret','Chikret',1),(101,'CasaPopulorum','Honduras','CP Bonifracio Shish','Karat',0);
/*!40000 ALTER TABLE `PROYECTO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ROL`
--

DROP TABLE IF EXISTS `ROL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ROL` (
  `idRol` int(10) NOT NULL,
  `Nombre` varchar(500) NOT NULL,
  `Pais` enum('Espana','Honduras') NOT NULL DEFAULT 'Espana',
  `Descripcion` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`idRol`),
  UNIQUE KEY `Nombre_UNIQUE` (`Nombre`),
  UNIQUE KEY `idRol_UNIQUE` (`idRol`),
  CONSTRAINT `refIdProy` FOREIGN KEY (`idRol`) REFERENCES `PROYECTO` (`idproy`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ROL`
--

LOCK TABLES `ROL` WRITE;
/*!40000 ALTER TABLE `ROL` DISABLE KEYS */;
INSERT INTO `ROL` VALUES (21,'ADMIN','Espana','Todos los permisos'),(22,'SOCIO','Espana','Uso estandar');
/*!40000 ALTER TABLE `ROL` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ResponsableDe`
--

DROP TABLE IF EXISTS `ResponsableDe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ResponsableDe` (
  `USUARIO_idUsuario` int(10) NOT NULL,
  `PROYECTO_idProy` int(10) NOT NULL,
  PRIMARY KEY (`USUARIO_idUsuario`,`PROYECTO_idProy`),
  KEY `fk_USUARIO_has_PROYECTO_PROYECTO1` (`PROYECTO_idProy`),
  CONSTRAINT `fk_USUARIO_has_PROYECTO_PROYECTO1` FOREIGN KEY (`PROYECTO_idProy`) REFERENCES `PROYECTO` (`idproy`),
  CONSTRAINT `fk_USUARIO_has_PROYECTO_USUARIO1` FOREIGN KEY (`USUARIO_idUsuario`) REFERENCES `USUARIO` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ResponsableDe`
--

LOCK TABLES `ResponsableDe` WRITE;
/*!40000 ALTER TABLE `ResponsableDe` DISABLE KEYS */;
INSERT INTO `ResponsableDe` VALUES (1000,101);
/*!40000 ALTER TABLE `ResponsableDe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RolesPermisos`
--

DROP TABLE IF EXISTS `RolesPermisos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `RolesPermisos` (
  `PERMISO_ID` int(10) NOT NULL,
  `ROL_idRol` int(10) NOT NULL,
  PRIMARY KEY (`PERMISO_ID`,`ROL_idRol`),
  UNIQUE KEY `PERMISO_ID_UNIQUE` (`PERMISO_ID`),
  UNIQUE KEY `ROL_idRol_UNIQUE` (`ROL_idRol`),
  CONSTRAINT `fk_PERMISO_has_ROL_PERMISO1` FOREIGN KEY (`PERMISO_ID`) REFERENCES `PERMISO` (`id`),
  CONSTRAINT `fk_PERMISO_has_ROL_ROL1` FOREIGN KEY (`ROL_idRol`) REFERENCES `ROL` (`idrol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RolesPermisos`
--

LOCK TABLES `RolesPermisos` WRITE;
/*!40000 ALTER TABLE `RolesPermisos` DISABLE KEYS */;
INSERT INTO `RolesPermisos` VALUES (1,21),(2,22);
/*!40000 ALTER TABLE `RolesPermisos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USUARIO`
--

DROP TABLE IF EXISTS `USUARIO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `USUARIO` (
  `idUsuario` int(10) NOT NULL,
  `Contrasenya` varchar(500) NOT NULL,
  `Correo` varchar(600) NOT NULL,
  `ASOCIACION_Nombre` varchar(500) NOT NULL,
  `ROL_idRol` int(10) NOT NULL,
  PRIMARY KEY (`idUsuario`,`ROL_idRol`),
  UNIQUE KEY `idUsuario_UNIQUE` (`idUsuario`),
  KEY `fk_USUARIO_ASOCIACIÓN1` (`ASOCIACION_Nombre`),
  CONSTRAINT `fk_USUARIO_ASOCIACIÓN1` FOREIGN KEY (`ASOCIACION_Nombre`) REFERENCES `ASOCIACION` (`nombre`),
  CONSTRAINT `fk_USUARIO_ROL1` FOREIGN KEY (`idUsuario`) REFERENCES `ROL` (`idrol`),
  CONSTRAINT `idPersUs` FOREIGN KEY (`idUsuario`) REFERENCES `PERSONA` (`idpersona`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USUARIO`
--

LOCK TABLES `USUARIO` WRITE;
/*!40000 ALTER TABLE `USUARIO` DISABLE KEYS */;
INSERT INTO `USUARIO` VALUES (1000,'admin','admin@correo.es','Benito Bashet',21),(1001,'usuario','usuario@correo.es','Jose Juan',22);
/*!40000 ALTER TABLE `USUARIO` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-29 10:26:44
