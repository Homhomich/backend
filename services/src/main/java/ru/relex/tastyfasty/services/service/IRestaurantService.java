package ru.relex.tastyfasty.services.service;

import ru.relex.tastyfasty.services.dto.restaurant.RestaurantDto;

import javax.validation.Valid;
import java.util.List;

public interface IRestaurantService {

    List<RestaurantDto> findRestaurants(String search);

    List<RestaurantDto> findRestaurantByAddress(String city, String street, int building);

    RestaurantDto findRestaurantById(int id);

    RestaurantDto create(@Valid RestaurantDto restaurantDto);

    RestaurantDto update(@Valid RestaurantDto restaurantDto);

    void remove(int id);
}
