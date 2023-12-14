CREATE TABLE users (
    id bigint AUTO_INCREMENT PRIMARY KEY UNIQUE,
    uuid binary(16) default (UUID()) unique not null,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(10) NOT NULL DEFAULT 'USER' CHECK (role IN ('ADMIN', 'USER'))
);
