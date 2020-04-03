ALTER TABLE orders ADD CONSTRAINT
    order_restaurant_fk FOREIGN KEY (restaurant_id) REFERENCES restaurants(restaurant_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE;