-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Categorias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Categorias` (
  `idCategorias` INT NOT NULL,
  `Descricao` VARCHAR(45) NULL,
  PRIMARY KEY (`idCategorias`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Editora`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Editora` (
  `idEditora` INT NULL,
  `nome` VARCHAR(45) NULL,
  PRIMARY KEY (`idEditora`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Livro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Livro` (
  `ISBN` INT NULL,
  `Ano` VARCHAR(45) NULL,
  `Titulo` VARCHAR(45) NULL,
  `Categorias_idCategorias` INT NOT NULL,
  `Editora_idEditora` INT NOT NULL,
  PRIMARY KEY (`ISBN`),
  INDEX `fk_Livro_Categorias_idx` (`Categorias_idCategorias` ASC) ,
  INDEX `fk_Livro_Editora1_idx` (`Editora_idEditora` ASC) ,
  CONSTRAINT `fk_Livro_Categorias`
    FOREIGN KEY (`Categorias_idCategorias`)
    REFERENCES `mydb`.`Categorias_idCategorias` (`idCategorias`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Livro_Editora1`
    FOREIGN KEY (`Editora_idEditora`)
    REFERENCES `mydb`.`Editora_idEditora` (`idEditora`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Autor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Autor` (
  `idAutor` INT NULL,
  `nome` VARCHAR(45) NULL,
  `nacionalidade` VARCHAR(45) NULL,
  PRIMARY KEY (`idAutor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Autor_Livro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Autor_Livro` (
  `idAutor_Livro` INT NOT NULL,
  `Livro_ISBN` INT NOT NULL,
  `Autor_idAutor` INT NOT NULL,
  PRIMARY KEY (`idAutor_Livro`),
  INDEX `fk_Autor_Livro_Livro1_idx` (`Livro_ISBN` ASC) ,
  INDEX `fk_Autor_Livro_Autor1_idx` (`Autor_idAutor` ASC) ,
  CONSTRAINT `fk_Autor_Livro_Livro1`
    FOREIGN KEY (`Livro_ISBN`)
    REFERENCES `mydb`.`Livro_ISBN` (`ISBN`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Autor_Livro_Autor1`
    FOREIGN KEY (`Autor_idAutor`)
    REFERENCES `mydb`.`Autor_idAutor` (`idAutor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`editora` (`idEditora`, `nome`) VALUES (1, 'Rocco');
INSERT INTO `mydb`.`editora` (`idEditora`, `nome`) VALUES (2, 'Wmf Martins Fontes');
INSERT INTO `mydb`.`editora` (`idEditora`, `nome`) VALUES (3, 'Casa da Palavra');
INSERT INTO `mydb`.`editora` (`idEditora`, `nome`) VALUES (4, 'Belas Letras');
INSERT INTO `mydb`.`editora` (`idEditora`, `nome`) VALUES (5, 'Matrix');

COMMIT;

START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`categorias` (`idCategorias`, `Descricao`) VALUES (1, 'Literatura Juvenil');
INSERT INTO `mydb`.`categorias` (`idCategorias`, `Descricao`) VALUES (2, 'Ficção Científica');
INSERT INTO `mydb`.`categorias` (`idCategorias`, `Descricao`) VALUES (3, 'Humor');

COMMIT;

START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`livro` (`isbn`, `titulo`, `ano`, `Categoria_id`, `editora_id`) VALUES (129834798, 'Garota Desdobrável', 2015, 3, 4);
INSERT INTO `mydb`.`livro` (`isbn`, `titulo`, `ano`, `Categoria_id`, `editora_id`) VALUES (298345729, 'O Papai é Pop', 2015, 2, 3);
INSERT INTO `mydb`.`livro` (`isbn`, `titulo`, `ano`, `Categoria_id`, `editora_id`) VALUES (316546479, 'Harry Potter e A Pedra Filosofal', 2000, 1, 1);
INSERT INTO `mydb`.`livro` (`isbn`, `titulo`, `ano`, `Categoria_id`, `editora_id`) VALUES (347623486, 'Pior Que Ta Não Fica', 2016, 2, 2);
INSERT INTO `mydb`.`livro` (`isbn`, `titulo`, `ano`, `Categoria_id`, `editora_id`) VALUES (348976599, 'Harry Potter e O Prisioneiro de Azkaban', 2004, 1, 2);
INSERT INTO `mydb`.`livro` (`isbn`, `titulo`, `ano`, `Categoria_id`, `editora_id`) VALUES (765687567, 'As Crónicas de Nárnia', 2009, 2, 2);
INSERT INTO `mydb`.`livro` (`isbn`, `titulo`, `ano`, `Categoria_id`, `editora_id`) VALUES (808028923, 'O Espadachim de Carvão', 2013, 3, 2);

COMMIT;

START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`autor` (`idAutor`, `nome`, `nacionalidade`) VALUES (1, 'J.K. Rowling', 'Inglaterra');
INSERT INTO `mydb`.`autor` (`idAutor`, `nome`, `nacionalidade`) VALUES (2, 'Clives Staples Lewis', 'Inglaterra');
INSERT INTO `mydb`.`autor` (`idAutor`, `nome`, `nacionalidade`) VALUES (3, 'Affonso Solano', 'Brasil');
INSERT INTO `mydb`.`autor` (`idAutor`, `nome`, `nacionalidade`) VALUES (4, 'Marcos Piangers', 'Brasil');
INSERT INTO `mydb`.`autor` (`idAutor`, `nome`, `nacionalidade`) VALUES (5, 'Ciro Botelho', 'Brasil');
INSERT INTO `mydb`.`autor` (`idAutor`, `nome`, `nacionalidade`) VALUES (6, 'Bianca Mól', 'Brasil');

COMMIT;

START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`autor_livro` (`idAutor_Livro`, `Livro_ISBN`, `Autor_idAutor`) VALUES (1, 316546479, 1);
INSERT INTO `mydb`.`autor_livro` (`idAutor_Livro`, `Livro_ISBN`, `Autor_idAutor`) VALUES (2, 765687567, 2);
INSERT INTO `mydb`.`autor_livro` (`idAutor_Livro`, `Livro_ISBN`, `Autor_idAutor`) VALUES (3, 808028923, 3);
INSERT INTO `mydb`.`autor_livro` (`idAutor_Livro`, `Livro_ISBN`, `Autor_idAutor`) VALUES (4, 298345729, 4);
INSERT INTO `mydb`.`autor_livro` (`idAutor_Livro`, `Livro_ISBN`, `Autor_idAutor`) VALUES (5, 347623486, 5);
INSERT INTO `mydb`.`autor_livro` (`idAutor_Livro`, `Livro_ISBN`, `Autor_idAutor`) VALUES (6, 129834798, 6);
INSERT INTO `mydb`.`autor_livro` (`idAutor_Livro`, `Livro_ISBN`, `Autor_idAutor`) VALUES (7, 348976599, 1);

COMMIT;
