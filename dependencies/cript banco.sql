create database tijolo;

use tijolo;

drop table if exists pedido;
drop table if exists venda;
drop table if exists cliente;
drop table if exists estoque;

CREATE TABLE IF NOT EXISTS Cliente (
  COD_cli INT NOT NULL AUTO_INCREMENT,
  Nome_cliente VARCHAR(45) NOT NULL,
  CPF VARCHAR(14) NOT NULL ,
  celular VARCHAR(15) NOT NULL,
  Email VARCHAR(100) not NULL,
  Data_nasci varchar(10) NOT NULL,
  Endereco VARCHAR(50) NOT NULL,
  Complemento VARCHAR(50) NULL,
  Bairro VARCHAR(45) not NULL,
  Cidade VARCHAR(45) NOT NULL,
  CEP varchar(9) NOT NULL,
  Ativo bool not null,
  PRIMARY KEY (COD_cli));
  
  CREATE TABLE IF NOT EXISTS Estoque (
  COD_prod INT NOT NULL AUTO_INCREMENT,
  Nome_Produto VARCHAR(40) NOT NULL,
  Valor decimal(10,2) NOT NULL,
  Quantidade INT NOT NULL,
  Data_entrada varchar(10) NOT NULL,
  PRIMARY KEY (COD_prod));
  
  CREATE TABLE IF NOT EXISTS Venda (
  COD_venda INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  COD_cli int not null,
  Nome_cliente VARCHAR(45) NOT NULL,
  Data_venda date NOT NULL,
  Valor_Total decimal(10,2) NOT NULL,
  FOREIGN KEY (COD_cli) REFERENCES Cliente(COD_cli));
  
  CREATE TABLE IF NOT EXISTS Pedido (
  dummyCol int not null primary key auto_increment,
  COD_venda INT NOT NULL,
  Nome_Produto VARCHAR(40) NOT NULL,
  Quantidade INT NOT NULL,
  Valor decimal(10,2) NOT NULL,
  foreign key (cod_venda) references Venda(cod_venda));
  