CREATE TABLE roles (
    role_id INTEGER PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

INSERT INTO roles (role_id, name)
VALUES (1, 'ADMIN'),
        (2, 'USER');

CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    middle_name VARCHAR(50) NULL,
    username VARCHAR(64) NOT NULL,
    password CHAR(80) NOT NULL,
    role_id INTEGER NOT NULL,
    CONSTRAINT user_role_fk FOREIGN KEY (role_id) REFERENCES roles (role_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);