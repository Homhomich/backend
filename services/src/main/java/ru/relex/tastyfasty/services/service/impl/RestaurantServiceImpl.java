package ru.relex.tastyfasty.services.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.relex.tastyfasty.db.mapper.RestaurantMapper;
import ru.relex.tastyfasty.services.dto.restaurant.RestaurantDto;
import ru.relex.tastyfasty.services.mapstruct.RestaurantStruct;
import ru.relex.tastyfasty.services.service.IAddressService;
import ru.relex.tastyfasty.services.service.IRestaurantService;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class RestaurantServiceImpl implements IRestaurantService {

    private final RestaurantMapper restaurantMapper;
    private final RestaurantStruct restaurantStruct;

    private final IAddressService addressService;

    @Autowired
    public RestaurantServiceImpl(RestaurantMapper restaurantMapper, RestaurantStruct restaurantStruct, IAddressService addressService) {
        this.restaurantMapper = restaurantMapper;
        this.restaurantStruct = restaurantStruct;
        this.addressService = addressService;
    }


    @Override
    public List<RestaurantDto> findRestaurants(String search) {
        var restaurants = restaurantMapper.getRestaurants(search);
        return restaurantStruct.toDto(restaurants);
    }

    @Override
    public RestaurantDto findRestaurantByAddress(String city, String street, int building) {
        var restaurants = restaurantMapper.findByAddress(city, street, building);
        return restaurantStruct.toDto(restaurants);
    }

    @Override
    public RestaurantDto create(@Valid RestaurantDto restaurantDto) {
        var addressDto = addressService.create(restaurantDto.getRestaurantInfo().getAddress());
        var restaurant = restaurantStruct.fromDto(restaurantDto);
        System.err.println(addressDto.getId());
        restaurant.setAddress(addressDto.getId());
        restaurantMapper.insert(restaurant);
        return restaurantStruct.toDto(restaurant);
    }

    @Override
    public RestaurantDto update(@Valid RestaurantDto restaurantDto) {
        int addressId = restaurantMapper.findById(restaurantDto.getRestaurantId()).getAddress();
        restaurantDto.getRestaurantInfo().getAddress().setId(addressId);
        var restaurant = restaurantStruct.fromDto(restaurantDto);
        restaurantMapper.update(restaurant);
        return restaurantStruct.toDto(restaurant);
    }

    @Override
    public void remove(int restaurantID) {
        restaurantMapper.delete(restaurantID);
    }
}
