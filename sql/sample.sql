create table sample
(
    id                bigint unsigned          not null
        primary key,
    battle_id         int                      not null,
    battle_name       varchar(50)              not null,
    sample_life_cycle enum ('Queue', 'Stored') not null,
    create_time       datetime                 not null,
    battle_count      int                      null,
    constraint sample_pk_2
        unique (id)
);

