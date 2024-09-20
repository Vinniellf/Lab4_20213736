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
  `idcolor` INT NOT NULL AUTO_INCREMENT,
  `namecolor` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idcolor`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `lab4`.`ocasion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lab4`.`ocasion` ;

CREATE TABLE IF NOT EXISTS `lab4`.`ocasion` (
  `idocasion` INT NOT NULL AUTO_INCREMENT,
  `nameocasion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idocasion`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `lab4`.`tipo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lab4`.`tipo` ;

CREATE TABLE IF NOT EXISTS `lab4`.`tipo` (
  `idtipo` INT NOT NULL AUTO_INCREMENT,
  `nametipo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idtipo`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `lab4`.`flores`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lab4`.`flores` ;

CREATE TABLE IF NOT EXISTS `lab4`.`flores` (
  `idflores` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `imagen` VARCHAR(500) NOT NULL,
  `precio` DOUBLE NOT NULL,
  `descripcion` VARCHAR(200) NOT NULL,
  `color_idcolor` INT NOT NULL,
  `ocasion_idocasion` INT NOT NULL,
  `tipo_idtipo` INT NOT NULL,
  PRIMARY KEY (`idflores`),
  CONSTRAINT `fk_flores_color`
    FOREIGN KEY (`color_idcolor`)
    REFERENCES `lab4`.`color` (`idcolor`),
  CONSTRAINT `fk_flores_ocasion`
    FOREIGN KEY (`ocasion_idocasion`)
    REFERENCES `lab4`.`ocasion` (`idocasion`),
  CONSTRAINT `fk_flores_tipo1`
    FOREIGN KEY (`tipo_idtipo`)
    REFERENCES `lab4`.`tipo` (`idtipo`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb3;

CREATE INDEX `fk_flores_color` ON `lab4`.`flores` (`color_idcolor` ASC) VISIBLE;

CREATE INDEX `fk_flores_ocasion` ON `lab4`.`flores` (`ocasion_idocasion` ASC) VISIBLE;

CREATE INDEX `fk_flores_tipo1` ON `lab4`.`flores` (`tipo_idtipo` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `lab4`.`puntajes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lab4`.`puntajes` ;

CREATE TABLE IF NOT EXISTS `lab4`.`puntajes` (
  `idpuntajes` INT NOT NULL AUTO_INCREMENT,
  `nickname` VARCHAR(45) NOT NULL,
  `puntajescol` INT NOT NULL,
  PRIMARY KEY (`idpuntajes`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
