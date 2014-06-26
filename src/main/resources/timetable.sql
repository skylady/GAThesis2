-- MySQL Script generated by MySQL Workbench
-- Sun Jun 15 02:00:30 2014
-- Model: New Model    Version: 1.0
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema timetable
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `timetable` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `timetable` ;

-- -----------------------------------------------------
-- Table `timetable`.`AbsenceMatrix`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `timetable`.`AbsenceMatrix` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `absenceMatrixName` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8 COLLATE utf8_general_ci ;


-- -----------------------------------------------------
-- Table `timetable`.`Period`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `timetable`.`Period` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `period` INT(11) NOT NULL,
  `day_of_the_week` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8 COLLATE utf8_general_ci ;


-- -----------------------------------------------------
-- Table `timetable`.`AbsencePeriod`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `timetable`.`AbsencePeriod` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `period_id` INT(11) NOT NULL,
  `absence_matrix_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `period_id` (`period_id` ASC),
  INDEX `absence_matrix_id` (`absence_matrix_id` ASC),
  CONSTRAINT `absenceperiod_ibfk_1`
    FOREIGN KEY (`period_id`)
    REFERENCES `timetable`.`Period` (`id`),
  CONSTRAINT `absenceperiod_ibfk_2`
    FOREIGN KEY (`absence_matrix_id`)
    REFERENCES `timetable`.`AbsenceMatrix` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8 COLLATE utf8_general_ci ;


-- -----------------------------------------------------
-- Table `timetable`.`Auditory`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `timetable`.`Auditory` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `auditory_number` VARCHAR(255) NOT NULL,
  `auditory_size` INT(11) NOT NULL,
  `auditory_type` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8 COLLATE utf8_general_ci ;


-- -----------------------------------------------------
-- Table `timetable`.`GroupList`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `timetable`.`GroupList` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
    `groupName` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8 COLLATE utf8_general_ci ;


-- -----------------------------------------------------
-- Table `timetable`.`Teacher`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `timetable`.`Teacher` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `id_absence_matrix` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `teacher_ibfk_1` (`id_absence_matrix` ASC),
  CONSTRAINT `teacher_ibfk_1`
    FOREIGN KEY (`id_absence_matrix`)
    REFERENCES `timetable`.`AbsenceMatrix` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8 COLLATE utf8_general_ci ;


-- -----------------------------------------------------
-- Table `timetable`.`GroupCode`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `timetable`.`GroupCode` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `subject` VARCHAR(255) NOT NULL,
  `subject_type` VARCHAR(255) NOT NULL,
  `week_numbers` VARCHAR(255) NOT NULL,
  `group_type` VARCHAR(255) NOT NULL,
  `group_list_id` INT(11) NOT NULL,
  `teacher_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `group_list_id` (`group_list_id` ASC),
  INDEX `teacher_id` (`teacher_id` ASC),
  CONSTRAINT `groupcode_ibfk_1`
    FOREIGN KEY (`group_list_id`)
    REFERENCES `timetable`.`GroupList` (`id`),
  CONSTRAINT `groupcode_ibfk_2`
    FOREIGN KEY (`teacher_id`)
    REFERENCES `timetable`.`Teacher` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8 COLLATE utf8_general_ci ;


-- -----------------------------------------------------
-- Table `timetable`.`Group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `timetable`.`Group` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `course` VARCHAR(255) NOT NULL,
  `group_number` INT(11) NOT NULL,
  `group_code_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `group_code_id` (`group_code_id` ASC),
  CONSTRAINT `group_ibfk_1`
    FOREIGN KEY (`group_code_id`)
    REFERENCES `timetable`.`GroupCode` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8 COLLATE utf8_general_ci ;


-- -----------------------------------------------------
-- Table `timetable`.`StudentList`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `timetable`.`StudentList` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `student_name` VARCHAR(255) NOT NULL,
  `group_list_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `group_list_id` (`group_list_id` ASC),
  CONSTRAINT `studentlist_ibfk_1`
    FOREIGN KEY (`group_list_id`)
    REFERENCES `timetable`.`GroupList` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
