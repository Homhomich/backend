package ru.relex.tastyfasty.services.mapstruct;

import org.mapstruct.Mapper;
import ru.relex.tastyfasty.db.model.OrderedBreakfast;
import ru.relex.tastyfasty.services.dto.order.OrderedBreakfastDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderedBreakfastStruct {

    OrderedBreakfastDto toDto(OrderedBreakfast breakfast);

    OrderedBreakfast fromDto(OrderedBreakfastDto breakfastDto);

    List<OrderedBreakfastDto> toDto(List<OrderedBreakfast> breakfasts);

    List<OrderedBreakfast> fromDto(List<OrderedBreakfastDto> breakfastDtos);
}
