package ru.relex.tastyfasty.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.tastyfasty.services.dto.basket.BasketItemDto;
import ru.relex.tastyfasty.services.dto.breakfast.BreakfastDto;
import ru.relex.tastyfasty.services.dto.order.OrderedBreakfastDto;
import ru.relex.tastyfasty.services.service.IBasketFillingService;
import ru.relex.tastyfasty.services.service.IOrderFillingService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(
        path = "/api/order/{orderId}/",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class OrderFillingController {

    private final IOrderFillingService orderFillingService;

    @Autowired
    public OrderFillingController(IOrderFillingService orderFillingService) {
        this.orderFillingService = orderFillingService;
    }


    @GetMapping
    List<BreakfastDto> getBreakfastsInOrder(@PathVariable("orderId") int orderId) {
        return orderFillingService.getBreakfastsInOrder(orderId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    OrderedBreakfastDto addBreakfastToBasket(
            @RequestBody OrderedBreakfastDto orderedBreakfastDto
    ) {
        return orderFillingService.addBreakfastToOrder(orderedBreakfastDto);
    }

    @PutMapping("/{breakfastId}")
    OrderedBreakfastDto updateBreakfastInBasket(
            @RequestBody OrderedBreakfastDto orderedBreakfastDto
    ) {
        return orderFillingService.updateBreakfastInOrder(orderedBreakfastDto);
    }

    @DeleteMapping
    void removeBreakfastsFromBasket(@PathVariable("orderId") int orderId) {
        orderFillingService.removeBreakfastsByOrderId(orderId);
    }

    @DeleteMapping("/{breakfastId}")
    void removeOneBreakfastFromBasket(
            @PathVariable("orderId") int orderId,
            @PathVariable("breakfastId") int breakfastId
    ) {
        orderFillingService.removeBreakfastFromOrder(orderId, breakfastId);
    }
}
