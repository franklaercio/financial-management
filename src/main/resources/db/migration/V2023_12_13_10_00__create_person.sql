CREATE TABLE person(
    id binary(16) default (uuid_to_bin(uuid())) not null primary key,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    cpf varchar(11) not null,
    email varchar(255) not null,
    phone varchar(255),
    address varchar(255),
    city varchar(255),
    state varchar(255),
    country varchar(255),
    zipcode varchar(255),
    birthdate date not null,
    created_at timestamp default current_timestamp not null,
    updated_at timestamp default current_timestamp not null,
    user_id bigint unique not null,
    constraint fk_person_user foreign key (user_id) references users(id)
)