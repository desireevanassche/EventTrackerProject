-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema homefixdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `homefixdb` ;

-- -----------------------------------------------------
-- Schema homefixdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `homefixdb` DEFAULT CHARACTER SET utf8 ;
USE `homefixdb` ;

-- -----------------------------------------------------
-- Table `project`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `project` ;

CREATE TABLE IF NOT EXISTS `project` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `start_date` DATETIME NULL,
  `end_date` DATETIME NULL,
  `description` TEXT NULL,
  `created_date` DATETIME NULL,
  `img_url` VARCHAR(2000) NULL,
  `budget` VARCHAR(45) NULL,
  `completed` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `task`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `task` ;

CREATE TABLE IF NOT EXISTS `task` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  `priority_level` INT NULL,
  `description` TEXT NULL,
  `date_created` DATETIME NULL,
  `start_date` DATETIME NULL,
  `end_date` DATETIME NULL,
  `project_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_task_project_idx` (`project_id` ASC),
  CONSTRAINT `fk_task_project`
    FOREIGN KEY (`project_id`)
    REFERENCES `project` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS homefix@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'homefix'@'localhost' IDENTIFIED BY 'homefix';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'homefix'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `project`
-- -----------------------------------------------------
START TRANSACTION;
USE `homefixdb`;
INSERT INTO `project` (`id`, `name`, `start_date`, `end_date`, `description`, `created_date`, `img_url`, `budget`, `completed`) VALUES (1, 'Kitchen Remodel', '2022-12-07', '2022-12-09', 'Complete kitchen overhaul with the intention of repurposing as much material as possible', '2022-05-04', '', '6000', DEFAULT);
INSERT INTO `project` (`id`, `name`, `start_date`, `end_date`, `description`, `created_date`, `img_url`, `budget`, `completed`) VALUES (2, 'Basement Apartment', '2022-06-12', '2023-05-05', 'Converting our 70\'s style basement into an apartment for my parents. ', '2022-02-01', '', '8000', DEFAULT);

COMMIT;


-- -----------------------------------------------------
-- Data for table `task`
-- -----------------------------------------------------
START TRANSACTION;
USE `homefixdb`;
INSERT INTO `task` (`id`, `name`, `priority_level`, `description`, `date_created`, `start_date`, `end_date`, `project_id`) VALUES (1, 'Sand Cabinets', 1, 'Sand the old stain of cabinets & prep for new stain. ', '2022-04-05', '2022-07-07', NULL, 1);
INSERT INTO `task` (`id`, `name`, `priority_level`, `description`, `date_created`, `start_date`, `end_date`, `project_id`) VALUES (2, 'Stain Cabinets ', 1, 'Stain cabinets in Ebony', '2022-04-05', '2022-07-08', NULL, 1);
INSERT INTO `task` (`id`, `name`, `priority_level`, `description`, `date_created`, `start_date`, `end_date`, `project_id`) VALUES (3, 'Install Cabinet Hardware ', 2, 'Add gold hardware to cabinets & reinstall ', '2022-04-05', '2022-07-09', NULL, 1);
INSERT INTO `task` (`id`, `name`, `priority_level`, `description`, `date_created`, `start_date`, `end_date`, `project_id`) VALUES (4, 'Patch Drywall ', 2, 'While cabinet stain drys patch drywall', '2022-04-05', '2022-07-08', NULL, 1);

COMMIT;

