package ru.relex.tastyfasty.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.tastyfasty.services.dto.restaurant.RestaurantDto;
import ru.relex.tastyfasty.services.service.IRestaurantService;

import java.util.List;

@RestController
@RequestMapping(
        //headers = { "Access-Control-Allow-Origin = *" },
        path = "/restaurants",
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
        return restaurantService.findRestaurants(search);
    }

    @GetMapping("/{id}")
    RestaurantDto findById(@PathVariable("id") int id) {
        return null;
    }

    @GetMapping("/{city}, /{street}, /{building}")  // TODO: 24.03.2020 is it working????))
    RestaurantDto findByAddress(
            @PathVariable("city") String city,
            @PathVariable("street") String street,
            @PathVariable("building") int building
    ) {
        return restaurantService.findRestaurantByAddress(city, street, building);
    }


    @PutMapping("/{id}")
    RestaurantDto update(@PathVariable("id") int id, @RequestBody RestaurantDto restaurant) {
        restaurant.setRestaurantId(id);
        restaurantService.update(restaurant);
        return findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    RestaurantDto create(@RequestBody RestaurantDto restaurant) {
        return restaurantService.create(restaurant);
    }

    @DeleteMapping("/{id}")
    void remove(@PathVariable("restaurantID") int id) {
        restaurantService.remove(id);
    }
}
