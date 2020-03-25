package ru.relex.tastyfasty.services.service;

import ru.relex.tastyfasty.services.dto.breakfast.BreakfastDto;
import ru.relex.tastyfasty.services.dto.user.UserDto;

import javax.validation.Valid;
import java.util.List;

public interface IBreakfastService {

    List<BreakfastDto> findBreakfasts(String search);

    List<BreakfastDto> findBreakfastsByTag(String search);

    List<BreakfastDto> findBreakfastsByName(String search);

    List<BreakfastDto> findBreakfastsByRestaurantId(int restaurantId);

    BreakfastDto findBreakfastById(int breakfastId);

    BreakfastDto create(@Valid BreakfastDto breakfastDto);

    BreakfastDto update(@Valid BreakfastDto breakfastDto);

    void remove(int breakfastId);
}
