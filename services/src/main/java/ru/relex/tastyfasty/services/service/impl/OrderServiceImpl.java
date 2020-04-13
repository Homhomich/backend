package ru.relex.tastyfasty.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.relex.tastyfasty.db.mapper.OrderMapper;
import ru.relex.tastyfasty.services.dto.order.OrderDto;
import ru.relex.tastyfasty.services.mapstruct.OrderStruct;
import ru.relex.tastyfasty.services.service.IOrderService;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class OrderServiceImpl implements IOrderService {

    private final OrderMapper orderMapper;
    private final OrderStruct orderStruct;

    @Autowired
    public OrderServiceImpl(OrderMapper orderMapper,
                            OrderStruct orderStruct) {
        this.orderMapper = orderMapper;
        this.orderStruct = orderStruct;
    }


    @Override
    public List<OrderDto> findOrders(String search) {
        var order = orderMapper.getOrders(search);
        return orderStruct.toDto(order);
    }

    @Override
    public OrderDto findById(int id) {
        var order = orderMapper.findById(id);
        return orderStruct.toDto(order);
    }

    @Override
    public List<OrderDto> findByCustomerId(int id) {
        var orders = orderMapper.findByCustomerId(id);
        return orderStruct.toDto(orders);
    }

    @Override
    public List<OrderDto> findByDeliverymanId(int id) {
        var orders = orderMapper.findByDeliverymanId(id);
        return orderStruct.toDto(orders);
    }

    @Override
    public OrderDto update(@Valid OrderDto orderDto) {
        var order = orderStruct.fromDto(orderDto);
        orderMapper.update(order);
        return orderStruct.toDto(order);
    }

    @Override
    public void remove(int id) {
        orderMapper.delete(id);
    }

    @Override
    public OrderDto create(@Valid OrderDto orderDto) {
        var order = orderStruct.fromDto(orderDto);
        orderMapper.insert(order);
        return orderStruct.toDto(order);
    }
}
