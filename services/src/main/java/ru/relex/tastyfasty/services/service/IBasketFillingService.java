package ru.relex.tastyfasty.services.service;

import ru.relex.tastyfasty.services.dto.basket.BasketItemDto;
import ru.relex.tastyfasty.services.dto.breakfast.BreakfastDto;

import javax.validation.Valid;
import java.util.List;

public interface IBasketFillingService {

    List<BreakfastDto> getBreakfastsInUserBasket(int basketId);

    List<BasketItemDto> getBasketItemsInUserBasket(int basketId);

    BasketItemDto addBreakfastToBasket(@Valid BasketItemDto basketItemDto);

    BasketItemDto updateBreakfastInBasket(@Valid BasketItemDto basketItemDto);

    void removeBreakfastsFromBasket(int basketId);

    void removeOneBreakfastFromBasket(int basketId, int breakfastId);
}
