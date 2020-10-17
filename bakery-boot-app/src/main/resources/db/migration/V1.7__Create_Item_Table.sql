create table if not exists bakery.item
(
    id         int       default nextval('bakery.general_id_sequence')
        constraint item_pk
            primary key,
    catalog_id int                     not null
        constraint item_catalog_information_id_fk
            references bakery.catalog_information,
    order_id   int                     not null,
    fd_created timestamp default now() not null,
    name       varchar(250)            not null,
    status     varchar(20),
    order_by   varchar(250)            not null,
    order_type varchar(30)
);

comment on column bakery.item.order_type is 'DELIVERY, TAKE_OUT';

