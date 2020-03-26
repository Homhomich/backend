package ru.relex.tastyfasty.services.service;

import ru.relex.tastyfasty.db.model.Order;
import ru.relex.tastyfasty.services.dto.order.OrderDto;

import javax.validation.Valid;
import java.util.List;

public interface IOrderService {

    List<OrderDto> findOrders(String search);

    OrderDto findById(int id);

    OrderDto findByCustomerId(int id);

    OrderDto findByDeliverymanId(int id);

    OrderDto update(@Valid OrderDto order);

    void remove(int orderID);

    OrderDto create(@Valid OrderDto order);
}
