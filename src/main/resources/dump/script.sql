create database ShopDB;
use ShopDB;
create table users (
    id bigint primary key auto_increment,
    email varchar(40),
    name varchar(20),
    role varchar(20)
);
insert into users (email, name, role) values
                                          ('red.dog@mail.ru', 'dog', 'ADMIN'),
                                          ('white.cat@mail.ru', 'cat', 'SELLER'),
                                          ('green.horse@mail.ru', 'horse', 'USER'),
                                          ('black.bear@mail.ru', 'bear', 'USER');
