package ru.relex.tastyfasty.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.tastyfasty.services.dto.basket.BasketItemDto;
import ru.relex.tastyfasty.services.dto.breakfast.BreakfastDto;
import ru.relex.tastyfasty.services.service.IBasketFillingService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(
        path = "/api/basket/{basketId}",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class BasketFillingController {

    private final IBasketFillingService basketFillingService;

    @Autowired
    public BasketFillingController(IBasketFillingService basketFillingService) {
        this.basketFillingService = basketFillingService;
    }


    @GetMapping
    List<BreakfastDto> getBreakfastsInUserBasket(@PathVariable("basketId") int basketId) {
        return basketFillingService.getBreakfastsInUserBasket(basketId);
    }

    @GetMapping("/asBasketItems")
    List<BasketItemDto> getBasketItemsInUserBasket(@PathVariable("basketId") int basketId) {
        return basketFillingService.getBasketItemsInUserBasket(basketId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    BasketItemDto addBreakfastToBasket(
            @RequestBody BasketItemDto basketItemDto
    ) {
        return basketFillingService.addBreakfastToBasket(basketItemDto);
    }

    @PutMapping("/{basketItemId}")
    BasketItemDto updateBreakfastInBasket(
            @PathVariable int basketItemId,
            @RequestBody BasketItemDto basketItemDto
    ) {
        basketItemDto.setBasketItemID(basketItemId);
        return basketFillingService.updateBreakfastInBasket(basketItemDto);
    }

    @DeleteMapping
    void removeBreakfastsFromBasket(@PathVariable("basketId") int basketId) {
        basketFillingService.removeBreakfastsFromBasket(basketId);
    }

    @DeleteMapping("/{breakfastId}")
    void removeOneBreakfastFromBasket(
            @PathVariable("basketId") int basketId,
            @PathVariable("breakfastId") int breakfastId
    ) {
        basketFillingService.removeOneBreakfastFromBasket(basketId, breakfastId);
    }
}
