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
        path = "/users/{userId}/basket",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class BasketController {

    private final IBasketService basketService;

    @Autowired
    public BasketController(final IBasketService basketService) {
        this.basketService = basketService;
    }


    @GetMapping
    BasketDto getBasketByUserId(@PathVariable("userId") int userId) {
        return basketService.findBasketByUserId(userId);
    }

    @GetMapping("/{basketId}")
    BasketDto getBasketByBasketId(@PathVariable("basketId") int basketId) {
        return basketService.findBasketById(basketId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    BasketDto create(@RequestBody BasketDto basketDto) {
        return basketService.create(basketDto);
    }

    @PutMapping("/{id}")
    BasketDto update(
            @PathVariable("id") int id,
            @RequestBody BasketDto basketDto
    ) {
        basketDto.setBasketID(id);
        return basketService.update(basketDto);
    }

    @DeleteMapping
    void removeByUserId(@PathVariable("userId") int userId) {
        basketService.removeByUserId(userId);
    }

    @DeleteMapping("/{basketId}")
    void removeByBasketId(@PathVariable("basketId") int basketId) {
        basketService.removeByBasketId(basketId);
    }
}

