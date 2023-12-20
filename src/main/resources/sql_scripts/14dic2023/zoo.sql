-- MySQL Script generated by MySQL Workbench
-- Sat Dec 16 16:53:49 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema zoo
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema zoo
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `zoo` DEFAULT CHARACTER SET utf8 ;
USE `zoo` ;

-- -----------------------------------------------------
-- Table `zoo`.`departments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zoo`.`departments` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` TEXT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zoo`.`employees`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zoo`.`employees` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `position` VARCHAR(45) NOT NULL,
  `years_of_exp` INT UNSIGNED NOT NULL,
  `department_id` BIGINT UNSIGNED,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `fk_employees_departments1_idx` (`department_id` ASC) ,
  CONSTRAINT `fk_employees_departments1`
    FOREIGN KEY (`department_id`)
    REFERENCES `zoo`.`departments` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zoo`.`attractions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zoo`.`attractions` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` TEXT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zoo`.`animals`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zoo`.`animals` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `age` INT UNSIGNED NOT NULL,
  `specie` VARCHAR(45) NOT NULL,
  `attraction_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `fk_animals_attractions1_idx` (`attraction_id` ASC) ,
  CONSTRAINT `fk_animals_attractions1`
    FOREIGN KEY (`attraction_id`)
    REFERENCES `zoo`.`attractions` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zoo`.`customers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zoo`.`customers` (
  `id` BIGINT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `age` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zoo`.`employee_tools`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zoo`.`employee_tools` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `description` TEXT NULL,
  `employee_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `fk_employee_tools_employees1_idx` (`employee_id` ASC) ,
  CONSTRAINT `fk_employee_tools_employees1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `zoo`.`employees` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zoo`.`animal_items`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zoo`.`animal_items` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` TEXT NULL,
  `animal_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `fk_animal_items_animals1_idx` (`animal_id` ASC) ,
  CONSTRAINT `fk_animal_items_animals1`
    FOREIGN KEY (`animal_id`)
    REFERENCES `zoo`.`animals` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zoo`.`attraction_items`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zoo`.`attraction_items` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `description` TEXT NULL,
  `attractions_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `fk_attraction_items_attractions1_idx` (`attractions_id` ASC) ,
  CONSTRAINT `fk_attraction_items_attractions1`
    FOREIGN KEY (`attractions_id`)
    REFERENCES `zoo`.`attractions` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zoo`.`ticket_price`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zoo`.`ticket_price` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `age` INT UNSIGNED NOT NULL,
  `price` DECIMAL NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  UNIQUE INDEX `age_UNIQUE` (`age` ASC) )
ENGINE = InnoDB
COMMENT = '	';


-- -----------------------------------------------------
-- Table `zoo`.`salary_multiplier_1`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zoo`.`salary_multiplier_1` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `position` VARCHAR(45) NOT NULL,
  `multiplier` DECIMAL NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  UNIQUE INDEX `position_UNIQUE` (`position` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zoo`.`salary_multiplier_2`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zoo`.`salary_multiplier_2` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `years_of_exp` INT NOT NULL,
  `multiplier` DECIMAL NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  UNIQUE INDEX `years_of_exp_UNIQUE` (`years_of_exp` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zoo`.`animal_id_tags`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zoo`.`animal_id_tags` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `tag_id` BIGINT UNSIGNED NOT NULL,
  `animal_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  UNIQUE INDEX `animal_id_UNIQUE` (`tag_id` ASC) ,
  INDEX `fk_animal_id_tags_animals1_idx` (`animal_id` ASC) ,
  CONSTRAINT `fk_animal_id_tags_animals1`
    FOREIGN KEY (`animal_id`)
    REFERENCES `zoo`.`animals` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zoo`.`department_attractions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zoo`.`department_attractions` (
  `department_id` BIGINT UNSIGNED NOT NULL,
  `attraction_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`department_id`, `attraction_id`),
  INDEX `fk_departments_has_attractions_attractions1_idx` (`attraction_id` ASC) ,
  INDEX `fk_departments_has_attractions_departments_idx` (`department_id` ASC) ,
  CONSTRAINT `fk_departments_has_attractions_departments`
    FOREIGN KEY (`department_id`)
    REFERENCES `zoo`.`departments` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_departments_has_attractions_attractions1`
    FOREIGN KEY (`attraction_id`)
    REFERENCES `zoo`.`attractions` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;