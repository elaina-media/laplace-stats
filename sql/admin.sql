create table admin
(
    id       int unsigned auto_increment
        primary key,
    name     varchar(15)     not null,
    qq       bigint unsigned null,
    mail     varchar(320)    null,
    salt     varchar(10)     not null,
    password varchar(64)     not null,
    constraint admin_pk_2
        unique (id),
    constraint admin_pk_3
        unique (name),
    constraint admin_pk_4
        unique (qq),
    constraint admin_pk_5
        unique (mail)
);

