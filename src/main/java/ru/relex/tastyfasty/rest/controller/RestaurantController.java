package ru.relex.tastyfasty.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.tastyfasty.db.model.Restaurant;
import ru.relex.tastyfasty.services.dto.restaurant.RestaurantDto;
import ru.relex.tastyfasty.services.service.IRestaurantService;

import java.util.List;

@RestController
@RequestMapping(
        path = "/users/restaurants",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class RestaurantController {

    private final IRestaurantService restaurantService;

    @Autowired
    public RestaurantController(IRestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }


    @GetMapping
    List<RestaurantDto> getRestaurant(@RequestParam(name = "search", required = false) String search) {
        return restaurantService.findRestaurant(search);
    }

    @GetMapping("/{id}")
    Restaurant findById(@PathVariable("id") int id) {
        return null;
    }

    @GetMapping("/{city}, /{street}, /{building}")
    RestaurantDto findByAddress(@PathVariable("city") String city, @PathVariable("street") String street, @PathVariable("building") int building) {
        return restaurantService.findRestaurantByAddress(city, street, building);
    }


    @PutMapping("/{id}")
    Restaurant update(@PathVariable("id") int id, @RequestBody RestaurantDto restaurant) {
        restaurant.setRestaurant_id(id);
        restaurantService.update(restaurant);
        return findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    RestaurantDto create(@RequestBody RestaurantDto restaurant) {
        restaurantService.create(restaurant);
        return restaurant;


    }
}
