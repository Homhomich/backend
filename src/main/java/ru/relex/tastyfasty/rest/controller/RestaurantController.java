package ru.relex.tastyfasty.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.tastyfasty.services.dto.restaurant.RestaurantDto;
import ru.relex.tastyfasty.services.service.IRestaurantService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(
        path = "/api/restaurants",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class RestaurantController {

    private final IRestaurantService restaurantService;

    @Autowired
    public RestaurantController(IRestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }


    @GetMapping
    List<RestaurantDto> getRestaurants(@RequestParam(name = "search", required = false) String search) {
        System.out.println("search");
        return restaurantService.findRestaurants(search);
    }

    @GetMapping("/{id}")
    RestaurantDto findById(@PathVariable("id") int id) {
        return restaurantService.findRestaurantById(id);
    }
/*
    @GetMapping("/{address}")
    List<RestaurantDto> findByAddress(
            @RequestParam(name = "city") String city,
            @RequestParam(name = "street", required = false) String street,
            @RequestParam(name = "building", required = false) int building
    ) {
        return restaurantService.findRestaurantByAddress(city, street, building);
    }*/

    @PutMapping("/{id}")
    RestaurantDto update(
            @PathVariable("id") int id,
            @RequestBody RestaurantDto restaurantDto
    ) {
        restaurantDto.setRestaurantId(id);
        restaurantService.update(restaurantDto);
        return findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    RestaurantDto create(@RequestBody RestaurantDto restaurantDto) {
        return restaurantService.create(restaurantDto);
    }

    @DeleteMapping("/{id}")
    void remove(@PathVariable("id") int id) {
        restaurantService.remove(id);
    }
}
