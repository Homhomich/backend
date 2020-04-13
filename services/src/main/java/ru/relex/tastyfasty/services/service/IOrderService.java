package ru.relex.tastyfasty.services.service;

import ru.relex.tastyfasty.services.dto.order.OrderDto;
import ru.relex.tastyfasty.services.dto.order.OrderInfoDto;

import javax.validation.Valid;
import java.util.List;

public interface IOrderService {

    List<OrderDto> findOrders(String search);

    List<OrderDto> findByCustomerId(int id);

    List<OrderDto> findByDeliverymanId(int id);

    OrderDto findById(int id);

    OrderDto create(@Valid OrderDto order);

    OrderDto update(@Valid OrderDto order);

    void remove(int orderID);
}
