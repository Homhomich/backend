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
        path = "/user/{userId}/orders",
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

    /*@GetMapping
    List<OrderDto> getOrdersByCustomerId(@RequestParam(value = "customerId") int customerId) {
        return orderService.findByCustomerId(customerId);
    }

    @GetMapping
    List<OrderDto> getOrdersByDeliverymanId(@RequestParam(value = "deliverymanId") int deliverymanId) {
        return orderService.findByDeliverymanId(deliverymanId);
    }*/

    @GetMapping("/{id}")
    OrderDto findById(@PathVariable("id") int id) {
        return orderService.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    OrderDto create(
            @PathVariable("userId") int userId,
            @RequestBody OrderDto orderDto
    ) {
        orderDto.setCustomerID(userId);
        return orderService.create(orderDto);
    }

    @PutMapping("/{id}")
    OrderDto update(
            @PathVariable("id") int id,
            @PathVariable("userId") int userId,
            @RequestBody OrderDto orderDto
    ) {
        orderDto.setOrderID(id);
        orderDto.setCustomerID(userId);
        orderService.update(orderDto);
        return findById(id);
    }

    @DeleteMapping("/{id}")
    void remove(@PathVariable("id") int id) {
        orderService.remove(id);
    }
}
