create table item
(
    id        int auto_increment
        primary key,
    item_name varchar(50) not null,
    constraint item_pk_2
        unique (id)
);

