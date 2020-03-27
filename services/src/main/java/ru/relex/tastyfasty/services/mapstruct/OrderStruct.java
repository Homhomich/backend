package ru.relex.tastyfasty.services.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.relex.tastyfasty.db.model.Order;
import ru.relex.tastyfasty.db.model.Restaurant;
import ru.relex.tastyfasty.services.dto.order.OrderDto;
import ru.relex.tastyfasty.services.dto.restaurant.RestaurantDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderStruct {

    @Mapping(target = "orderInfo.tag", source = "tag")
    @Mapping(target = "orderInfo.name", source = "name")
    @Mapping(target = "orderInfo.price", source = "price")
    OrderDto toDto(Order order);

    @Mapping(target = "tag", source = "orderInfo.tag")
    @Mapping(target = "name", source = "orderInfo.name")
    @Mapping(target = "price", source = "orderInfo.price")
    Order fromDto(OrderDto orderDto);

    List<OrderDto> toDto(List<Order> orders);

    List<Order> fromDto(List<OrderDto> orderDtos);
}
