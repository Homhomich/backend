package ru.relex.tastyfasty.services.service;

import ru.relex.tastyfasty.services.dto.breakfast.BreakfastDto;

import javax.validation.Valid;
import java.util.List;

public interface IBasketFillingService {

    List<BreakfastDto> getBreakfastsInUserBasket(int basketId);

    BreakfastDto addBreakfastToBasket(int basketId, @Valid BreakfastDto breakfastDto);

    BreakfastDto updateBreakfastInBasket(int basketId, @Valid BreakfastDto breakfastDto);

    void removeBreakfastsFromBasket(int basketId);

    void removeOneBreakfastFromBasket(int basketId, int breakfastId);
}
