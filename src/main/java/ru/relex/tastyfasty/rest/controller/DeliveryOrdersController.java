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
    @RolesAllowed({"ROLE_5"})
    List<OrderDto> getOrders(@RequestParam(name = "search", required = false) String search) {
        return orderService.findOrders(search);
    }

    @GetMapping("/{id}")
        //@RolesAllowed("ROLE_5")
    OrderDto findById(@PathVariable("id") int id) {
        return orderService.findById(id);
    }

    @GetMapping("/deliveryman")
    List<OrderDto> getOrdersByDeliverymanId(@RequestParam(name = "deliverymanId") int deliverymanId) {
        return orderService.findByDeliverymanId(deliverymanId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
        //@RolesAllowed("ROLE_6")
    OrderDto create(@RequestBody OrderDto orderDto) {
        return orderService.create(orderDto);
    }


    @PutMapping("/{id}")
        //@RolesAllowed("ROLE_8")
    OrderDto update(@PathVariable("id") int id, @RequestBody OrderDto orderDto) {
        System.out.println(orderDto);
        orderDto.setId(id);
        orderService.update(orderDto);
        return findById(id);
    }

    @DeleteMapping("/{id}")
        //@RolesAllowed("ROLE_7")
    void remove(@PathVariable("id") int id) {
        orderService.remove(id);
    }
}




