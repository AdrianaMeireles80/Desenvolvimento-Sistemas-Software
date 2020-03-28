-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'root';
-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`utilizador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`utilizador` (
  `id_utilizador` INT NOT NULL AUTO_INCREMENT,
  `numero` INT NOT NULL,
  `email_utilizador` VARCHAR(45) NOT NULL,
  `usernameU` VARCHAR(30) NOT NULL,
  `passwordU` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id_utilizador`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`cliente` (
  `nif_cl` INT NOT NULL,
  `morada_cl` VARCHAR(45) NOT NULL,
  `email_cl` VARCHAR(45) NOT NULL,
  `nome_cl` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`nif_cl`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Configuracao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Configuracao` (
  `id_config` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `utilizador_id_utilizador` INT NOT NULL,
  `cliente_nif_cl` INT NOT NULL,
  PRIMARY KEY (`id_config`),
  INDEX `fk_Configuracao_utilizador1_idx` (`utilizador_id_utilizador` ASC) VISIBLE,
  INDEX `fk_Configuracao_cliente1_idx` (`cliente_nif_cl` ASC) VISIBLE,
  CONSTRAINT `fk_Configuracao_utilizador1`
    FOREIGN KEY (`utilizador_id_utilizador`)
    REFERENCES `mydb`.`utilizador` (`id_utilizador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Configuracao_cliente1`
    FOREIGN KEY (`cliente_nif_cl`)
    REFERENCES `mydb`.`cliente` (`nif_cl`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Veiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Veiculo` (
  `id_V` INT NOT NULL AUTO_INCREMENT,
  `modelo` VARCHAR(15) NOT NULL,
  `preco` INT NOT NULL,
  `Configuracao_id_config` INT NOT NULL,
  PRIMARY KEY (`id_V`),
  INDEX `fk_Veiculo_Configuracao_idx` (`Configuracao_id_config` ASC) VISIBLE,
  CONSTRAINT `fk_Veiculo_Configuracao`
    FOREIGN KEY (`Configuracao_id_config`)
    REFERENCES `mydb`.`Configuracao` (`id_config`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`CompObrigatoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`CompObrigatoria` (
  `id_obg` INT NOT NULL AUTO_INCREMENT,
  `nome_obg` VARCHAR(45) NOT NULL,
  `preco_obg` DOUBLE NOT NULL,
  `stock_obg` INT NULL,
  `Configuracao_id_config` INT NOT NULL,
  PRIMARY KEY (`id_obg`),
  INDEX `fk_CompObrigatoria_Configuracao1_idx` (`Configuracao_id_config` ASC) VISIBLE,
  CONSTRAINT `fk_CompObrigatoria_Configuracao1`
    FOREIGN KEY (`Configuracao_id_config`)
    REFERENCES `mydb`.`Configuracao` (`id_config`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DetInterior`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DetInterior` (
  `id_Int` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `designacao_Int` VARCHAR(50) NOT NULL,
  `preco_Int` DOUBLE NOT NULL,
  `stock_int` INT NULL,
  `Configuracao_id_config` INT NOT NULL,
  PRIMARY KEY (`id_Int`),
  INDEX `fk_DetInterior_Configuracao1_idx` (`Configuracao_id_config` ASC) VISIBLE,
  CONSTRAINT `fk_DetInterior_Configuracao1`
    FOREIGN KEY (`Configuracao_id_config`)
    REFERENCES `mydb`.`Configuracao` (`id_config`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DetExterior`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DetExterior` (
  `id_Ext` INT NOT NULL AUTO_INCREMENT,
  `designacao_ext` VARCHAR(50) NOT NULL,
  `preco_ext` DOUBLE NOT NULL,
  `stock_ext` INT NULL,
  `Configuracao_id_config` INT NOT NULL,
  PRIMARY KEY (`id_Ext`),
  INDEX `fk_DetExterior_Configuracao1_idx` (`Configuracao_id_config` ASC) VISIBLE,
  CONSTRAINT `fk_DetExterior_Configuracao1`
    FOREIGN KEY (`Configuracao_id_config`)
    REFERENCES `mydb`.`Configuracao` (`id_config`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`CompOpcional`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`CompOpcional` (
  `id_opc` INT NOT NULL AUTO_INCREMENT,
  `nome_opc` VARCHAR(50) NOT NULL,
  `preco_opc` DOUBLE NOT NULL,
  `stock_opc` INT NULL,
  `compIncomp` VARCHAR(30) NOT NULL,
  `Configuracao_id_config` INT NOT NULL,
  PRIMARY KEY (`id_opc`),
  INDEX `fk_CompOpcional_Configuracao1_idx` (`Configuracao_id_config` ASC) VISIBLE,
  CONSTRAINT `fk_CompOpcional_Configuracao1`
    FOREIGN KEY (`Configuracao_id_config`)
    REFERENCES `mydb`.`Configuracao` (`id_config`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
