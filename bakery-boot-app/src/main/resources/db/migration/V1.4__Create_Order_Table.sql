create table if not exists bakery."order"
(
    id              int constraint order_pk primary key ,
    item_catalog_id int,
    name            varchar(250) not null,
    total           decimal(8, 2),
    tax_percentage  decimal(3, 2),
    tax_amount      decimal(8, 2),
    fd_ordered      date,
    order_type      int,

    status          varchar(30) default 'ORDERED',
    reason_status   text
);

comment on column bakery."order".order_type is 'TAKE OUT
TAKE IN
UBER EATS';

comment on column bakery."order".status is '''ORDERED''
''IN PROCESS''
''CANCEL''
''FINISHED''';

