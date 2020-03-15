CREATE TABLE breakfast (
    breakfast_id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    tag VARCHAR(50),
    price NUMERIC NOT NULL
);

CREATE TABLE order (
    order_id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    tag VARCHAR(250),
    customer_id INTEGER FOREIGN KEY REFERENCES Users(user_id),
    deliveryman_id INTEGER FOREIGN KEY REFERENCES  Users(user_id)
);