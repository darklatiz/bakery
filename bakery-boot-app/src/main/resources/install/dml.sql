create database bakerydb;
create schema bakery;

create sequence bakery.general_id_sequence
	maxvalue 10000000;
comment on sequence bakery.general_id_sequence is 'General sequence for all the IDs generated by the application';

create table bakery.category
(
	id int not null,
	name varchar(50) not null,
	is_active bool default false
);

create unique index category_id_uindex
	on bakery.category (id);

alter table bakery.category
	add constraint category_pk
		primary key (id);


create table bakery.item
(
	id int not null,
	name varchar(150) not null,
	price decimal(12,4) not null,
	quantity int not null,
	unit_of_measurement varchar(15) not null
);

comment on table bakery.item is 'item table, which contains information about the items being soid';

create unique index item_id_uindex
	on bakery.item (id);

alter table bakery.item
	add constraint item_pk
		primary key (id);


create table bakery.catalog_information
(
	id int not null,
	quantity_available int not null,
	unit_of_measurement varchar(25) not null,
	sku varchar(25),
	is_active bool default false
);

create unique index catalog_information_id_uindex
	on bakery.catalog_information (id);

alter table bakery.catalog_information
	add constraint catalog_information_pk
		primary key (id);
