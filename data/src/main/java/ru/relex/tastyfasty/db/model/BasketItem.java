package ru.relex.tastyfasty.db.model;

import lombok.Data;

@Data
public class BasketItem {
    private int basketItemID;
    private int basketID;
    private int breakfastID;
    private int numberOfItems;
    private boolean readyToOrder;
}
