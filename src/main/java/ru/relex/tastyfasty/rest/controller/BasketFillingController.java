package ru.relex.tastyfasty.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    BreakfastDto addBreakfastToBasket(
            @PathVariable("basketId") int basketId,
            @RequestBody BreakfastDto breakfastDto
    ) {
        return basketFillingService.addBreakfastToBasket(basketId, breakfastDto);
    }

    @PutMapping("/{breakfastId}")
    BreakfastDto updateBreakfastInBasket(
            @PathVariable int breakfastId,
            @PathVariable("basketId") int basketId,
            @RequestBody BreakfastDto breakfastDto
    ) {
        breakfastDto.setId(breakfastId);
        return basketFillingService.updateBreakfastInBasket(basketId, breakfastDto);
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
