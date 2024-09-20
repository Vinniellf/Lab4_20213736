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
DEFAULT CHARACTER SET = utf8mb3;

--
-- Dumping data for table `color`
--

LOCK TABLES `color` WRITE;
/*!40000 ALTER TABLE `color` DISABLE KEYS */;
INSERT INTO `color` VALUES (1,'Rojas'),(2,'Verdes'),(3,'Azules'), (4, 'Blancos'), (5, 'Amarillos');
/*!40000 ALTER TABLE `color` ENABLE KEYS */;
UNLOCK TABLES;


-- -----------------------------------------------------
-- Table `lab4`.`ocasion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lab4`.`ocasion` ;

CREATE TABLE IF NOT EXISTS `lab4`.`ocasion` (
  `idocasion` INT NOT NULL AUTO_INCREMENT,
  `nameocasion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idocasion`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

--
-- Dumping data for table `ocasion`
--

LOCK TABLES `ocasion` WRITE;
/*!40000 ALTER TABLE `ocasion` DISABLE KEYS */;
INSERT INTO `ocasion` VALUES (1,'Primavera'),(2,'San Valentín'),(3,'Aniversario'), (4, 'Día de la amistad'), (5, 'Día del Padre'), (6, 'Dìa de la Madre'), (7, 'Condolencias');
/*!40000 ALTER TABLE `ocasion` ENABLE KEYS */;
UNLOCK TABLES;


-- -----------------------------------------------------
-- Table `lab4`.`tipo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lab4`.`tipo` ;

CREATE TABLE IF NOT EXISTS `lab4`.`tipo` (
  `idtipo` INT NOT NULL AUTO_INCREMENT,
  `nametipo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idtipo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

--
-- Dumping data for table `tipo`
--

LOCK TABLES `tipo` WRITE;
/*!40000 ALTER TABLE `tipo` DISABLE KEYS */;
INSERT INTO `tipo` VALUES (1,'Rosas'),(2,'Claveles'),(3,'Hortencias'), (4, 'Girasoles'), (5, 'Tulipanes');
/*!40000 ALTER TABLE `tipo` ENABLE KEYS */;
UNLOCK TABLES;


-- -----------------------------------------------------
-- Table `lab4`.`flores`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lab4`.`flores` ;

CREATE TABLE IF NOT EXISTS `lab4`.`flores` (
  `idflores` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `imagen` VARCHAR(500)  NOT NULL,
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
DEFAULT CHARACTER SET = utf8mb3;

--
-- Dumping data for table `flores`
--

LOCK TABLES `flores` WRITE;
/*!40000 ALTER TABLE `flores` DISABLE KEYS */;
INSERT INTO `flores` VALUES (1,'Freedom', 'https://tse1.mm.bing.net/th/id/OIP.V5gIMzyAu9mRWh6YSHBP6QHaHa?rs=1&pid=ImgDetMain', '50.00', 'Ramo de 10 rosas Freedom', 1, 2, 1),
(2,'High & Exotic', 'https://tse1.mm.bing.net/th/id/OIP._Kcnf6s7KXIhXC_ddISTFgHaHa?rs=1&pid=ImgDetMain', '35.00', 'Conjunto de 3 rosas amarillas idelaes para el dia de la primavera', 5, 1, 1),
(3,'Tulipan Blanco', 'https://cdn.shopify.com/s/files/1/0065/4999/5573/files/white_tulips_1024x1024.jpg?v=1668752395', '60.00', 'Conjunto de tulipanes exoticos', 4, 7, 5),
(4,'Horsensia azul', 'https://tse2.mm.bing.net/th/id/OIP.UwVCMKTEW4GbfuoYCB1ikwHaF7?rs=1&pid=ImgDetMain', '80.00', 'Linda flor para ocacsiones especiales', 3, 5, 3),
(5,'ggaa', 'https://img.pixers.pics/pho_wat(s3:700/FO/90/17/3/700_FO90173_40c8ae7f441346d3c8f6c2213cddc781.jpg,700,525,cms:2018/10/5bd1b6b8d04b8_220x50-watermark.png,over,480,475,jpg)/fototapeten-grune-rose.jpg.jpg', '150.00', 'Maravillosa flor con un toque sutil y extravagante', 2, 4, 1),
(6,'clavel', 'https://th.bing.com/th/id/R.65f1babcd94a738c401f207601fcb917?rik=MIBBUH7ZR0Qu4g&pid=ImgRaw&r=0', '45.00', 'Bello ramo de claveles lindos para cualquier ocasion', 1, 6, 2)
 ;
/*!40000 ALTER TABLE `flores` ENABLE KEYS */;
UNLOCK TABLES;

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

LOCK TABLES `puntajes` WRITE;
/*!40000 ALTER TABLE `puntajes` DISABLE KEYS */;
INSERT INTO `puntajes` VALUES (1, 'Alejandro Pineda', 100), (2, 'VinnieTelecom', 80), (3, 'Julio Carrion', 60);
/*!40000 ALTER TABLE `puntajes` ENABLE KEYS */;
UNLOCK TABLES;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;