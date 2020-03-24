CREATE TABLE baskets (
    basket_id SERIAL PRIMARY KEY,
    full_price NUMERIC NOT NULL,
    number_of_persons INTEGER,
    user_id NUMERIC
);

CREATE TABLE breakfasts_in_basket (
    breakfasts_in_basket SERIAL PRIMARY KEY,
    basket_id INTEGER,
    breakfast_id INTEGER,
    CONSTRAINT breakfasts_in_basket_basket_id_fk FOREIGN KEY (basket_id) REFERENCES baskets (basket_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT breakfasts_in_basket_breakfast_id FOREIGN KEY (breakfast_id) REFERENCES breakfasts (breakfast_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);