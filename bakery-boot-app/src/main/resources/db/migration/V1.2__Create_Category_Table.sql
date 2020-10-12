create table bakery.category
(
    id        int  default nextval('bakery.general_id_sequence')
        constraint category_pk
            primary key,
    name      varchar(250) not null,
    is_active bool default false
);