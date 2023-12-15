CREATE TABLE transaction(
    id binary(16) default (uuid_to_bin(uuid())) not null primary key,
    description VARCHAR(255),
    date timestamp default current_timestamp not null,
    value DECIMAL(10, 2) not null
);

CREATE TABLE transaction_card(
    id binary(16) default (uuid_to_bin(uuid())) not null primary key,
    transaction_id binary(16) not null,
    card_id binary(16) not null,
    FOREIGN KEY (transaction_id) REFERENCES transaction(id),
    FOREIGN KEY (card_id) REFERENCES card(id)
);
