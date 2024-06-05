create database siteCompras;
use siteCompras;

create table Clientes(
CPF char(11) not null primary key,
nome varchar(40),
telefone char(13),
endereco varchar(50)
);
drop table Clientes;
select * from Clientes;


