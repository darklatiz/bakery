create table if not exists bakery.catalog_information
(
    id                 int           default nextval('bakery.general_id_sequence')
        constraint catalog_information_pk
            primary key,
    name               varchar(250) not null,
    description        varchar(250) not null,
    price              decimal(8, 2) default 0.00,
    image              varchar(250),
    is_active          bool          default false,
    uom                varchar(50),
    weight             decimal(8, 2),
    quantity_available int,
    fd_added           date
);

alter table bakery.catalog_information
    add category_id int;

alter table bakery.catalog_information
    add constraint catalog_information_category_id_fk
        foreign key (category_id) references bakery.category;

