CREATE SCHEMA users;

create table users.users
(
    id                  bigint PRIMARY KEY,
    firstName             varchar(10)      not null,
    lastName              varchar(10)      not null,
    cardNumber            varchar(10)      not null,
    cvv                   varchar(10)      not null,
    expireMonth           varchar(10)      not null,
    expireYear            varchar(10)      not null
);

create sequence users.users_sequence
    START 1
    INCREMENT 1
    minvalue 1
    maxvalue 999999
    CACHE 1;

