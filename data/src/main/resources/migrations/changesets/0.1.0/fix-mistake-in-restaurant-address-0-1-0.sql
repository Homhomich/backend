ALTER TABLE restaurants DROP CONSTRAINT restaurant_address_fk;

ALTER TABLE restaurants ADD CONSTRAINT
    restaurant_address_fk FOREIGN KEY (address_id) REFERENCES addresses(address_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE;