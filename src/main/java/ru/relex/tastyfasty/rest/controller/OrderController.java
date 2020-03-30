package ru.relex.tastyfasty.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.tastyfasty.services.dto.order.OrderDto;
import ru.relex.tastyfasty.services.service.impl.OrderServiceImpl;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(
        path = "/orders",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class OrderController {

    private final OrderServiceImpl orderService;

    @Autowired
    public OrderController(final OrderServiceImpl orderService) {
        this.orderService = orderService;
    }


    @GetMapping
    List<OrderDto> getOrders(@RequestParam(name = "search", required = false) String search) {
        return orderService.findOrders(search);
    }

    @GetMapping("/{id}")
    OrderDto findById(@PathVariable("orderID") int id) {
        return orderService.findById(id);
    }

    @PutMapping("/{id}")
    OrderDto update(@PathVariable("orderID") int id, @RequestBody OrderDto orderDto) {
        orderDto.setOrderID(id);
        orderService.update(orderDto);
        return findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    OrderDto create(@RequestBody OrderDto orderDto) {
        orderService.create(orderDto);
        return orderDto;
    }

    @DeleteMapping("/{id}")
    void remove(@PathVariable("orderID") int id) {
        orderService.remove(id);
    }
}
