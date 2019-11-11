create database tijolo;

use tijolo;

CREATE TABLE IF NOT EXISTS `Cliente` (
  `COD_cli` INT NOT NULL AUTO_INCREMENT,
  `Nome_cliente` VARCHAR(45) NOT NULL,
  `CPF` VARCHAR(11) NOT NULL ,
  /*o programa tem que verivicar se ja ezite no banco de dado
	para que nao tenha CPF repetido*/
  `celular` VARCHAR(11) NOT NULL,
  /*O valor 3172978990 é maior que 2147483647 - o valor máximo para INT- daí o erro. Os tipos inteiros do MySQL e seus intervalos estão listados aqui.
	Observe também que o (10)in INT(10)não define o "tamanho" de um número inteiro. Especifica a largura de exibição da coluna. Esta informação é apenas informativa.
	Para corrigir o erro, altere seu tipo de dados para VARCHAR. Os números de telefone e fax devem ser armazenados como seqüências de caracteres. Veja esta discussão.
    "https://stackoverflow.com/questions/14284494/mysql-error-1264-out-of-range-value-for-column"*/
  `Email` VARCHAR(100) not NULL,
  `Data_nasci` DATE NOT NULL,
  #`Data_nasi` varchar(10) NOT NULL,
  `Endereco` VARCHAR(50) NOT NULL,
  `Complemento` NVARCHAR(50) NULL,
  `Bairro` VARCHAR(45) not NULL,
    `Cidade` VARCHAR(45) NOT NULL,
    `Estado` CHAR(2) NOT NULL,
  `CEP` INT(8) NOT NULL,
  PRIMARY KEY (`COD_cli`, `CPF`));
  
  CREATE TABLE IF NOT EXISTS `Pedido` (
  `COD_venda` INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  `Nome_cliente` VARCHAR(45) NOT NULL,
  `Valor_Total` decimal(10,2) NOT NULL,
  `Data_venda` DATE NOT NULL,
  `CPF` VARCHAR(11) NOT NULL,
  #`Data_venda` varchar(10) NOT NULL,
  #FOREIGN KEY (CPF) REFERENCES Cliente_PI(CPF,COD_cli));
  INDEX `fk_Pedido_PI_Cliente_PI_idx` (`CPF` ASC) );
  
  CREATE TABLE IF NOT EXISTS `Estoque` (
  `COD_prod` INT NOT NULL AUTO_INCREMENT,
  `Nome_Produto` VARCHAR(40) NOT NULL,
  `Valor` decimal(10,2) NOT NULL,
  `Quantidade` INT NOT NULL,
  PRIMARY KEY (`COD_prod`));
  
 /* CREATE TABLE IF NOT EXISTS `Item` (
  `COD_Pedido` INT NOT NULL,
  `Nome_Produto` VARCHAR(40) NOT NULL,
  `Quantidade` INT NOT NULL,
  `Valor` decimal(10,2) NOT NULL,
  PRIMARY KEY (`COD_Pedido`, `Nome_Produto`),
  INDEX `fk_Item_ Estoque_PI1_idx` (`Nome_Produto` ASC),
  INDEX `fk_Item_Pedido_PI1_idx` (`COD_Pedido` ASC));*/
