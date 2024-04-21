CREATE SCHEMA users;

create table users.users
(
    id                  bigint PRIMARY KEY,
    first_name             varchar(10)      not null,
    last_name              varchar(10)      not null,
    card_number            varchar(10)      not null,
    cvv                   varchar(10)      not null,
    expire_month           varchar(10)      not null,
    expire_year            varchar(10)      not null
);

create sequence users.users_sequence
    START 1
    INCREMENT 1
    minvalue 1
    maxvalue 999999
    CACHE 1;

