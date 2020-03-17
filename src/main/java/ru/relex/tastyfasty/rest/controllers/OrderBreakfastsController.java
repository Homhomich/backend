package ru.relex.tastyfasty.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.tastyfasty.db.mappers.OrderBreakfastsMapper;
import ru.relex.tastyfasty.db.mappers.UserMapper;
import ru.relex.tastyfasty.db.models.OrderBreakfasts;
import ru.relex.tastyfasty.db.models.User;

import java.util.List;

@RestController
@RequestMapping(
        path = "/order/orderbreakfasts",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class OrderBreakfastsController {

    private final OrderBreakfastsMapper orderBreakfastsMapper;

    @Autowired
    public OrderBreakfastsController(final OrderBreakfastsMapper orderBreakfastsMapper) {
        this.orderBreakfastsMapper = orderBreakfastsMapper;
    }


    @GetMapping
    List<OrderBreakfasts> getOrderBreakfasts(@RequestParam(name = "search", required = false) String search) {
        return orderBreakfastsMapper.getOrdersBreakfasts(search);
    }

    @GetMapping("/{id}")
    OrderBreakfasts findById(@PathVariable("id") int id) {
        return orderBreakfastsMapper.findById(id);
    }

    @PutMapping("/{id}")
    OrderBreakfasts update(@PathVariable("orderBreakfastID") int id, @RequestBody OrderBreakfasts orderBreakfasts) {
        orderBreakfasts.setOrderBreakfastID(id);
        orderBreakfastsMapper.update(orderBreakfasts);
        return findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    OrderBreakfasts create(@RequestBody OrderBreakfasts orderBreakfasts) {
        orderBreakfastsMapper.insert(orderBreakfasts);
        return orderBreakfasts;


    }
}
