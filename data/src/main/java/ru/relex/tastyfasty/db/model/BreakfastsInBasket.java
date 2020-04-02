package ru.relex.tastyfasty.db.model;

import lombok.Data;

@Data
public class BreakfastsInBasket {
    private int breakfastsInBasketID;
    private int basketID;
    private int breakfastID;
}
