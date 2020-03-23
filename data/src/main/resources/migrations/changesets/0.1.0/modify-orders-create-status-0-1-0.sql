ALTER TABLE orders ADD restaurant_id INTEGER NOT NULL DEFAULT '000';

ALTER TABLE orders ADD status_id INTEGER NOT NULL DEFAULT '0';

CREATE TABLE statuses (
    status_id INTEGER PRIMARY KEY,
    name      VARCHAR(50) NOT NULL
);

ALTER TABLE orders ADD CONSTRAINT order_status_fk FOREIGN KEY (status_id) REFERENCES statuses (status_id)
    ON UPDATE CASCADE
    ON DELETE CASCADE;