package ru.relex.tastyfasty.services.dto.basket;

import lombok.Data;

@Data
public class BasketItemDto {
    private int basketItemID;
    private int basketID;
    private int breakfastID;
    private int numberOfItems;
    private boolean readyToOrder;
}
