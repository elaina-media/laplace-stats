create table reward
(
    item_id          int             not null,
    battle_id        int             not null,
    quantity         bigint unsigned not null,
    range_start_time datetime        not null,
    range_end_time   datetime        not null
);

