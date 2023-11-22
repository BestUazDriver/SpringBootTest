create database if not exists ShopDB;
use ShopDB;
create table if not exists user
(
    id    bigint primary key auto_increment,
    email varchar(40),
    name  varchar(20),
    role  varchar(20)
);
insert into user (email, name, role)
values ('red.dog@mail.ru', 'dog', 'ADMIN'),
       ('white.cat@mail.ru', 'cat', 'SELLER'),
       ('green.horse@mail.ru', 'horse', 'USER'),
       ('black.bear@mail.ru', 'bear', 'USER');
create table if not exists car
(
    id          bigint primary key auto_increment,
    name        varchar(30),
    model       varchar(40),
    horse_power int
);

INSERT INTO car (name, model)
VALUES ('BMW', '530d'),
       ('toyota', 'corolla'),
       ('nissan', 'x-trail');