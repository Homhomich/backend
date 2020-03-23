CREATE TABLE breakfasts (
    breakfast_id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    tag VARCHAR(50),
    price NUMERIC NOT NULL
    restaurant_id INTEGER,
    CONSTRAINT breakfast_restaurant_id FOREIGN KEY (restaurant_id) REFERENCES restaurants(restaurant_id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

CREATE TABLE orders (
    order_id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    tag VARCHAR(250),
    customer_id INTEGER,
    deliveryman_id INTEGER,
    CONSTRAINT order_customer_fk FOREIGN KEY (customer_id) REFERENCES users (user_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT order_deliveryman_fk FOREIGN KEY (deliveryman_id) REFERENCES users (user_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE orders_breakfasts (
    order_breakfast_id SERIAL PRIMARY KEY,
    order_id INTEGER NOT NULL,
    breakfast_id INTEGER NOT NULL,
    CONSTRAINT order_orders_breakfasts_fk FOREIGN KEY (order_id) REFERENCES orders (order_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT breakfasts_orders_breakfasts_fk FOREIGN KEY (breakfast_id) REFERENCES breakfasts (breakfast_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);