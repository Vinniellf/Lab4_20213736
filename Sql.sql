-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema lab4
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `lab4` ;

-- -----------------------------------------------------
-- Schema lab4
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `lab4` DEFAULT CHARACTER SET utf8mb3 ;
USE `lab4` ;

-- -----------------------------------------------------
-- Table `lab4`.`color`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lab4`.`color` ;

CREATE TABLE IF NOT EXISTS `lab4`.`color` (
  `idColor` INT NOT NULL AUTO_INCREMENT,
  `nameColor` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idColor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `lab4`.`ocasion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lab4`.`ocasion` ;

CREATE TABLE IF NOT EXISTS `lab4`.`ocasion` (
  `idOcasion` INT NOT NULL AUTO_INCREMENT,
  `nameOcasion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idOcasion`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `lab4`.`tipo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lab4`.`tipo` ;

CREATE TABLE IF NOT EXISTS `lab4`.`tipo` (
  `idtTipo` INT NOT NULL AUTO_INCREMENT,
  `nameTipo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idtTipo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `lab4`.`flores`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lab4`.`flores` ;

CREATE TABLE IF NOT EXISTS `lab4`.`flores` (
  `idflores` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `imagen` LONGBLOB NOT NULL,
  `precio` DOUBLE NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `color_idcolor` INT NOT NULL,
  `Ocasion_idOcasion` INT NOT NULL,
  `tipo_idtipo` INT NOT NULL,
  PRIMARY KEY (`idflores`),
  CONSTRAINT `fk_flores_color`
    FOREIGN KEY (`color_idcolor`)
    REFERENCES `lab4`.`color` (`idColor`),
  CONSTRAINT `fk_flores_Ocasion1`
    FOREIGN KEY (`Ocasion_idOcasion`)
    REFERENCES `lab4`.`ocasion` (`idOcasion`),
  CONSTRAINT `fk_flores_tipo1`
    FOREIGN KEY (`tipo_idtipo`)
    REFERENCES `lab4`.`tipo` (`idtTipo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
