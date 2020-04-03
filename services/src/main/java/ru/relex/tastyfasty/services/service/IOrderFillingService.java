package ru.relex.tastyfasty.services.service;

import ru.relex.tastyfasty.services.dto.breakfast.BreakfastDto;

import javax.validation.Valid;
import java.util.List;

public interface IOrderFillingService {

    List<BreakfastDto> getBreakfastsInOrder(int orderId);

    BreakfastDto addBreakfastToOrder(int orderId, @Valid BreakfastDto breakfastDto);

    BreakfastDto updateBreakfastInOrder(int orderId, @Valid BreakfastDto breakfastDto);

    void removeBreakfastsByOrderId(int orderId);

    void removeBreakfastFromOrder(int orderId, int breakfastId);
}
