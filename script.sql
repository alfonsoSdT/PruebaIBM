-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`proveedores`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`proveedores` ;

CREATE TABLE IF NOT EXISTS `mydb`.`proveedores` (
  `id_proveedor` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `fechaDeAlta` DATE NOT NULL,
  `id_cliente` INT NOT NULL,
  PRIMARY KEY (`id_proveedor`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `mydb`.`proveedores`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`proveedores` (`id_proveedor`, `nombre`, `fechaDeAlta`, `id_cliente`) VALUES (1, 'Coca-cola', '1998-12-21', 5);
INSERT INTO `mydb`.`proveedores` (`id_proveedor`, `nombre`, `fechaDeAlta`, `id_cliente`) VALUES (2, 'Pepsi', '1998-12-21', 5);
INSERT INTO `mydb`.`proveedores` (`id_proveedor`, `nombre`, `fechaDeAlta`, `id_cliente`) VALUES (3, 'Redbull', '1998-12-21', 6);

COMMIT;

