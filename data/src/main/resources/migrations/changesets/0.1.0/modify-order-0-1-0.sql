ALTER TABLE breakfasts ADD restaurant_id INTEGER;
ALTER TABLE breakfasts ADD CONSTRAINT
breakfast_restaurant_fk FOREIGN KEY (restaurant_id) REFERENCES restaurants(restaurant_id)
    ON UPDATE CASCADE
    ON DELETE CASCADE;