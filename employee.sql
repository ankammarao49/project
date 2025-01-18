create database if not exists assp;

use assp;

drop table if exists employee;

create table employee(
    id int auto_increment,
    name varchar(255),
    email varchar(255),
    phone varchar(15),
    address varchar(255),
    password varchar(255),
    primary key(id)
);