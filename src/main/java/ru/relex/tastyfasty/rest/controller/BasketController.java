package ru.relex.tastyfasty.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.tastyfasty.services.dto.basket.BasketDto;
import ru.relex.tastyfasty.services.service.IBasketService;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(
        path = "/basket",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class BasketController {

    private final IBasketService basketService;

    @Autowired
    public BasketController(final IBasketService basketService) {
        this.basketService = basketService;
    }


    @GetMapping
    List<BasketDto> getBaskets(@RequestParam(name = "search", required = false) String search) {
        return basketService.findBaskets(search);
    }

    @GetMapping("/{user_id}")
    BasketDto getBasketByUserId(@PathVariable("userID") int userID) {
        return basketService.findBasketByUserId(userID);
    }

    @PutMapping("/{number_of_persons}")
    BasketDto update(@PathVariable("numberOfPersons") int id, @RequestBody BasketDto basketDto) {
        basketDto.setNumberOfPersons(id);
        basketService.update(basketDto);
        return basketService.update(basketDto);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    BasketDto create(@RequestBody BasketDto basketDto) {
        basketService.create(basketDto);
        return basketDto;
    }

    @DeleteMapping("/{basket_id}")
    void remove(@PathVariable("basketID") int basketID) {
        basketService.remove(basketID);
    }
}

