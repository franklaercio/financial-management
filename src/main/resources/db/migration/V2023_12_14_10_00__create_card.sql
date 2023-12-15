CREATE TABLE card(
    id binary(16) default (uuid_to_bin(uuid())) not null primary key,
    number VARCHAR(255) not null,
    cvv VARCHAR(255) not null,
    expirationDate VARCHAR(255) not null,
    flag varchar(255) not null,
    person_id binary(16) not null,
    active tinyint(1) not null default 1,
    create_at timestamp default current_timestamp not null,
    updated_at timestamp default current_timestamp not null,
    FOREIGN KEY (person_id) REFERENCES person(id)
);
