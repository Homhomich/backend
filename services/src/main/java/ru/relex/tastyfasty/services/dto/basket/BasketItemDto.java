package ru.relex.tastyfasty.services.dto.basket;

import lombok.Data;
import ru.relex.tastyfasty.services.dto.breakfast.BreakfastDto;

@Data
public class BasketItemDto {
    private int basketItemID;
    private int basketID;
    private BreakfastDto breakfast;
    private int numberOfItems;
    private boolean readyToOrder;
}
