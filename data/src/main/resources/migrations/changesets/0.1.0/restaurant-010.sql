CREATE TABLE addresses (
    address_id SERIAL PRIMARY KEY,
    city VARCHAR(50) NOT NULL,
    street VARCHAR(50) NOT NULL,
    building INTEGER NOT NULL
);



CREATE TABLE restaurants (
    restaurant_id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    open_time TIME NOT NULL,
    close_time TIME NOT NULL,
    rating INTEGER,
    address_id SERIAL,
    tags VARCHAR(250)
);