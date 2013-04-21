SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`usuarios`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`usuarios` (
  `user_id` VARCHAR(16) NOT NULL ,
  `password` VARCHAR(16) NULL ,
  `ingresi` DOUBLE NULL ,
  `usuarioscol` VARCHAR(45) NULL ,
  `nivel_alerta` DOUBLE NULL ,
  PRIMARY KEY (`user_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tipo_pago`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`tipo_pago` (
  `id_tipo_pago` INT NOT NULL ,
  `descripcion` VARCHAR(45) NULL ,
  PRIMARY KEY (`id_tipo_pago`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`gastos`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`gastos` (
  `id_gastos` INT NOT NULL ,
  `descripcion` VARCHAR(100) NULL ,
  `tipo_pago` INT NULL ,
  `monto` DOUBLE NULL ,
  `fecha_gasto` DATE NULL ,
  `tipo_gasto` TINYINT(1) NULL ,
  `fecha_recordatorio` DATE NULL ,
  `user_id` VARCHAR(16) NULL ,
  PRIMARY KEY (`id_gastos`) ,
  INDEX `fk_gastos_usuarios_idx` (`user_id` ASC) ,
  INDEX `fk_gastos_tipo_pago1_idx` (`tipo_pago` ASC) ,
  CONSTRAINT `fk_gastos_usuarios`
    FOREIGN KEY (`user_id` )
    REFERENCES `mydb`.`usuarios` (`user_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_gastos_tipo_pago1`
    FOREIGN KEY (`tipo_pago` )
    REFERENCES `mydb`.`tipo_pago` (`id_tipo_pago` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
