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
  `brand` VARCHAR(45) NOT NULL,
  `size` VARCHAR(20) NOT NULL,
  `weight_lbs` INT NULL DEFAULT 0.0,
  `drawer_number` INT NOT NULL,
  `cost` DOUBLE NULL DEFAULT 0.0,
  `part_number` INT NOT NULL,
  `picture` VARCHAR(45) NULL DEFAULT 'None',
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wrench_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wrench_type` ;

CREATE TABLE IF NOT EXISTS `wrench_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wrench_has_wrench_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wrench_has_wrench_type` ;

CREATE TABLE IF NOT EXISTS `wrench_has_wrench_type` (
  `wrench_id` INT NOT NULL,
  `wrench_type_id` INT NOT NULL,
  PRIMARY KEY (`wrench_type_id`, `wrench_id`),
  INDEX `fk_wrench_has_wrench_type_wrench_type1_idx` (`wrench_type_id` ASC),
  INDEX `fk_wrench_has_wrench_type_wrench_idx` (`wrench_id` ASC),
  CONSTRAINT `fk_wrench_has_wrench_type_wrench`
    FOREIGN KEY (`wrench_id`)
    REFERENCES `wrench` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_wrench_has_wrench_type_wrench_type1`
    FOREIGN KEY (`wrench_type_id`)
    REFERENCES `wrench_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
INSERT INTO `wrench` (`id`, `brand`, `size`, `weight_lbs`, `drawer_number`, `cost`, `part_number`, `picture`) VALUES (1, 'Snap-On', '10 mm', NULL, 1, 30.98, 1234, NULL);
INSERT INTO `wrench` (`id`, `brand`, `size`, `weight_lbs`, `drawer_number`, `cost`, `part_number`, `picture`) VALUES (2, 'Craftsman', '3/4 inch', NULL, 2, 2.34, 4321, NULL);
INSERT INTO `wrench` (`id`, `brand`, `size`, `weight_lbs`, `drawer_number`, `cost`, `part_number`, `picture`) VALUES (3, 'Blue Point', '1/2 inch', NULL, 1, 77.67, 2345, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `wrench_type`
-- -----------------------------------------------------
START TRANSACTION;
USE `wrenchdb`;
INSERT INTO `wrench_type` (`id`, `name`, `description`) VALUES (1, 'Moon', 'Used for Starters mainly shaped like a half moon');
INSERT INTO `wrench_type` (`id`, `name`, `description`) VALUES (2, 'Ratcheting', 'Open on one end ratcheting on other end');
INSERT INTO `wrench_type` (`id`, `name`, `description`) VALUES (3, 'Shorty', 'Open/Box but a Minny');
INSERT INTO `wrench_type` (`id`, `name`, `description`) VALUES (4, 'Open/Box', 'Normal everyday wrentch');

COMMIT;

