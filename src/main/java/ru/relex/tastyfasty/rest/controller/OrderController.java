package ru.relex.tastyfasty.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.tastyfasty.db.mapper.OrderMapper;
import ru.relex.tastyfasty.db.model.Order;

import java.util.List;

@RestController
@RequestMapping(
        path = "/order",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class OrderController {

    private final OrderMapper orderMapper;

    @Autowired
    public OrderController(final OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }


    @GetMapping
    List<Order> getOrder(@RequestParam(name = "search", required = false) String search) {
        return orderMapper.getOrders(search);
    }

    @GetMapping("/{id}")
    Order findById(@PathVariable("orderID") int id) {
        return orderMapper.findById(id);
    }

    @PutMapping("/{id}")
    Order update(@PathVariable("orderID") int id, @RequestBody Order order) {
        order.setOrderID(id);
        orderMapper.update(order);
        return findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    Order create(@RequestBody Order order) {
        orderMapper.insert(order);
        return order;


    }
}
