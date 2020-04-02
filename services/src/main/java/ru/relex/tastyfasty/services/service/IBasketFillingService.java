package ru.relex.tastyfasty.services.service;

import ru.relex.tastyfasty.services.dto.breakfast.BreakfastDto;

import javax.validation.Valid;
import java.util.List;

public interface IBasketFillingService {

    List<BreakfastDto> getBreakfastsInUserBasket(int basketId);

    BreakfastDto addBreakfastToBasket(@Valid BreakfastDto breakfastDto);

    BreakfastDto updateBreakfastInBasket(@Valid BreakfastDto breakfastDto);

    void removeBreakfastsFromBasket(int basketId);

    void removeBreakfastFromBasket(int basketId, int breakfastId);
}
