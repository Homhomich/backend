ALTER TABLE breakfasts_in_basket
    ADD COLUMN num_of_items INTEGER NOT NULL DEFAULT '1';

ALTER TABLE breakfasts_in_basket
    ADD COLUMN ready_to_order BOOLEAN NOT NULL DEFAULT 'false';
