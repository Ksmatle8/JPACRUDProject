-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema wrenchdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `wrenchdb` ;

-- -----------------------------------------------------
-- Schema wrenchdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `wrenchdb` DEFAULT CHARACTER SET utf8 ;
USE `wrenchdb` ;

-- -----------------------------------------------------
-- Table `wrench`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wrench` ;

CREATE TABLE IF NOT EXISTS `wrench` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  `brand` VARCHAR(45) NOT NULL,
  `size` VARCHAR(20) NOT NULL,
  `weight_lbs` INT NULL,
  `drawer_number` INT NULL,
  `cost` DOUBLE NULL,
  `part_number` INT NULL,
  `picture` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS toolbox@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'toolbox'@'localhost' IDENTIFIED BY 'toolbox$';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'toolbox'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `wrench`
-- -----------------------------------------------------
START TRANSACTION;
USE `wrenchdb`;
INSERT INTO `wrench` (`id`, `type`, `brand`, `size`, `weight_lbs`, `drawer_number`, `cost`, `part_number`, `picture`) VALUES (1, 'Moon', 'Snap-On', '10 mm', NULL, 1, 30.98, NULL, NULL);
INSERT INTO `wrench` (`id`, `type`, `brand`, `size`, `weight_lbs`, `drawer_number`, `cost`, `part_number`, `picture`) VALUES (2, 'Open/Box End', 'Craftsman', '3/4 inch', NULL, 2, 2.34, NULL, NULL);
INSERT INTO `wrench` (`id`, `type`, `brand`, `size`, `weight_lbs`, `drawer_number`, `cost`, `part_number`, `picture`) VALUES (3, 'Ratcheting', 'Blue Point', '1/2 inch', NULL, 1, 77.67, NULL, NULL);

COMMIT;

