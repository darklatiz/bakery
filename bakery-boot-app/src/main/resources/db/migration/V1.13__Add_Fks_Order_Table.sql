alter table bakery."order"
    add constraint order_address_id_fk
        foreign key (delivery_address_id) references bakery.address;

alter table bakery."order"
    add constraint order_client_id_fk
        foreign key (client_id) references bakery.client;

