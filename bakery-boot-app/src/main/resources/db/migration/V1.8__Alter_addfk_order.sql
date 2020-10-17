alter table bakery.item
    add constraint item_order_id_fk
        foreign key (order_id) references bakery."order" (id);