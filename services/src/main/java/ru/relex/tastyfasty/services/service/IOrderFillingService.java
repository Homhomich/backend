package ru.relex.tastyfasty.services.service;

import ru.relex.tastyfasty.services.dto.breakfast.BreakfastDto;
import ru.relex.tastyfasty.services.dto.order.OrderedBreakfastDto;

import javax.validation.Valid;
import java.util.List;

public interface IOrderFillingService {

    List<BreakfastDto> getBreakfastsInOrder(int orderId);

    OrderedBreakfastDto addBreakfastToOrder(@Valid OrderedBreakfastDto orderedBreakfastDto);

    OrderedBreakfastDto updateBreakfastInOrder(@Valid OrderedBreakfastDto orderedBreakfastDto);

    void removeBreakfastsByOrderId(int orderId);

    void removeBreakfastFromOrder(int orderId, int breakfastId);
}
