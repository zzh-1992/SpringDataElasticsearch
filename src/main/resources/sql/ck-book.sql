create database if not exists my_database;
drop table if exists my_database.books;
create table if not exists my_database.books
(
    id String,
    name Nullable(String),
    summary Nullable(String),
    price Nullable(Int32)
)
    engine = Memory;
