//SQL SERVER

CREATE DATABASE sinn
GO

USE sinn
CREATE TABLE empresa (codigo int not null IDENTITY(1,1) PRIMARY KEY, nome_empresa varchar(75), cnpj numeric(14,0), dono_empresa varchar(50))
CREATE TABLE cargo(id int not null IDENTITY(1,1) PRIMARY KEY, nome_cargo varchar(20))
CREATE TABLE pessoa(codigo int not null IDENTITY(1,1) PRIMARY KEY, nome varchar(50), cpf varchar(20), salario_atual numeric(12,2), salario_reajuste numeric(12,2), empresa int not null FOREIGN KEY REFERENCES empresa(codigo), cargo int not null FOREIGN KEY REFERENCES cargo (id))


INSERT INTO sinn..cargo (nome_cargo) values ('Estagiário')
INSERT INTO sinn..cargo (nome_cargo) values ('Gerente')
INSERT INTO sinn..cargo (nome_cargo) values ('Diretor')

//POSTGRESQL

$ createdb sinn
$ psql sinn
CREATE TABLE empresa (codigo int PRIMARY KEY, nome_empresa varchar(75), 
                      cnpj numeric(14,0), dono_empresa varchar(50));
CREATE TABLE cargo(id int PRIMARY KEY, nome_cargo varchar(20));
CREATE TABLE pessoa(codigo int PRIMARY KEY, nome varchar(50), cpf varchar(20)
                    , salario_atual numeric(12,2), salario_reajuste numeric(12,2), empresa int 
                    REFERENCES empresa(codigo), cargo int REFERENCES cargo (id));
                    
INSERT INTO sinn..cargo (nome_cargo) values ('Estagiário');
INSERT INTO sinn..cargo (nome_cargo) values ('Gerente');
INSERT INTO sinn..cargo (nome_cargo) values ('Diretor');

