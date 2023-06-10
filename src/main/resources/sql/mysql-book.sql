create database if not exists my_database;
create table if not exists my_database.books
(
    id varchar(255),
    name varchar(255),
    summary varchar(255),
    price int
);
