create table battle
(
    id           int auto_increment
        primary key,
    battle_name  varchar(50)     not null,
    sample_count bigint unsigned null,
    cell_cost    int             not null,
    constraint battle_pk_2
        unique (id)
);

