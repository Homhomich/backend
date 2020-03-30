ALTER TABLE restaurants ALTER COLUMN address_id DROP DEFAULT;

ALTER TABLE restaurants ADD CONSTRAINT
    restaurant_address_fk FOREIGN KEY (restaurant_id) REFERENCES addresses(address_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE;

