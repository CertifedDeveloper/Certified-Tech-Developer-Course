-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Spotify
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Spotify
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Spotify` DEFAULT CHARACTER SET utf8 ;
USE `Spotify` ;

-- -----------------------------------------------------
-- Table `Spotify`.`Passwords`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Spotify`.`Passwords` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `password` VARCHAR(500) NULL,
  `seguridad` VARCHAR(100) NULL,
  `fecha_modificacion` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Spotify`.`Usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Spotify`.`Usuarios` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(200) NULL,
  `fecha_nacimiento` DATE NULL,
  `sexo` VARCHAR(100) NULL,
  `codigo_postal` INT NULL,
  `pais` VARCHAR(200) NULL,
  `Passwords_id` INT NOT NULL,
  PRIMARY KEY (`id`, `Passwords_id`),
  INDEX `fk_Usuarios_Passwords_idx` (`Passwords_id` ASC) VISIBLE,
  CONSTRAINT `fk_Usuarios_Passwords`
    FOREIGN KEY (`Passwords_id`)
    REFERENCES `Spotify`.`Passwords` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Spotify`.`Artistas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Spotify`.`Artistas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(200) NULL,
  `ruta_imagen` VARCHAR(500) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Spotify`.`Discograficas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Spotify`.`Discograficas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NULL,
  `pais` VARCHAR(200) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Spotify`.`Albumes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Spotify`.`Albumes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(200) NULL,
  `Artistas_id` INT NOT NULL,
  `anio_plublicacion` VARCHAR(50) NULL,
  `ruta_imagen_portada` VARCHAR(500) NULL,
  `Discograficas_id` INT NOT NULL,
  PRIMARY KEY (`id`, `Artistas_id`, `Discograficas_id`),
  INDEX `fk_Albumes_Artistas1_idx` (`Artistas_id` ASC) VISIBLE,
  INDEX `fk_Albumes_Discograficas1_idx` (`Discograficas_id` ASC) VISIBLE,
  CONSTRAINT `fk_Albumes_Artistas1`
    FOREIGN KEY (`Artistas_id`)
    REFERENCES `Spotify`.`Artistas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Albumes_Discograficas1`
    FOREIGN KEY (`Discograficas_id`)
    REFERENCES `Spotify`.`Discograficas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Spotify`.`Canciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Spotify`.`Canciones` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(200) NULL,
  `duracion` TIME NULL,
  `numero_reproducciones` INT NULL,
  `likes` INT NULL,
  `Albumes_id` INT NOT NULL,
  PRIMARY KEY (`id`, `Albumes_id`),
  INDEX `fk_Canciones_Albumes1_idx` (`Albumes_id` ASC) VISIBLE,
  CONSTRAINT `fk_Canciones_Albumes1`
    FOREIGN KEY (`Albumes_id`)
    REFERENCES `Spotify`.`Albumes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Spotify`.`Actividad_Playlists`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Spotify`.`Actividad_Playlists` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo_playlist` TINYINT(1) NULL,
  `fecha_eliminacion` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Spotify`.`Playlists`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Spotify`.`Playlists` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(200) NULL,
  `numero_canciones` INT NULL,
  `fecha_creacion` DATETIME NULL,
  `Usuarios_id` INT NOT NULL,
  `Canciones_id` INT NOT NULL,
  `Actividad_Playlists_id` INT NOT NULL,
  PRIMARY KEY (`id`, `Usuarios_id`, `Canciones_id`, `Actividad_Playlists_id`),
  INDEX `fk_Playlists_Usuarios1_idx` (`Usuarios_id` ASC) VISIBLE,
  INDEX `fk_Playlists_Canciones1_idx` (`Canciones_id` ASC) VISIBLE,
  INDEX `fk_Playlists_Actividad_Playlists1_idx` (`Actividad_Playlists_id` ASC) VISIBLE,
  CONSTRAINT `fk_Playlists_Usuarios1`
    FOREIGN KEY (`Usuarios_id`)
    REFERENCES `Spotify`.`Usuarios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Playlists_Canciones1`
    FOREIGN KEY (`Canciones_id`)
    REFERENCES `Spotify`.`Canciones` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Playlists_Actividad_Playlists1`
    FOREIGN KEY (`Actividad_Playlists_id`)
    REFERENCES `Spotify`.`Actividad_Playlists` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Spotify`.`Generos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Spotify`.`Generos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(200) NULL,
  `Canciones_id` INT NOT NULL,
  PRIMARY KEY (`id`, `Canciones_id`),
  INDEX `fk_Genero_Canciones1_idx` (`Canciones_id` ASC) VISIBLE,
  CONSTRAINT `fk_Genero_Canciones1`
    FOREIGN KEY (`Canciones_id`)
    REFERENCES `Spotify`.`Canciones` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
