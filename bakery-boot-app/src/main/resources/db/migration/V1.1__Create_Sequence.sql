create sequence if not exists bakery.general_id_sequence
    maxvalue 10000000;
comment on sequence bakery.general_id_sequence is 'General sequence for all the IDs generated by the application';