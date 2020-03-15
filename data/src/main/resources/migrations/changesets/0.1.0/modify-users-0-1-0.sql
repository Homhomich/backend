CREATE TABLE users_orders (
    user_order_id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    order_id INTEGER NOT NULL,
    CONSTRAINT user_users_orders_fk FOREIGN KEY (user_id) REFERENCES users (user_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT order_users_orders_fk FOREIGN KEY (order_id) REFERENCES orders (order_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE users_messages (
    user_message_id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    message_id INTEGER NOT NULL,
    CONSTRAINT user_users_messages_fk FOREIGN KEY (user_id) REFERENCES users (user_id)
      ON UPDATE CASCADE
      ON DELETE CASCADE,
    CONSTRAINT message_users_messages_fk FOREIGN KEY (message_id) REFERENCES messages (message_id)
      ON UPDATE CASCADE
      ON DELETE CASCADE
);

ALTER TABLE users ADD address_id INTEGER NOT NULL DEFAULT '000';

ALTER TABLE users ADD CONSTRAINT
    user_address_fk FOREIGN KEY (address_id)
    REFERENCES addresses (address_id)
    ON UPDATE CASCADE
    ON DELETE CASCADE;