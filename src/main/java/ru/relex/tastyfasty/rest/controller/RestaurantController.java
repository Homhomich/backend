package ru.relex.tastyfasty.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.tastyfasty.db.mapper.RestaurantMapper;
import ru.relex.tastyfasty.db.model.Restaurant;

import java.util.List;

@RestController
@RequestMapping(
        path = "/users/restaurants",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class RestaurantController {

    private final RestaurantMapper restaurantMapper;

    @Autowired
    public RestaurantController(RestaurantMapper restaurantMapper) {
        this.restaurantMapper = restaurantMapper;
    }


    @GetMapping
    List<Restaurant> getRestaurant(@RequestParam(name = "search", required = false) String search) {
        return restaurantMapper.getRestaurant(search);
    }

    @GetMapping("/{id}")
    Restaurant findById(@PathVariable("id") int id) {
        return restaurantMapper.findById(id);
    }

    @GetMapping("/{city}, /{street}, /{building}")
    Restaurant findByAddress(@PathVariable("city") String city, @PathVariable("street") String street, @PathVariable("building") int building) {
        return restaurantMapper.findByAddress(city, street, building);
    }

    @GetMapping("/{name}")
    Restaurant findByName(@PathVariable("name") String name) {
        return restaurantMapper.findByName(name);
    }

    @PutMapping("/{id}")
    Restaurant update(@PathVariable("id") int id, @RequestBody Restaurant restaurant) {
        restaurant.setRestaurant_id(id);
        restaurantMapper.update(restaurant);
        return findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    Restaurant create(@RequestBody Restaurant restaurant) {
        restaurantMapper.insert(restaurant);
        return restaurant;


    }
}
