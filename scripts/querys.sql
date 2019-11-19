DROP DATABASE db_projetojavacrud;
CREATE DATABASE db_projetojavacrud;

USE DATABASE db_projetojavacrud;

create table TB_CLIENTE (
	codigo  int(10) NOT NULL AUTO_INCREMENT,
	razao varchar(255) NOT NULL,
	fantasia varchar(255) NOT NULL,
	cnpj varchar(20) NOT NULL,
	ie varchar(20) NOT NULL,
	PRIMARY KEY (codigo)
);

create table TB_CONFIGURACAO (
	codigo  int(10) NOT NULL AUTO_INCREMENT,
	mensagem1 varchar(255) NOT NULL,
	mensagem2 varchar(255) NOT NULL,
	mensagem3 varchar(255) NOT NULL,
	mensagem4 varchar(255) NOT NULL,
	PRIMARY KEY (codigo)
);

create table TB_CONTARECEBER (
	codigo  int(10) NOT NULL AUTO_INCREMENT,
	emissao DATE NOT NULL,
	vencimento DATE NOT NULL,
	pagamento DATE NOT NULL,
	valor DOUBLE(12,5) NOT NULL,
	PRIMARY KEY (codigo)
);

create table TB_OCORRENCIAS (
	codigo  int(10) NOT NULL AUTO_INCREMENT,
	data DATE NOT NULL,
	nomeUsuario varchar(255) NOT NULL,
	descricao varchar(255) NOT NULL,
	motivo varchar(255) NOT NULL,
	PRIMARY KEY (codigo)
);

create table TB_PROTOCOLO (
	codigo  int(10) NOT NULL AUTO_INCREMENT,
	problema varchar(255) NOT NULL,
	resolucao varchar(255) NOT NULL,
	dataAbertura DATE NOT NULL,
	dataFechamento DATE NOT NULL,
	PRIMARY KEY (codigo)
);