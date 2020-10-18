create table bakery.address
(
    id int default nextval('bakery.general_id_sequence')
        constraint address_pk
            primary key,
    address_1 varchar(250) not null,
    address_2 varchar(250),
    zip varchar(10) not null,
    city varchar(50) not null,
    state varchar(50) not null
);

