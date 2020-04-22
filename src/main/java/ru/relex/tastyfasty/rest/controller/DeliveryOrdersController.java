package ru.relex.tastyfasty.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.tastyfasty.services.dto.order.OrderDto;
import ru.relex.tastyfasty.services.service.IOrderService;
import javax.annotation.security.RolesAllowed;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(
        path = "/api/orders",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class DeliveryOrdersController {

    private final IOrderService orderService;

    @Autowired
    public DeliveryOrdersController(final IOrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping
    List<OrderDto> getOrders(@RequestParam(name = "search", required = false) String search) {
        return orderService.findOrders(search);
    }

    @GetMapping("/{id}")
    OrderDto findById(@PathVariable("id") int id) {
        return orderService.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    OrderDto create(@RequestBody OrderDto orderDto) {
        return orderService.create(orderDto);
    }


    @PutMapping("/{id}")
    OrderDto update(
            @PathVariable("id") int id,
            @RequestBody OrderDto orderDto
    ) {
        orderDto.setId(id);
        orderService.update(orderDto);
        return findById(id);
    }

    @DeleteMapping("/{id}")
    void remove(@PathVariable("id") int id) {
        orderService.remove(id);
    }
}




