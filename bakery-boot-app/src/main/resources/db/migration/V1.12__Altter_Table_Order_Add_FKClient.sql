alter table bakery."order"
    add client_id int;

alter table bakery."order"
    add delivery_address_id int not null;