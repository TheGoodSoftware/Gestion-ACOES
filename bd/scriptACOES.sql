-- MySQL Script generated by MySQL Workbench
-- Tue Jan  8 19:20:53 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`apadrinar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`apadrinar` (
  `NINO_idNen` INT(10) NOT NULL,
  `Activo` TINYINT(4) NOT NULL DEFAULT '1',
  `USUARIO_idUsuario` INT(10) NOT NULL,
  `Cuota` INT(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`NINO_idNen`, `USUARIO_idUsuario`),
  INDEX `fk_NIÑO_has_USUARIO_USUARIO1` (`USUARIO_idUsuario` ASC),
  CONSTRAINT `fk_NIÑO_has_USUARIO_NIÑO1`
    FOREIGN KEY (`NINO_idNen`)
    REFERENCES `mydb`.`nino` (`idNen`),
  CONSTRAINT `fk_NIÑO_has_USUARIO_USUARIO1`
    FOREIGN KEY (`USUARIO_idUsuario`)
    REFERENCES `mydb`.`usuario` (`idUsuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mydb`.`asociacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`asociacion` (
  `Nombre` VARCHAR(500) NOT NULL,
  `Localizacion` VARCHAR(450) NULL DEFAULT NULL,
  PRIMARY KEY (`Nombre`),
  UNIQUE INDEX `idAs_UNIQUE` (`Nombre` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mydb`.`contenedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`contenedor` (
  `idCont` INT(10) NOT NULL,
  `paisActual` VARCHAR(500) NULL DEFAULT 'Espana',
  `Enviado` TINYINT(4) NULL DEFAULT '0',
  `USUARIO_idUsuario` INT(10) NOT NULL,
  PRIMARY KEY (`idCont`, `USUARIO_idUsuario`),
  UNIQUE INDEX `idCont_UNIQUE` (`idCont` ASC),
  INDEX `fk_CONTENEDOR_USUARIO2` (`USUARIO_idUsuario` ASC),
  CONSTRAINT `fk_CONTENEDOR_USUARIO2`
    FOREIGN KEY (`USUARIO_idUsuario`)
    REFERENCES `mydb`.`usuario` (`idUsuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mydb`.`donacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`donacion` (
  `idDon` INT(10) NOT NULL,
  `Cantidad` DOUBLE NOT NULL,
  `Moneda` VARCHAR(500) NOT NULL DEFAULT 'Euro',
  `Descripcion` VARCHAR(500) NULL DEFAULT NULL,
  `Fecha` VARCHAR(10) NOT NULL,
  `ProcedenciaBeneficiario` VARCHAR(100) NOT NULL DEFAULT '-',
  `GESTIONECONOMICA_idBalance` INT(10) NOT NULL,
  PRIMARY KEY (`idDon`, `GESTIONECONOMICA_idBalance`),
  UNIQUE INDEX `idDon_UNIQUE` (`idDon` ASC),
  INDEX `fk_DONACIÓN_GESTIÓNECONÓMICA1` (`GESTIONECONOMICA_idBalance` ASC),
  CONSTRAINT `fk_DONACIÓN_GESTIÓNECONÓMICA1`
    FOREIGN KEY (`GESTIONECONOMICA_idBalance`)
    REFERENCES `mydb`.`gestionEconomica` (`idBalance`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mydb`.`gasto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`gasto` (
  `idGasto` INT(10) NOT NULL,
  `Cantidad` DOUBLE NOT NULL,
  `Moneda` VARCHAR(500) NOT NULL DEFAULT 'Euro',
  `Descripcion` VARCHAR(500) NULL DEFAULT NULL,
  `Fecha` VARCHAR(10) NOT NULL,
  `ProcedenciaBeneficiario` VARCHAR(100) NOT NULL DEFAULT '-',
  `GESTIONECONOMICA_idBalance` INT(10) NOT NULL,
  PRIMARY KEY (`idGasto`, `GESTIONECONOMICA_idBalance`),
  UNIQUE INDEX `idGasto_UNIQUE` (`idGasto` ASC),
  INDEX `fk_GASTO_GESTIÓNECONÓMICA1` (`GESTIONECONOMICA_idBalance` ASC),
  CONSTRAINT `fk_GASTO_GESTIÓNECONÓMICA1`
    FOREIGN KEY (`GESTIONECONOMICA_idBalance`)
    REFERENCES `mydb`.`gestionEconomica` (`idBalance`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mydb`.`gestionEconomica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`gestionEconomica` (
  `idBalance` INT(10) NOT NULL,
  `balanceTotal` DOUBLE NOT NULL,
  PRIMARY KEY (`idBalance`),
  UNIQUE INDEX `idBalance_UNIQUE` (`idBalance` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mydb`.`nino`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`nino` (
  `idNen` INT(10) NOT NULL,
  `Edad` INT(2) NOT NULL,
  `PROYECTO_idProy` INT(10) NOT NULL,
  PRIMARY KEY (`idNen`),
  UNIQUE INDEX `idNen_UNIQUE` (`idNen` ASC),
  INDEX `fk_NINO_PROYECTO1` (`PROYECTO_idProy` ASC),
  CONSTRAINT `fk_NINO_PROYECTO1`
    FOREIGN KEY (`PROYECTO_idProy`)
    REFERENCES `mydb`.`proyecto` (`idProy`),
  CONSTRAINT `idPersNen`
    FOREIGN KEY (`idNen`)
    REFERENCES `mydb`.`persona` (`idPersona`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mydb`.`notas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`notas` (
  `idNotasNen` INT(10) NOT NULL,
  `Calificacion` DOUBLE NOT NULL DEFAULT 5,
  `NotaMedia` DOUBLE NOT NULL DEFAULT 5,
  `Curso` VARCHAR(500) NOT NULL DEFAULT 'Primaria',
  `nino_idNen` INT(10) NOT NULL,
  PRIMARY KEY (`idNotasNen`),
  UNIQUE INDEX `idNotasNen_UNIQUE` (`idNotasNen` ASC),
  INDEX `fk_notas_nino1_idx` (`nino_idNen` ASC),
  CONSTRAINT `fk_notas_nino1`
    FOREIGN KEY (`nino_idNen`)
    REFERENCES `mydb`.`nino` (`idNen`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mydb`.`objeto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`objeto` (
  `idObjeto` INT(10) NOT NULL,
  `Descripcion` VARCHAR(500) NOT NULL DEFAULT 'Objetos',
  `Pais` VARCHAR(500) NOT NULL DEFAULT 'Espana',
  `Localizacion` VARCHAR(500) NOT NULL DEFAULT 'Espana',
  `CONTENEDOR_idCont` INT(10) NOT NULL,
  `USUARIO_idUsuario` INT(10) NOT NULL,
  PRIMARY KEY (`idObjeto`, `CONTENEDOR_idCont`),
  UNIQUE INDEX `idObjeto_UNIQUE` (`idObjeto` ASC),
  INDEX `fk_OBJETO_CONTENEDOR1` (`CONTENEDOR_idCont` ASC),
  INDEX `fk_OBJETO_USUARIO2` (`USUARIO_idUsuario` ASC),
  CONSTRAINT `fk_OBJETO_CONTENEDOR1`
    FOREIGN KEY (`CONTENEDOR_idCont`)
    REFERENCES `mydb`.`contenedor` (`idCont`),
  CONSTRAINT `fk_OBJETO_USUARIO2`
    FOREIGN KEY (`USUARIO_idUsuario`)
    REFERENCES `mydb`.`usuario` (`idUsuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mydb`.`permiso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`permiso` (
  `ID` INT(10) NOT NULL,
  `Descripcion` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mydb`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`persona` (
  `idPersona` INT(10) NOT NULL,
  `Nombre` VARCHAR(25) NOT NULL,
  `Apellidos` VARCHAR(45) NOT NULL,
  `Direccion` VARCHAR(45) NOT NULL,
  `Pueblo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPersona`),
  UNIQUE INDEX `idPersona_UNIQUE` (`idPersona` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mydb`.`proyecto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`proyecto` (
  `idProy` INT(10) NOT NULL,
  `tipoProy` VARCHAR(500) NOT NULL DEFAULT 'CasaPopulorum',
  `refPais` VARCHAR(500) NOT NULL DEFAULT 'Espana',
  `Descripcion` VARCHAR(500) NOT NULL,
  `Localizacion` VARCHAR(500) NOT NULL,
  `Acabado` TINYINT(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idProy`),
  UNIQUE INDEX `idProy_UNIQUE` (`idProy` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mydb`.`responsableDe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`responsableDe` (
  `USUARIO_idUsuario` INT(10) NOT NULL,
  `PROYECTO_idProy` INT(10) NOT NULL,
  PRIMARY KEY (`USUARIO_idUsuario`, `PROYECTO_idProy`),
  INDEX `fk_USUARIO_has_PROYECTO_PROYECTO1` (`PROYECTO_idProy` ASC),
  CONSTRAINT `fk_USUARIO_has_PROYECTO_PROYECTO1`
    FOREIGN KEY (`PROYECTO_idProy`)
    REFERENCES `mydb`.`proyecto` (`idProy`),
  CONSTRAINT `fk_USUARIO_has_PROYECTO_USUARIO1`
    FOREIGN KEY (`USUARIO_idUsuario`)
    REFERENCES `mydb`.`usuario` (`idUsuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mydb`.`rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`rol` (
  `idRol` INT(10) NOT NULL,
  `Nombre` VARCHAR(500) NOT NULL,
  `Pais` VARCHAR(500) NOT NULL DEFAULT 'Espana',
  `Descripcion` VARCHAR(500) NULL DEFAULT NULL,
  PRIMARY KEY (`idRol`),
  UNIQUE INDEX `Nombre_UNIQUE` (`Nombre` ASC),
  UNIQUE INDEX `idRol_UNIQUE` (`idRol` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mydb`.`rolesPermisos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`rolesPermisos` (
  `PERMISO_ID` INT(10) NOT NULL,
  `ROL_idRol` INT(10) NOT NULL,
  PRIMARY KEY (`PERMISO_ID`, `ROL_idRol`),
  UNIQUE INDEX `PERMISO_ID_UNIQUE` (`PERMISO_ID` ASC),
  INDEX `fk_PERMISO_has_ROL_ROL1` (`ROL_idRol` ASC),
  CONSTRAINT `fk_PERMISO_has_ROL_PERMISO1`
    FOREIGN KEY (`PERMISO_ID`)
    REFERENCES `mydb`.`permiso` (`ID`),
  CONSTRAINT `fk_PERMISO_has_ROL_ROL1`
    FOREIGN KEY (`ROL_idRol`)
    REFERENCES `mydb`.`rol` (`idRol`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mydb`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`usuario` (
  `idUsuario` INT(10) NOT NULL,
  `Contrasenya` VARCHAR(500) NOT NULL,
  `Correo` VARCHAR(600) NOT NULL,
  `ASOCIACION_Nombre` VARCHAR(500) NOT NULL,
  `ROL_idRol` INT(10) NOT NULL,
  PRIMARY KEY (`idUsuario`, `ROL_idRol`),
  UNIQUE INDEX `idUsuario_UNIQUE` (`idUsuario` ASC),
  INDEX `fk_USUARIO_ASOCIACIÓN1` (`ASOCIACION_Nombre` ASC),
  CONSTRAINT `fk_USUARIO_ASOCIACIÓN1`
    FOREIGN KEY (`ASOCIACION_Nombre`)
    REFERENCES `mydb`.`asociacion` (`Nombre`),
  CONSTRAINT `fk_USUARIO_ROL1`
    FOREIGN KEY (`ROL_idRol`)
    REFERENCES `mydb`.`rol` (`idRol`),
  CONSTRAINT `idPersUs`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `mydb`.`persona` (`idPersona`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
