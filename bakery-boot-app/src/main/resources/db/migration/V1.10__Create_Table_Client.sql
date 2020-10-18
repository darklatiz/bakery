create table bakery.client
(
    id int default nextval('bakery.general_id_sequence')
        constraint client_pk
            primary key,
    full_name varchar(250) not null,
    email varchar(250) not null,
    telephone varchar(25),
    comments text
);

create unique index client_email_uindex
    on bakery.client (email);

